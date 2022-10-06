package structural

import kotlin.math.pow

/**
 * RoundHoles are compatible with RoundPegs.
 */

class RoundHole(private val radius: Double) {
    fun fits(peg: RoundPeg): Boolean {
        return radius >= peg.radius
    }
}

/**
 * RoundPegs are compatible with RoundHoles.
 */
open class RoundPeg(val radius: Double)

/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 */
class SquarePeg(private val width: Double) {

    val square: Double
        get() {
            return width.pow(2.0)
        }
}

/**
 * Adapter allows fitting square pegs into round holes.
 */
//class SquarePegAdapter(private val peg: SquarePeg) : RoundPeg() {
//    // Calculate a minimum circle radius, which can fit this peg.
//    override var radius: Double
//        get() {
//            val result: Double
//            // Calculate a minimum circle radius, which can fit this peg.
//            result = Math.sqrt(Math.pow(peg.getWidth() / 2, 2.0) * 2)
//            return result
//        }
//        set(radius) {
//            super.radius = radius
//        }
//}