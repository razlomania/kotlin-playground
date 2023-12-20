package algorithms.binarytree

import java.util.LinkedList
import java.util.Queue

fun main() {
    val a = Node('a')
    val b = Node('b')
    val c = Node('c')
    val d = Node('d')
    val e = Node('e')
    val f = Node('f')

    a.left = b
    a.right = c
    b.left = d
    b.right = e
    c.right = f

    val root = NumNode(2)
    val one = NumNode(2)
    val four = NumNode(2)
    val three = NumNode(3)
    val six = NumNode(6)

    root.left = one
    root.right = four
    four.left = three
    four.right = six

    // println(isTargetFoundBfs(a, 'd'))

    println(isValidBST(root))
}

fun isValidBST(root: NumNode?): Boolean {
    if (root == null) return true

    val queue: Queue<NumNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        current.left?.let {
            if (it.value >= current.value)
                return false
            else
                queue.offer(it)
        }
        current.right?.let {
            if (it.value <= current.value)
                return false
            else
                queue.offer(it)
        }
    }
    return true
}

fun isValidBtsRecursive(root: NumNode?): Boolean {
    fun isValidBtsRecursive(curr: NumNode?, low: Long, high: Long): Boolean =
        curr == null ||
                (curr.value > low
                        && curr.value < high
                        && isValidBtsRecursive(curr.left, low, curr.value.toLong())
                        && isValidBtsRecursive(curr.right, curr.value.toLong(), high))

    return isValidBtsRecursive(curr = root, low = Long.MIN_VALUE, high = Long.MAX_VALUE)
}

fun dfs(root: Node?): Array<Char> {
    if (root == null) return emptyArray<Char>()
    val leftValues = dfs(root.left)
    val rightValues = dfs(root.right)
    return arrayOf(root.value, *leftValues, *rightValues)
}

fun bfs(root: Node?): List<Char> {
    val values = mutableListOf<Char>()

    if (root == null) return values

    val queue: Queue<Node> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        values.add(current.value)

        current.left?.let { queue.offer(it) }
        current.right?.let { queue.offer(it) }
    }

    return values
}

fun isTargetFoundBfs(root: Node?, target: Char): Boolean {
    val values = mutableListOf<Char>()
    if (root == null) return false

    val queue: Queue<Node> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.value == target) return true
        values.add(current.value)

        current.left?.let { queue.offer(it) }
        current.right?.let { queue.offer(it) }
    }
    return false
}

fun isTargetValueFoundDfs(root: Node?, target: Char): Boolean {
    if (root == null) return false
    if (root.value == target) return true
    return isTargetValueFoundDfs(root.left, target) || isTargetValueFoundDfs(root.left, target)
}

fun dfsFindSum(root: NumNode?): Int {
    if (root == null) return 0
    return root.value + dfsFindSum(root.left) + dfsFindSum(root.right)
}

fun dfsFindMin(root: NumNode?): Int {
    if (root == null) return Int.MAX_VALUE
    val left = dfsFindMin(root.left)
    val right = dfsFindMin(root.right)

    return minOf(root.value, left, right)
}

fun dfsFindMaxRootToLeafPath(root: NumNode?): Int {
    if (root == null) return Int.MIN_VALUE
    if (root.isLeaf()) return root.value
    val max = maxOf(dfsFindMaxRootToLeafPath(root.left), dfsFindMaxRootToLeafPath(root.right))
    return root.value + max
}

fun preorderTraversal(root: NumNode?): List<Int> {
    if (root == null) return emptyList()

    val result = mutableListOf<Int>()
    result.add(root.value)
    val leftSide = preorderTraversal(root.left)
    val rightSide = preorderTraversal(root.right)
    result.addAll(leftSide)
    result.addAll(rightSide)

    return result
}