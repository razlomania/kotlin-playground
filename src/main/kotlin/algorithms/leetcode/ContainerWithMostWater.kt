package algorithms.leetcode

import kotlin.math.max

fun maxArea(height: IntArray): Int {
    if (height.isEmpty()) return 0

    var result = 0
    var leftPointer = 0
    var rightPointer = height.size - 1

    while (leftPointer < rightPointer) {
        val area = (rightPointer - leftPointer)  * minOf(height[leftPointer], height[rightPointer])
        result = maxOf(result, area)

        if (height[leftPointer] > height[rightPointer]) {
            rightPointer -= 1
        } else {
            leftPointer += 1
        }
    }

    return result
}

fun maxPower(s: String): Int {
    var maxCount = 1
    var currentCount = 1

    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            currentCount++
        } else {
            maxCount = maxOf(maxCount, currentCount)
            currentCount = 1
        }
    }

    return maxOf(maxCount, currentCount)
}


fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    val s = "leetcode"
    println(maxPower(s))
}