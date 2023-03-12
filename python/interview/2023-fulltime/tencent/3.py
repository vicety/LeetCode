n = input()
arr = list(map(int, input().split(' ')))
l = 0
r = len(arr) - 1

ans = []
big = True
while l <= r:
    if big:
        if arr[l] > arr[r]:
            ans.append(arr[l])
            l += 1
        else:
            ans.append(arr[r])
            r -= 1
    else:
        if arr[l] > arr[r]:
            ans.append(arr[r])
            r -= 1
        else:
            ans.append(arr[l])
            l += 1

    big = not big

print(" ".join(list(map(lambda x: str(x), ans))))