def solution(S, X, Y):
    # write your code in Python 3.6
    dist = []
    for i in range(len(X)):
        dist += [(X[i] ** 2 + Y[i] ** 2, S[i])]
    dist.sort()
    vis = set()
    cur_d = -1
    cur_d_sz = 0
    for i in range(len(X)):
        d, tag = dist[i]
        if d == cur_d:
            cur_d_sz += 1
        else:
            cur_d = d
            cur_d_sz = 1
        if tag in vis:
            return len(vis) - (cur_d_sz - 1)
        vis.add(tag)
    return len(vis)