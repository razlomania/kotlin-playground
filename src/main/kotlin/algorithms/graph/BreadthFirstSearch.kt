package algorithms.graph

import java.util.*

class Graph2(private val graph: Map<Int, List<Int>>) {

    fun shortestPath(start: Int, target: Int): Int {
        val queue: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()
        var numberOfEdges = 0

        queue.offer(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current == target) {
                return numberOfEdges
            }

            val neigbours = graph[current] ?: emptyList()
            neigbours.forEach {
                if(!visited.contains(it)){
                    queue.offer(it)
                    visited.add(it)
                    numberOfEdges ++
                }
            }
        }
        return numberOfEdges
    }

    fun hasPath(start: Int, end: Int): Boolean {
        val queue: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()

        queue.offer(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current == end) {
                return true
            }

            val neighbors = graph[current] ?: emptyList()
            for (neighbor in neighbors) {
                if (neighbor !in visited) {
                    queue.offer(neighbor)
                    visited.add(neighbor)
                }
            }
        }

        return false
    }
}

fun main() {
    val graph = Graph2(
        mapOf(
            0 to listOf(8, 1, 5),
            1 to listOf(0),
            5 to listOf(0, 8),
            8 to listOf(0, 5),
            2 to listOf(3, 4),
            3 to listOf(2, 4),
            4 to listOf(3, 2),
        )
    )


    // val hasPath = graph.hasPath(startNode, endNode)
    val shortest = graph.shortestPath(0, 5)
    println(shortest)

}
