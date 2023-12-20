fun calculateSum(array: IntArray, index: Int = 0): Int {
    return if (index == array.size) {
        0
    } else {
        array[index] + calculateSum(array, index + 1)
    }
}

fun recursiveNumElements(listOfMarks: List<Int>): Int {
    return if (listOfMarks.isEmpty()) {
        0
    } else
        1 + recursiveNumElements(listOfMarks.dropLast(1));
}

fun maxNumber(numbers: List<Int>): Int {
    var max: Int = numbers[0]
    for (num in numbers) {
        if (max < num)
            max = num
    }
    return max
}

tailrec fun binarySearchRecursive(input: IntArray, element: Int, min: Int, max: Int): Int {
    if (min > max) {
        return -1 // Element not found
    }

    val mid = min + (max - min) / 2

    return when {
        element < input[mid] -> binarySearchRecursive(input, element, min, mid - 1)
        element > input[mid] -> binarySearchRecursive(input, element, mid + 1, max)
        else -> mid // Element found
    }
}


fun main() {
    val arr = intArrayOf(2, 3, 7, 8, 9, 10)
    val listAr = listOf(1, 2, 3, 4, 5)
    val pos = binarySearchRecursive(arr, 3, 0, arr.size)

    println(pos)
}