from typing import List


def solve(s):
    ans: List[str] = []
    buf = ""
    i = 0
    while i < len(s):
        c = s[i]
        if c.isalpha():
            buf += c
        else:
            if buf:
                ans.append(buf)
                buf = ""
        i += 1
    if buf:
        ans += buf
    for i in range(len(ans)):
        ans[i] = ans[i][0].upper() + ans[i][1:]
    return " ".join(ans) + "."


# print(solve("abc def.0ji jlo..e ."))
# print(solve("1abc def.0ji jlo..e ."))
print(solve("&&&abc def.0ji jlo..e ."))
# print(solve("222234343"))
# print(solve("     "))
# print(solve(""))


# print("s"[1:])