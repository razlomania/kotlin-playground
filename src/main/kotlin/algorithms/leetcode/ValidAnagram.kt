package algorithms.leetcode

fun isValidAnagram(first: String, second: String): Boolean {
    if (first.length != second.length) return false
    val firstFrequency = hashMapOf<Char, Int>()
    val secondFrequency = hashMapOf<Char, Int>()
    first.forEach {
        firstFrequency[it] = firstFrequency.getOrDefault(it, 0) + 1
    }

    second.forEach {
        secondFrequency[it] = secondFrequency.getOrDefault(it, 0) + 1
    }

    return firstFrequency.size == secondFrequency.size
}

fun main() {
    println(isValidAnagram("danger", "garden"))
}