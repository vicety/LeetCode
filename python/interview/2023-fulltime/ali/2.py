def toNum(c):
    return ord(c) - ord('0')


# assume all str
def solve(A, B):
    A = A[::-1]  # 1234 -> 4321
    B = B[::-1]
    C = ""
    # assume A long, B short
    if len(A) < len(B):
        A, B = B, A

    carry = 0
    for i in range(len(B)):
        tmp = toNum(A[i]) + toNum(B[i]) + carry
        carry = tmp // 10
        tmp = tmp % 10
        C += str(tmp)

    for i in range(len(B), len(A)):
        tmp = toNum(A[i]) + carry
        carry = tmp // 10
        tmp = tmp % 10
        C += str(tmp)

    if carry:
        C += str(carry)

    return C[::-1]


print(solve("999000", "111"))
