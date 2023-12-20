package algorithms.graph

import kotlin.math.sign

class Graph(private val graph: Map<Int, List<Int>>) {

    fun largestComponent(): Int {
        val visited = mutableSetOf<Int>()
        var largest = 0

        for (currentNode in graph.keys) {
            if (!visited.contains(currentNode)) {
                val temp = dfsWithCount(currentNode, visited)
                if (temp > largest) {
                    largest = temp
                }
            }
        }

        return largest
    }

    private fun dfsWithCount(current: Int, visited: MutableSet<Int>): Int {
        visited.add(current)
        var counter = 1

        graph[current]?.forEach {
            if (!visited.contains(it)) {
                counter += dfsWithCount(it, visited)
            }
        }
        return counter
    }

    fun conComponentsCount(): Int {
        val visited = mutableSetOf<Int>()
        var count = 0

        for (currentNode in graph.keys) {
            if (!visited.contains(currentNode)) {
                customDfs(currentNode, visited)
                count++
            }
        }

        return count
    }

    private fun customDfs(current: Int, visited: MutableSet<Int>) {
        visited.add(current)

        graph[current]?.forEach {
            if (!visited.contains(it)) {
                customDfs(it, visited)
            }
        }
    }


    fun connectedComponents(): Int {
        val visited = mutableSetOf<Int>()
        var componentCount = 0

        for (vertex in graph.keys) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited)
                componentCount++
            }
        }

        return componentCount
    }

    private fun dfs(node: Int, visited: MutableSet<Int>) {
        visited.add(node)

        graph[node]?.forEach {
            if (!visited.contains(it)) {
                dfs(it, visited)
            }
        }
    }

    fun hasPath(start: Int, target: Int): Boolean {
        return hasPathDfs(start, target)
    }

    private fun hasPathDfs(start: Int, target: Int): Boolean {
        if (start == target) return true

        val neighbours = graph[start] ?: emptyList()
        neighbours.forEach {
            if (hasPath(it, target)) return true
        }

        return false
    }
}

fun main() {
    val graph = Graph(
//        mapOf(
//            0 to listOf(8, 1, 5),
//            1 to listOf(0),
//            5 to listOf(0, 8),
//            8 to listOf(0, 5),
//            2 to listOf(3, 4),
//            3 to listOf(2, 4),
//            4 to listOf(3, 2),
//        )
        mapOf(
            0 to listOf(1, 2),
            2 to listOf(3, 4),
            5 to listOf(6)
        )
    )

    val grid = arrayOf(
        charArrayOf('L', 'W', 'W', 'L'),
        charArrayOf('L', 'L', 'W', 'L'),
        charArrayOf('W', 'W', 'W', 'L'),
        charArrayOf('L', 'L', 'L', 'L')
    )

    val result = minimumIsland(grid)
    println("Min island: $result")
}

fun minimumIsland(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var minIslandSize = Int.MAX_VALUE

    fun dfs(row: Int, col: Int): Int {
        if (row in 0 until rows && col in 0 until cols && grid[row][col] == 'L') {
            grid[row][col] = 'W'

            val size = 1 +
                    dfs(row - 1, col) +
                    dfs(row + 1, col) +
                    dfs(row, col - 1) +
                    dfs(row, col + 1)

            minIslandSize = minOf(minIslandSize, size)
            return size
        }
        return 0
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 'L') {
                minIslandSize = minOf(minIslandSize, dfs(i, j))
            }
        }
    }
    return if (minIslandSize == Int.MAX_VALUE) 0 else minIslandSize
}


fun numberOfIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0


    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun dfs(row: Int, col: Int) {
        if (row in 0 until rows && col in 0 until cols && grid[row][col] == 'L') {
            grid[row][col] = 'W' // mark as visited

            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)
        }
    }

    for (i in 0 until rows)
        for (j in 0 until cols) {
            if (grid[i][j] == 'L')
                count++
            dfs(i, j)
        }

    return count
}