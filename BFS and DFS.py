graph = {
    "A" : [False, "G", "F", "C", "B"],
    "B" : [False, "A", "D"],
    "C" : [False, "A", "E", "D"],
    "D" : [False, "C", "E", "B", "K"],
    "E" : [False, "F", "C", "I", "D", "K"],
    "F" : [False, "A", "G", "H", "E", "I"],
    "G" : [False, "A", "F", "H"],
    "H" : [False, "G", "F", "I", "J", "K"],
    "I" : [False, "F", "H", "E", "K"],
    "J" : [False, "H", "K"],
    "K" : [False, "H", "E", "I", "J", "D"],
}

from collections import deque
import copy

def BFS_or_DFS(isBFS, graph, start, goal):
    g = copy.deepcopy(graph)
    g[start][0] = True
    path = []
    queue = deque([start])
    while queue and goal not in path:
        if isBFS == True:
            node = queue.popleft()
        else:
            node = queue.pop()
        path.append(node)
        for n in g[node][1:]:
            if g[n][0] == False:
                g[n][0] = True
                queue.append(n)
    if goal not in path:
        return "Goal not found!"
    return path

print("BFS: ", BFS_or_DFS(True, graph, "A", "K"))
print("DFS: ", BFS_or_DFS(False, graph, "A", "K"))