package algorithms.leetcode

fun maxSubArray(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var currentSum = 0

    for (num in nums) {
        currentSum += num
        maxSum = maxOf(currentSum, maxSum)

        if (currentSum < 0) {
            currentSum = 0
        }
    }

    return maxSum
}


fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}