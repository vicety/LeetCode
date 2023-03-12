package main

import "fmt"
import "sync"

// MergeSort
func main() {
	sort(1, 10)
}

func sort(l int, r int) {
	var wg sync.WaitGroup
	wg.Add(1)
	_sort(l, r, &wg)
	wg.Wait()
}

func _sort(l int, r int, fatherWg *sync.WaitGroup) {
	fmt.Println("sorting ", l, " ", r)
	if l == r {
		fatherWg.Done()
		return
	}
	var wg sync.WaitGroup
	wg.Add(2)
	mid := (l + r + 1) / 2
	go _sort(l, mid-1, &wg)
	go _sort(mid, r, &wg)
	// block until ingest one element from channel
	wg.Wait()
	// merge
	// sorting from 3 to 5
	fmt.Println("merging ", l, " ", r)
	fatherWg.Done()
}

// Your last Python3 code is saved below:
// # print("Hello")

// # Your last C/C++ code is saved below:

// def sort(arr):

//   def _sort(arr, l, r):
//     if l == r:
//       return
//     mid = (l + r + 1) // 2
//     _sort(arr, l, mid - 1)
//     _sort(arr, mid, r)
//     tmp = [0] * (r - l + 1)
//     lptr = l
//     rptr = mid
//     ptr = 0
//     while lptr <= mid - 1 and rptr <= r:
//       if arr[lptr] < arr[rptr]:
//         tmp[ptr] = arr[lptr]
//         ptr += 1
//         lptr += 1
//       else:
//         tmp[ptr] = arr[rptr]
//         ptr += 1
//         rptr += 1

//     while lptr <= mid - 1:
//       tmp[ptr] = arr[lptr]
//       ptr += 1
//       lptr += 1
//     while rptr <= r:
//       tmp[ptr] = arr[rptr]
//       ptr += 1
//       rptr += 1
//     for i in range(len(tmp)):
//       arr[l + i] = tmp[i]

//   _sort(arr, 0, len(arr) - 1)

// arr = [9,7,5,3,1,0,2,4,6,8]
// sort(arr)
// print(arr)

// Your last Python3 code is saved below:
// # print("Hello")

// # Your last C/C++ code is saved below:

// def sort(arr):

//   def _sort(arr, l, r):
//     if l == r:
//       return
//     mid = (l + r + 1) // 2
//     _sort(arr, l, mid - 1)
//     _sort(arr, mid, r)
//     tmp = [0] * (r - l + 1)
//     lptr = l
//     rptr = mid
//     ptr = 0
//     while lptr <= mid - 1 and rptr <= r:
//       if arr[lptr] < arr[rptr]:
//         tmp[ptr] = arr[lptr]
//         ptr += 1
//         lptr += 1
//       else:
//         tmp[ptr] = arr[rptr]
//         ptr += 1
//         rptr += 1

//     while lptr <= mid - 1:
//       tmp[ptr] = arr[lptr]
//       ptr += 1
//       lptr += 1
//     while rptr <= r:
//       tmp[ptr] = arr[rptr]
//       ptr += 1
//       rptr += 1
//     for i in range(len(tmp)):
//       arr[l + i] = tmp[i]

//   _sort(arr, 0, len(arr) - 1)

// arr = [9,7,5,3,1,0,2,4,6,8]
// sort(arr)
// print(arr)
