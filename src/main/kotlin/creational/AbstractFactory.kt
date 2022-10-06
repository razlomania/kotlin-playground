
interface AbstractFactory<T> {
    fun create(type: String): T
}

interface AnotherVehicle {
    val name: String
    val amountOfWheels: Int
    val colour: String
}

class AnotherCar(
    override val name: String,
    override val amountOfWheels: Int,
    override val colour: String,
    val passengers: Int
) : AnotherVehicle

class AnotherBike(
    override val name: String,
    override val amountOfWheels: Int,
    override val colour: String,
    val type: String
) : AnotherVehicle

class VehicleFactory : AbstractFactory<AnotherVehicle> {
    override fun create(type: String): AnotherVehicle {
        return when (type) {
            "Car" -> AnotherCar("Honda", 4, "red", 4)
            "Bike" -> AnotherBike("Canondale", 2, "blue", "ebike")
            else -> throw IllegalArgumentException("Unknown type!")
        }
    }
}

interface Animal {
    val name: String
    val category: String
    val colour: String
}

class LandAnimal(
    override val name: String,
    override val category: String,
    override val colour: String,
    val numberOfLegs: Int,
) : Animal


class WaterAnimal(
    override val name: String,
    override val category: String,
    override val colour: String,
    val needToBreath: Boolean
) : Animal

class AnimalFactory : AbstractFactory<Animal> {
    override fun create(type: String): Animal {
        return when (type) {
            "LandAnimal" -> LandAnimal("Lion", "mammal", "yellow-brown", 4)
            "WaterAnimal" -> WaterAnimal("Whale", "mammal", "blue", true)
            else -> throw IllegalArgumentException("Unknown type!")
        }
    }
}

object FactoryCreator {
    fun getFactory(choice: String) =
        when (choice) {
            "Animal" -> AnimalFactory()
            "Vehicle" -> VehicleFactory()
            else -> throw IllegalArgumentException("Unknown choice!")
        }
}

fun main() {
    val animalFactory = FactoryCreator.getFactory("Animal")
    val animal = animalFactory.create("LandAnimal")
    println(animal) //abstractfactory.LandAnimal
    val vehicleFactory = FactoryCreator.getFactory("Vehicle")
    val vehicle = vehicleFactory.create("Car")
    println(vehicle) //abstractfactory.Car
}