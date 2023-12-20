package algorithms.linkedList

data class Node(val value: Int, var nextNode: Node?) {
    override fun toString(): String {
        return "Node(value = $value, nextNode = $nextNode)"
    }
}

fun reverseLinkedListIterative(node: Node?): Node? {
    // First establish some pointers we'll be using to store state

    // We're going to be using prev to point to the previous value
    // of the linked list while we iterate through it, because we
    // can't look backwards, unlike a doubly linked list
    var prev: Node? = null

    // curr will represent the node we are currently looking at as
    // we iterate through the linked list
    var curr: Node? = node

    // This pointer will reference the next value in the linked
    // list so that we don't lose it during pointer manipulation
    var next: Node?

    // We're going to iterate through the whole list with curr as
    // our "index". It points to the current node we're manipulating.
    // With each iteration, we make curr equal the next node in the
    // linked list. This loop should terminate once we reach the end
    // of the input list
    while (curr != null) {
        // First save the reference to next node because we're
        // about to reset it
        next = curr.nextNode

        // Then we do the swap. The current node's next node should
        // point to the node that came before it
        curr.nextNode = prev

        // Now we need to advance the prev & curr pointers 1 node
        // forward so that we can keep appending the next node onto
        // prev, building up the reversed linked list
        prev = curr
        curr = next
    }

    // Now that curr is null we have iterated through every value of
    // the linked list and prev now points to the head of the reversed
    // linked list, so we return it
    return prev
}

fun main() {
    val singletonList = Node(value = 0, nextNode = null)
    val twoList = Node(0, nextNode = Node(value = 1, nextNode = null))
    val threeList = Node(0, nextNode = Node(value = 1, nextNode = Node(value = 2, nextNode = null)))
    val fourList = Node(0, nextNode = Node(value = 1, nextNode = Node(value = 2, nextNode = Node(value = 3, nextNode = null))))

    println("reversed null = ${reverseLinkedListIterative(null)}")
    println("reversed singletonList = $singletonList")
    println("reversed twoList = ${reverseLinkedListIterative(twoList)}")
    println("reversed threeList = ${reverseLinkedListIterative(threeList)}")
    println("reversed fourList = ${reverseLinkedListIterative(fourList)}")
}

