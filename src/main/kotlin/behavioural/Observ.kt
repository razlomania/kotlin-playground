import kotlin.properties.Delegates

open class Subject {
    private var observers = mutableListOf<Observer>()

    fun callObservers() {
        for (obs in observers) obs.update()
    }

    fun attach(obs: Observer) {
        observers.add(obs)
    }

    fun detach(obs: Observer) {
        observers.remove(obs)
    }
}

interface Observer {
    fun update()
}

class Sensor : Subject() {
    var temperature: Int = 0
        set(value) {
            field = value
            callObservers()
        }
}

class Monitor(val sensor: Sensor) : Observer {
    init {
        sensor.attach(this)
    }

    override fun update() {
        val newTemperature = sensor.temperature
        println("update Monitor")
    }

}

fun main() {

    val sensor = Sensor()
    val monitor = Monitor(sensor)

    sensor.temperature = 5
    sensor.temperature = 7
}






//class Sensor : Subject() {
//    var temperature: Int by Delegates.observable(0) { property, oldValue, newValue -> onChange(oldValue, newValue) }
//
//    private fun onChange(old: Int, new: Int) {
//        println("$old , $new")
//        callObservers()
//    }
//}