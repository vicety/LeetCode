import sys

n_m = sys.stdin.readline().strip().split()
n = int(n_m[0])
m = int(n_m[1])

rules = []
done = False

for _ in range(m):
    nums_str = sys.stdin.readline().strip().split()
    c_set = set()
    for c in nums_str[0]:
        c_set.add(c)
    rules.append((nums_str[0], int(nums_str[1]), int(nums_str[2]), c_set))
    # if not done and int(nums_str[1]) == n:
    #     print(nums_str[0])
    #     done = True


def judgeStr(s):
    for (t, match, pos, c_set) in rules:
        cur_match = 0
        cur_pos = 0
        for i in range(len(s)):
            if s[i] == t[i]:
                cur_match += 1
            elif s[i] in c_set:
                cur_pos += 1
        if cur_match > match or cur_pos > pos:
            return False
    return True


def judgeFinal(s):
    for (t, match, pos, c_set) in rules:
        cur_match = 0
        cur_pos = 0
        for i in range(len(s)):
            if s[i] == t[i]:
                cur_match += 1
            elif s[i] in c_set:
                cur_pos += 1
        if cur_match != match or cur_pos != pos:
            return False
    return True


def dfs(now_s, cur_n):
    global done
    if done:
        return
    if cur_n == n:
        if judgeFinal(now_s):
            print(now_s)
            done = True
        return
    if not judgeStr(now_s):
        return
    for i in range(0, 9):
        dfs(now_s + chr(ord("0") + i), cur_n + 1)
        if done:
            return


if not done:
    dfs("", 0)
if not done:
    print("?")

# 当前一致几个，位置不同几个
# 不能大于target
