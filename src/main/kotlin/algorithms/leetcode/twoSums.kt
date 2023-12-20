package algorithms.leetcode


fun twoSum(nums: IntArray, target: Int): IntArray {
    val indices = IntArray(2)
    val map: MutableMap<Int, Int> = HashMap()
    for (index in nums.indices) {
        println(target - nums[index])
        println(map)
        if (map.containsKey(target - nums[index])) {
            indices[1] = index
            indices[0] = map[target - nums[index]]!!
            return indices
        }
        println(map[nums[index]])
        map[nums[index]] = index
    }
    return indices
}

fun twoSumKotlin(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    nums.forEachIndexed { index, num ->
        val complement = target - num
        if (complement in map) {
            return intArrayOf(map[complement]!!, index)
        }
        map[num] = index
    }

    return intArrayOf(-1, -1) // Default value if no solution is found
}

fun main() {
    val result = twoSum(intArrayOf(4, 5 , 2, 9, 8), 11)
}