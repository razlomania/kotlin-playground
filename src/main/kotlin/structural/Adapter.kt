package structural

interface USPlug {
    val hasPower: Int
}
interface EUPlug {
    val hasPower: String
}

interface UsbMini {
    val hasPower: Power
}

enum class Power {
    TRUE, FALSE
}

interface UsbTypeC {
    val hasPower: Boolean
}

fun cellPhone(chargeCable: UsbTypeC) {
    if(chargeCable.hasPower) {
        println("I've got power")
    } else {
        println("No power")
    }
}

// object keyword is used here to generate Anonymous class.
// Created on the fly, usually to implement interfaces
fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower: Int = 1
    }
}

fun charger(plug: EUPlug) : UsbMini {
    return object : UsbMini {
        override val hasPower: Power = Power.valueOf(plug.hasPower)
     }
}

fun charge() {
    //cellPhone(charger(usPowerOutlet()))
}

fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug {
        override val hasPower: String = hasPower

    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        override val hasPower: Boolean = hasPower
    }
}

fun chargeAgain() {
    cellPhone(charger(usPowerOutlet().toEUPlug()).toUsbTypeC())
}