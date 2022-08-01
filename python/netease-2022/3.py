n = int(input())

odd_layer_sum = 0
even_layer_sum = 0
now = 1
odd_layer = True
acc = 0
while True:
    if acc + now > n:
        if odd_layer:
            odd_layer_sum += (n - acc)
        else:
            even_layer_sum += (n - acc)
        break
    acc += now
    if odd_layer:
        odd_layer_sum += now
    else:
        even_layer_sum += now
    odd_layer = not odd_layer

    now *= 2

ans = []
i = 0
now = 1
odd_now = 1
even_now = 2

if odd_layer_sum <= even_layer_sum:  # 奇数层比偶数层节点少
    use_even = True  # 第一层消耗偶数
else:
    use_even = False

while i <= n:
    for j in range(1, now + 1):
        if i + j > n:
            break
        if use_even:
            if even_now <= n:
                ans.append(even_now)
                even_now += 2
            else:
                ans.append(odd_now)
                odd_now += 2
        else:
            if odd_now <= n:
                ans.append(odd_now)
                odd_now += 2
            else:
                ans.append(even_now)
                even_now += 2
    use_even = not use_even
    i += now
    now *= 2

# print(odd_layer_sum, even_layer_sum)
print(" ".join(list(map(lambda x: str(x), ans))))
