import sys

m_n_str = sys.stdin.readline().strip().split()
n = int(m_n_str[0])
m = int(m_n_str[1])

xyz = sys.stdin.readline().strip().split()
cut_str = sys.stdin.readline().strip().split()
cut = list(map(lambda t: int(t), cut_str))

x_set = set()
x = [0, n]
y_set = set()
y = [0, n]
z_set = set()
z = [0, n]

ans = 0

for i in range(m):
    if xyz[i] == 'x':
        if cut[i] in x_set:
            continue
        x_set.add(cut[i])
        for j in range(len(x) - 1):
            if x[j] < cut[i] and x[j+1] > cut[i]:
                x = x[:j+1] + [cut[i]] + x[j+1:]
                break
    elif xyz[i] == 'y':
        if cut[i] in y_set:
            continue
        y_set.add(cut[i])
        for j in range(len(y) - 1):
            if y[j] < cut[i] and y[j+1] > cut[i]:
                y = y[:j+1] + [cut[i]] + y[j+1:]
                break
    else:
        if cut[i] in z_set:
            continue
        z_set.add(cut[i])
        for j in range(len(z) - 1):
            if z[j] < cut[i] and z[j+1] > cut[i]:
                z = z[:j+1] + [cut[i]] + z[j+1:]
                break

    xmax = -1
    for j in range(len(x) - 1):
        xmax = max(xmax, x[j + 1] - x[j])
    ymax = -1
    for j in range(len(y) - 1):
        ymax = max(ymax, y[j + 1] - y[j])
    zmax = -1
    for j in range(len(z) - 1):
        zmax = max(zmax, z[j + 1] - z[j])
    ans = xmax * ymax * zmax
    print(ans)