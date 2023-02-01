package structural

fun main() {
    fun christmasTreeWithBubbleLights() {

        val christmasTree = BubbleLights(PineChristmasTree())
        val decoratedChristmasTree = christmasTree.decorate()
        println(decoratedChristmasTree)
    }

    fun christmasTreeWithGarlands() {

        val christmasTree = Garlands(PineChristmasTree())
        val decoratedChristmasTree = christmasTree.decorate()
        println(decoratedChristmasTree)
    }
}

interface ChristmasTree {

    fun decorate(): String
}

class PineChristmasTree : ChristmasTree {

    override fun decorate() = "Pine christmas tree"
}

/*
* When using composition to implement the Decorator pattern, we’ll need an abstract
* class that will act as the composer or decorator for our target object
*/
abstract class TreeDecorator
    (private val tree: ChristmasTree) : ChristmasTree {

    override fun decorate(): String {
        return tree.decorate()
    }
}

/*
* We’ll now create the decorating element. This decorator will extend our abstract TreeDecorator
* class and will modify its decorate() method according to our requirement:
*/

class BubbleLights(tree: ChristmasTree) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithBubbleLights()
    }

    private fun decorateWithBubbleLights(): String {
        return " with Bubble Lights"
    }
}

class Tinsel(tree: ChristmasTree) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithTinsel()
    }

    private fun decorateWithTinsel(): String {
        return " with Tinsel"
    }
}

/* The Delegation pattern has proven to be a good alternative to implementation inheritance,
* and Kotlin supports it natively, requiring zero boilerplate code.
* This feature makes it easy to create decorators using class delegation with the use of the by keyword.

* We’ll now define the class that can implement the ChristmasTree
* interface by delegating the decorator() method to a specified object
*/
class Garlands(private val tree: ChristmasTree) : ChristmasTree by tree {

    override fun decorate(): String {
        return tree.decorate() + decorateWithGarlands()
    }

    private fun decorateWithGarlands(): String {
        return " with Garlands"
    }
}