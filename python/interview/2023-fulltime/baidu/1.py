s = input()

y = set()
y.add('a')
y.add('e')
y.add('i')
y.add('o')
y.add('u')


def solve(s):
    if len(s) < 5:
        return 0
    st = set()
    ans = 0
    for i in range(len(s) - 4):
        slice = s[i:i + 5]
        st.clear()
        st.add(slice[0])
        st.add(slice[1])
        st.add(slice[2])
        st.add(slice[3])
        st.add(slice[4])
        if len(st) != 5:
            continue
        if not slice[1] in y or not slice[2] in y or not slice[4] in y:
            continue
        if slice[0] in y or slice[3] in y:
            continue
        ans += 1
    return ans


print(solve(s))
