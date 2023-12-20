package algorithms.linkedList

class LinkedList(value: Int) {
    private var head: Node?
    private var tail: Node?
    private var length: Int

    inner class Node(var value: Int) {
        var next: Node? = null
    }

    init {
        val newNode: Node = Node(value)
        head = newNode
        tail = newNode
        length = 1
    }

    fun printList() {
        var temp = head
        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }

    fun printAll() {
        if (length == 0) {
            println("Head: null")
            println("Tail: null")
        } else {
            println("Head: " + head!!.value)
            println("Tail: " + tail!!.value)
        }
        println("Length:$length")
        println("\nLinked List:")
        if (length == 0) {
            println("empty")
        } else {
            printList()
        }
    }

    fun makeEmpty() {
        head = null
        tail = null
        length = 0
    }

    fun append(value: Int) {
        val newNode: Node = Node(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            tail = newNode
        }
        length++
    }

    fun removeDuplicates() {
        val values: MutableSet<Int> = HashSet()
        var previous: Node? = null
        var current = head
        while (current != null) {
            if (values.contains(current.value)) {
                previous!!.next = current.next
                length -= 1
            } else {
                values.add(current.value)
                previous = current
            }
            current = current.next
        }
    }

    fun findKthFromEnd(k: Int): Node? {
        var slow: Node? = head
        var fast: Node? = head
        for (i in 0 until k) {
            if (fast == null) {
                return null
            }
            fast = fast.next
        }
        while (fast != null) {
            slow = slow?.next
            fast = fast.next
        }
        return slow
    }

    fun findMiddleNode(): Node? {
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }

    fun reverseBetween1(n: Int, m: Int) {
        if (head == null) {
            return
        }
        var dummy = Node(0)
        dummy.next = head;
        var prev = dummy

        for (i in 0 until m) {
            prev = prev?.next!!
        }

        val current = prev.next
        for (i in 0 until n - m) {
            val temp: Node = current?.next!!
            current?.next = temp.next
            temp.next = prev.next
            prev.next = temp
        }

        head = dummy.next
    }


    fun reverseBetween(m: Int, n: Int) {
        // Return if the linked list is empty
        if (head == null) return

        // Create a dummy node and connect it to head
        val dummy = Node(0)
        dummy.next = head
        var prev = dummy

        // Move prev to the node before sublist start
        for (i in 0 until m) {
            prev = prev?.next!!
        }

        // Initialize current to the first node in sublist
        val current: Node = prev?.next!!

        // Reverse the sublist
        for (i in 0 until n - m) {
            // Initialize temp to the next node in sublist
            val temp: Node = current?.next!!
            // Skip temp in the original sublist order
            current.next = temp.next
            // Reverse the order of temp and current
            temp.next = prev.next
            // Update prev's next to maintain reversed order
            prev.next = temp
        }

        // Update the head of the entire linked list
        head = dummy.next
    }
}

fun main() {
    val list = LinkedList(1)
    val updated = list.apply {
        append(1)
        append(2)
        append(6)
        append(9)
        append(4)
    }

    // updated.removeDuplicates().run { updated.printAll() }

    updated.reverseBetween(2, 4).run { updated.printAll() }
}