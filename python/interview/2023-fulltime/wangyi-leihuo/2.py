import sys

valid_set = set()
for item in ["#R", "#G", "#B", "#K", "#Y", "#W", "#P"]:
    valid_set.add(item)
valid_char = set()
for item in "0123456789ABCDEF":
    valid_char.add(item)


def isValidColor(s, st):
    # [R|G|B|K|Y|W|P] #C XX XX XX
    ptr = st
    if ptr + 1 < len(s) and s[st:st + 2] in valid_set:
        return s[st:st + 2]
    if ptr + 7 < len(s):
        seg = s[st:st + 8]
        if seg[0:2] != '#C':
            return None
        for i in range(2, 8):
            if seg[i] not in valid_char:
                return None
        return seg


def isEnd(s, st):
    ptr = st
    if ptr + 1 < len(s) and s[st:st + 2] == "#n":
        return True
    return False


colorToStrDict = {
    "#R": "FF0000",
    "#G": "00C932",
    "#B": "0000FF",
    "#K": "000000",
    "#Y": "FFFF00",
    "#W": "FFFFFF",
    "#P": "FF88FF"
}


def colorToStr(s):
    if colorToStrDict.get(s) is not None:
        return colorToStrDict[s]
    return s[2:]


def solve():
    n = int(input())
    for _ in range(n):
        text = sys.stdin.readline().strip()

        printed = False
        buf = ""
        now_color = []
        ptr = 0
        while ptr < len(text):
            c = text[ptr]
            if c == '#':
                # 是否需要合并相同颜色？
                if isEnd(text, ptr):
                    if len(buf) > 0 and len(now_color) > 0:
                        printed = True
                        print("{} {}".format(buf, colorToStr(now_color[-1])))
                        buf = ""
                    if len(now_color) > 0:
                        now_color.pop()
                    ptr += 2
                    continue
                color = isValidColor(text, ptr)
                if color is not None:
                    if len(now_color) > 0 and len(buf) > 0:
                        printed = True
                        print("{} {}".format(buf, colorToStr(now_color[-1])))
                        buf = ""
                    now_color.append(color)
                    ptr += len(color)
                    continue
                else:
                    if len(now_color) > 0:
                        buf += c
            else:
                if len(now_color) > 0:
                    buf += c
            ptr += 1
        if len(now_color) > 0 and len(buf) > 0:
            printed = True
            print("{} {}".format(buf, colorToStr(now_color[-1])))
        if not printed:
            print("empty")


solve()
