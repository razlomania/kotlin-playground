package structural

class CPU {
    fun freeze() = println("Freezing.")

    fun jump(position: Long) = println("Jump to $position.")

    fun execute() = println("Executing.")
}

class HardDrive {
    fun read(lba: Long, size: Int): ByteArray = byteArrayOf()
}

class Memory {
    fun load(position: Long, data: ByteArray) = println("Loading from memory position: $position")
}

/* Facade */
class Computer(val processor: CPU = CPU(), val ram: Memory = Memory(), val hd: HardDrive = HardDrive()) {
    companion object {
        val BOOT_ADDRESS = 0L
        val BOOT_SECTOR = 0L
        val SECTOR_SIZE = 0
    }

//    fun start() {
//        processor.freeze()
//        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE))
//        processor.jump(BOOT_ADDRESS)
//        processor.execute()
//    }
}

fun Computer.start() {
    processor.freeze()
    ram.load(Computer.BOOT_ADDRESS, hd.read(Computer.BOOT_SECTOR, Computer.SECTOR_SIZE))
    processor.jump(Computer.BOOT_ADDRESS)
    processor.execute()
}


fun main() {
    val c = Computer()
    c.start()
}