package algorithms.doubleLinkedList

class DoublyLinkedList(value: Int) {
    private var head: Node?
    private var tail: Node?
    private var length: Int

    inner class Node(var value: Int) {
        var next: Node? = null
        var prev: Node? = null
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
        println("\nDoubly Linked List:")
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
            newNode.prev = tail
            tail = newNode
        }
        length++
    }

    fun swapFirstLast() {
        if (length < 2) return
        val temp = head!!.value
        head!!.value = tail!!.value
        tail!!.value = temp
    }

    fun reverse() {
        var current = head;
        var temp: DoublyLinkedList.Node? = null;

        while (current != null) {
            temp = current.prev
            current.prev = current.next
            current.next = temp
            current = current.prev
        }

        temp = head
        head = tail
        tail = temp
    }
}

fun main() {
    val list = DoublyLinkedList(1)
    val updated = list.apply {
        append(3)
        append(9)
        append(4)
    }

    updated.reverse().run { updated.printAll() }
}

