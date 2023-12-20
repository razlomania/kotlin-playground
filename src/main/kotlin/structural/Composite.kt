package structural

fun main() {
    val trooper = StormTrooper(Rifle(), RegularLegs())

    val squad = Squad(listOf(trooper.copy(), trooper.copy(), trooper.copy()))

    squad.attackRebel(1, 2)

    val secondSquad = Squad(
        trooper.copy(),
        trooper.copy(),
        trooper.copy()
    )
}

class Squad(private val units: List<Trooper>) : Trooper {
    // not to create a val listOf<Troopers>
    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }
}