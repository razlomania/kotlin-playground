class House private constructor(
    val walls: Int,
    val doors: Int,
    val windows: Int,
    val hasGarage: Boolean?,
    val hasSwimmingPool: Boolean?,
    val hasGarden: Boolean?
) {
    class Builder {
        var walls: Int? = null
        var doors: Int? = null
        var windows: Int? = null
        var hasGarage: Boolean? = false
        var hasSwimmingPool: Boolean? = false
        var hasGarden: Boolean? = false
        fun walls(walls: Int) = apply { this.walls = walls }
        fun doors(doors: Int) = apply { this.doors = doors }
        fun windows(windows: Int) = apply { this.windows = windows }
        fun hasGarage(hasGarage: Boolean) = apply { this.hasGarage = hasGarage }
        fun hasSwimmingPool(hasSwimmingPool: Boolean) = apply { this.hasSwimmingPool = hasSwimmingPool }
        fun hasGarden(hasGarden: Boolean) = apply { this.hasGarden = hasGarden }
        fun build() = House(
            walls!!,
            doors!!,
            windows!!,
            hasGarage,
            hasSwimmingPool,
            hasGarden
        )
        // fun randomBuilder()
    }
}

val newHouse = House.Builder()
    .doors(1)
    .walls(4)
    .windows(6)
    .hasGarden(true)





data class HouseDataClass(
    val walls: Int = 4,
    val doors: Int = 1,
    val windows: Int,
    val hasGarage: Boolean = false,
    val hasSwimmingPool: Boolean = false,
    val hasGarden: Boolean = false
)

val dataHouse = HouseDataClass(
    walls = 4,
    doors = 2,
    windows = 5
)