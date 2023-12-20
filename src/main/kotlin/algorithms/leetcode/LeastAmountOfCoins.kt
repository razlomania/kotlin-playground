package algorithms.leetcode

fun findLeastAmountOfCoins(coins: IntArray, arrayLength: Int, sum: Int): Int {
    if (sum == 0) return 0

    var amount = Int.MAX_VALUE

    // Try every coin that has smaller value than V
    for (i in 0 until arrayLength) {
        if (coins[i] <= sum) {
            val sub_res = findLeastAmountOfCoins(coins, arrayLength, sum - coins[i])

            // Check for INT_MAX to avoid overflow and see if
            // result can minimized
            if (sub_res != Int.MAX_VALUE && sub_res + 1 < amount) amount = sub_res + 1
        }
    }

    return amount
}

fun minCoins(coins: IntArray, m: Int, V: Int): Int {
    // base case
    if (V == 0) return 0

    // Initialize result
    var res = Int.MAX_VALUE

    // Try every coin that has smaller value than V
    for (i in 0 until m) {
        if (coins[i] <= V) {
            val sub_res = minCoins(coins, m, V - coins[i])

            // Check for INT_MAX to avoid overflow and see if
            // result can minimized
            if (sub_res != Int.MAX_VALUE && sub_res + 1 < res) res = sub_res + 1
        }
    }
    return res
}

fun minC(coins: IntArray, m: Int, target: Int): Int {
    val memo = mutableMapOf<Int, Int>()

    fun minCoinsHelper(target: Int): Int {
        if (target == 0) return 0
        if (memo.containsKey(target)) return memo[target]!!

        var res = Int.MAX_VALUE

        for (i in 0 until m) {
            if (coins[i] <= target) {
                val sub_res = minCoinsHelper(target - coins[i])
                if (sub_res != Int.MAX_VALUE && sub_res + 1 < res) res = sub_res + 1
            }
        }

        memo[target] = res
        return res
    }

    val result = minCoinsHelper(target)
    return if (result == Int.MAX_VALUE) -1 else result

}


fun main() {
    println(minCoins(intArrayOf(50,25,10,5), 4, 100))
}