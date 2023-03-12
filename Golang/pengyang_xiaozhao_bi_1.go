package main

import (
	"fmt"
	"sync"
)

func main() {
	var n int
	_, err := fmt.Scanf("%d", &n)
	if err != nil {
		panic(err)
	}

	zeroToOdd := make(chan int, 1)
	oddToZero := make(chan int, 1)
	zeroToEven := make(chan int, 1)
	evenToZero := make(chan int, 1)

	var wg sync.WaitGroup
	wg.Add(3)

	// zero thread
	go func() {
		for {
			var num int
			select {
			case num = <-evenToZero:
			case num = <-oddToZero:
			}

			if num == n {
				zeroToOdd <- -1
				zeroToEven <- -1
				wg.Done()
				break
			}

			fmt.Printf("0")
			if num%2 == 0 {
				zeroToOdd <- num + 1
			} else {
				zeroToEven <- num + 1
			}
		}
	}()

	// even thread
	go func() {
		for {
			num := <-zeroToEven
			if num == -1 {
				wg.Done()
				break
			}
			fmt.Printf("%d", num)
			evenToZero <- num
		}
	}()

	// odd thread
	go func() {
		for {
			num := <-zeroToOdd
			if num == -1 {
				wg.Done()
				break
			}
			fmt.Printf("%d", num)
			oddToZero <- num
		}
	}()

	evenToZero <- 0
	wg.Wait()
}