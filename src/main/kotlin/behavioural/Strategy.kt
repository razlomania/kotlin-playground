package behavioural

fun main() {
    val numbers = arrayOf(4, 56, 12, 79, 25, 2)
    sortBasic("Bubble", numbers)

    sort(BubbleSortStrategy(), numbers)
    sort(MergeSortStrategy(), numbers)
}

fun sortBasic(algorithm: String, numbers: Array<Int>) {
    if (algorithm == "Bubble") {
        println("Numbers are sorted using Bubble sort.")
        // bubble sort algorithm
    } else if (algorithm == "Merge") {
        println("Numbers are sorted using Merge sort.")
        // merge sort algorithm
    } else {
        throw IllegalArgumentException()
    }
}


fun sortIncapsulated(algorithm: String, numbers: Array<Int>) {
    when (algorithm) {
        "Bubble" -> bubbleSort(numbers)
        "Merge" -> mergeSort(numbers)
        else -> throw IllegalArgumentException()
    }
}

fun bubbleSort(numbers: Array<Int>) {
    println("Numbers are sorted using Bubble sort.")
}

fun mergeSort(numbers: Array<Int>) {
    println("Numbers are sorted using Merge sort.")
}


interface SortStrategy {
    fun sort(numbers: Array<Int>)
}

class BubbleSortStrategy : SortStrategy {
    override fun sort(numbers: Array<Int>) {
        println("Numbers are sorted using Bubble sort.")
    }
}

class MergeSortStrategy: SortStrategy {
    override fun sort(numbers: Array<Int>) {
        println("Numbers are sorted using Merge sort.")
    }
}

fun sort(sortStrategy: SortStrategy, numbers: Array<Int>) {
    sortStrategy.sort(numbers)
}