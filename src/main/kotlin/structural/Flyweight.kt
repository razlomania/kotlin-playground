package structural

import java.io.File

enum class Direction {
    LEFT, RIGHT
}

class TansanianSnail {
    val directionFacing = Direction.LEFT
    val sprites = listOf(File("snail-left.jpg"), File("snail-right.jpg"))

    val spritesList = List(8) {i ->
        File(
            when (i) {
                0 -> "snail-left.jpg"
                1 -> "snail-right.jpg"
                in 2..4 -> "snail-move-left-${i - 1}.jpg"
                else -> "snail-move-right${(4 - i)}.jpg"
            }
        )

    }

    // More information about snail here

    fun getCurrentSprite(): File {
        return when(directionFacing) {
            Direction.LEFT -> sprites[0]
            Direction.RIGHT -> sprites[1]
        }
    }
}

/*
* Each snail is represented by a 64x64 image. Assuming each color takes up exactly one byte, the single image will take
* up 4 KB of RAM in the memory. Since we have eight images for a snail, we need 32 KB of RAM for each one, which allows
* us to fit only 32 snails into 1 MB of memory.
*
* What do we do to generate thousands of them to be able to run on regular smartphone?
*
*  */

object SnailSprites {
    val sprites = List(8) { i ->
        File(
            when (i) {
                0 -> "snail-left.jpg"
                1 -> "snail-right.jpg"
                in 2..4 -> "snail-move-left-${i - 1}.jpg"
                else -> "snail-move-right${(4 - i)}.jpg"
            }
        )
    }
}

fun main() {
    // Flyweight allows us to create much more objects that otherwise possible
    val snails = List(10_000) {
        TansanianSnail()
    }
}

