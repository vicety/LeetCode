import sys


def isBad(seg):
    if not len(seg):
        return False

    up = None
    nowCh = seg[0]
    idx = 1
    cnt = 1
    triggered = False
    while idx < len(seg):
        ch = seg[idx]
        if ord(ch) != ord(nowCh) + 1 and ord(ch) != ord(nowCh) - 1:
            return False
        elif up is True and ord(ch) == ord(nowCh) - 1:
            return False
        elif up is False and ord(ch) == ord(nowCh) + 1:
            return False
        elif (up is None or up is False) and ord(ch) == ord(nowCh) - 1:
            up = False
            nowCh = ch
            cnt += 1
            if cnt == 3:
                triggered = True
        elif (up is None or up is True) and ord(ch) == ord(nowCh) + 1:
            up = True
            nowCh = ch
            cnt += 1
            if cnt == 3:
                triggered = True
        else:
            return False
        idx += 1

    return triggered


# n = sys.stdin.readline().strip().split()
n = int(sys.stdin.readline().strip())
for _ in range(n):
    line = sys.stdin.readline().strip()
    triggered = False
    seg = ""
    for i in range(len(line)):
        if triggered:
            break
        ch = line[i]
        if ord(ch) > ord('9') or ord(ch) < ord('0'):
            if isBad(seg):
                print("yes")
                triggered = True
                break
            seg = ""
        else:
            seg += ch

    if not triggered and isBad(seg):
        print("yes")
        triggered = True

    if not triggered:
        print("no")

    #     if brk:
    #         break
    #     up = None
    #     nowCh = line[i]
    #     cnt = 1
    #     idx = i + 1
    #     while idx < len(line):
    #         ch = line[idx]
    #         if ord(ch) > ord('9') or ord(ch) < ord('0'):
    #             break
    #         if (up is None or up is True) and ord(ch) == ord(nowCh) + 1:
    #             up = True
    #             cnt += 1
    #             idx += 1
    #             nowCh = ch
    #             if cnt == 3:
    #                 print("yes")
    #                 brk = True
    #                 break
    #         if (up is None or up is False) and ord(ch) == ord(nowCh) - 1:
    #             up = False
    #             cnt += 1
    #             idx += 1
    #             nowCh = ch
    #             if cnt == 3:
    #                 print("yes")
    #                 brk = True
    #                 break
    #         else:
    #             break
    # if not brk:
    #     print("no")
