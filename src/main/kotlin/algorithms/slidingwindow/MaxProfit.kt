package algorithms.slidingwindow

import algorithms.binarytree.NumNode
import kotlin.math.max

fun findMaxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var left = 0
    var right = 1
    var maxProfit = 0

    while (right < prices.size) {
        if (prices[left] < prices[right]) {
            val profit = prices[right] - prices[left]
            maxProfit = maxOf(maxProfit, profit)
        } else {
            left = right
        }
        right++
    }

    return maxProfit
}

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(findMaxProfit(prices))
}