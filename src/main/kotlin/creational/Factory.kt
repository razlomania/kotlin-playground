// First option
interface Transport {
    fun delivery()
}

class Ship : Transport {
    override fun delivery() {
        println("Deliver by Sea")
    }
}

class Truck : Transport {
    override fun delivery() {
        println("Deliver by Land")
    }
}

object TransportFactory {
    fun transportForSupplier(wayOfTransporting: String, whatLandTransport: String): Transport =
        when (wayOfTransporting) {
            "Sea" -> Ship()
            "Land" ->
                when (whatLandTransport) {
                    "Wheels" -> Truck()
                    "Railroad" -> Train()
                    else -> throw Error("For now we are delivering only by Trucks and Trains")
                }
            else -> throw Error("For now we are delivering only by Sea and Land")
        }
}

class Train : Transport {
    override fun delivery() {
        println("Deliver by Train")
    }
}




// Second option

abstract class Vehicle(
    val name: String,
    val amountOfWheels: Int,
    val colour: String
) {
    companion object{
        fun createFrom(type: String): Vehicle = when (type) {
            "Car" -> {
                Car("Honda", 4, "red", 4)
            }
            "Bike" -> {
                Bike("Canondale", 2, "blue", "ebike")
            }
            else -> {
                throw IllegalArgumentException("Unknown type!")
            }
        }
    }
}

class Car(
    name: String,
    amountOfWheels: Int,
    colour: String,
    val passengers: Int
) : Vehicle(name, amountOfWheels, colour)

class Bike(
    name: String,
    amountOfWheels: Int,
    colour: String,
    val type: String
) : Vehicle(name, amountOfWheels, colour)


fun main() {
    // val transport = TransportFactory.transportForSupplier("Land")
    // transport.delivery()

    val vehicle = Vehicle.createFrom("Car")
}
