object SingletonKotlin {
    private var counter: Int = 0

    fun getNextInt(): Int{
        return counter++
    }
}




fun main() {
    val first = SingletonKotlin
    val second = SingletonKotlin

    println(first == second)
    println(first.getNextInt())
    println(second.getNextInt())
}