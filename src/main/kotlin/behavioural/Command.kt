package behavioural

/*
Essentially, the Command Design Pattern is a way to separate the requester of an action (the client) from the object that performs the action (the receiver).
By encapsulating the request as an object, we can pass it around and manipulate it as needed.
This allows us to parameterize the request with different arguments, queue it up for later execution, or even undo it if needed.

There are several components to the Command Design Pattern:

Command interface: This is an interface that defines the common methods for all commands. It usually has a single method called execute() that performs the action.
Command class: This is a class that implements the Command interface and defines the behavior of a specific command.
    It contains a reference to the object that will perform the action.
Invoker: This is a class that requests an action to be performed by a command. It doesn’t know how the action will be performed or who will perform it.
Receiver: This is a class that performs the actual action. The command object sends the request to the receiver object, which then performs the action.
* */


interface Command {
    fun execute()
}

class OnCommand(private val electroticDevice: ConsumerElectronics) : Command {

    override fun execute() {
        electroticDevice.on()
    }
}

class MuteAllCommand(internal var deviceList: List<ConsumerElectronics>) : Command {

    override fun execute() {

        for (device in deviceList) {
            device.mute()
        }
    }
}

interface ConsumerElectronics {
    fun on()
    fun mute()
}

class Television : ConsumerElectronics {

    override fun on() {
        println("Television is on!")
    }

    override fun mute() {
        println("Television is muted!")
    }
}

class SoundSystem : ConsumerElectronics {

    override fun on() {
        println("Sound system is on!")
    }

    override fun mute() {
        println("Sound system is muted!")
    }
}

class Button(var command: Command) {

    fun click() {
        command.execute()
    }
}

class UniversalRemote {

    // here we will have a complex electronic circuit :-)
    // that will maintain current device
    fun getActiveDevice(): ConsumerElectronics {
        val tv = Television()
        return tv
    }
}

fun main(args: Array<String>) {

    // OnCommand is instantiated based on active device supplied by Remote
    val device = UniversalRemote().getActiveDevice()
    val onCommand = OnCommand(device)
    val onButton = Button(onCommand)
    onButton.click()

    val tv = Television()
    val soundSystem = SoundSystem()
    val all = ArrayList<ConsumerElectronics>()
    all.add(tv)
    all.add(soundSystem)
    val muteAll = MuteAllCommand(all)
    val muteAllButton = Button(muteAll)
    muteAllButton.click()
}
