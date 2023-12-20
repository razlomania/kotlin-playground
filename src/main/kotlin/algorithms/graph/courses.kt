package algorithms.graph


fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (prerequisites.size == 0) return true
    val setOfValue = mutableSetOf<Int>()
    val visitedNodes: MutableSet<Int> = mutableSetOf()
    if (!prerequisites.all { it[0] != it[1] }) return false

    if (dfs(prerequisites, prerequisites[0][0], prerequisites[0][1], visitedNodes) == -1) return false

    prerequisites.forEach {
        setOfValue.add(it[0])
        setOfValue.add(it[1])
    }

    return numCourses >= setOfValue.size
}

private fun dfs(graph: Array<IntArray>, start: Int, next: Int, visitedNodes: MutableSet<Int>): Int {
    visitedNodes.add(start)
    visitedNodes.add(next)
    // if (start == next) return -1

    for (x in graph) {
        if (x[0] == next) {
            return if (visitedNodes.contains(x[1])) -1 else
                dfs(graph, x[0], x[1], visitedNodes)
        }
    }
    return next
}


fun main() {
    val a: Array<IntArray> = arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(4, 4), intArrayOf(3, 2))
    println(canFinish(5, a))
}