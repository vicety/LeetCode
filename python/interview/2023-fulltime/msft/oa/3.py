# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A, B, S):
    if len(A) > S:
        return False
    tups = []
    for i in range(len(A)):
        tups.append((A[i], B[i]))

    def dfs(now, usedEdge, currentGraph):
        for edgeId in currentGraph[now]:
            if edgeId in usedEdge:
                continue
            usedEdge.add(edgeId)
            st, ed = tups[edgeId]
            dfs(ed, usedEdge, currentGraph)

    visSlot = [False] * (S + 1)
    currentEdges = set()
    vis = [False] * (S + 1)  # 当前访问过的点
    for tupId, (a, b) in enumerate(tups):
        currentEdges.add(tupId)

        if visSlot[a] and visSlot[b]:
            return False

        # 找到环后，从环上任意位置出发，可达的位置都被使用
        if vis[a] and vis[b]:
            # 从 a 开始dfs，干掉所有连通的区域
            usedEdge = set()
            currentGraph = dict()
            # 用当前访问的边构建图
            for tupId in currentEdges:
                a, b = tups[tupId]
                if currentGraph.get(a) is None:
                    currentGraph[a] = []
                if currentGraph.get(b) is None:
                    currentGraph[b] = []
                currentGraph[a].append(tupId)
                currentGraph[b].append(tupId)
            dfs(a, usedEdge, currentGraph)
            for edgeId in usedEdge:
                st, ed = tups[edgeId]
                visSlot[st] = True
                visSlot[ed] = True
            # dfs过的边不会再用上，减轻下次构建图的压力
            currentEdges = currentEdges.difference(usedEdge)

        vis[a] = True
        vis[b] = True

    return True


print(solution([1, 1, 3], [2, 2, 1], 3))
print(solution([3, 2, 3, 1], [1, 3, 1, 2], 3))
print(solution([2, 5, 6, 5], [5, 4, 2, 2], 8))
print(solution([1, 2, 1, 6, 8, 7, 8], [2, 3, 4, 7, 7, 8, 7], 10))

# a = set()
# a.add(1)
# a.add(2)
# b = set()
# b.add(2)
# b.add(3)
# print(a.difference(b))
