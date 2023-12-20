package algorithms.binarytree

class Node(val value: Char) {
    var left: Node? = null
    var right: Node? = null
}

class NumNode(val value: Int) {
    var left: NumNode? = null
    var right: NumNode? = null

    fun isLeaf(): Boolean {
        return left == null && right == null
    }
}