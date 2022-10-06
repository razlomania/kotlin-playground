class Shape constructor(
    var xCoordinate: Int = 0,
    var yCoordinate: Int = 0,
    var color: String = ""
) : Cloneable {

    fun cloneTo(): Shape? {
        try {
            val copy: Shape = clone() as Shape
            copy.xCoordinate = this.xCoordinate
            copy.yCoordinate = this.yCoordinate
            copy.color = this.color
            return copy
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return null
    }
}





enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}

data class User(
    val name: String,
    val role: Role,
    private val permissions: Set<String>,
) {
    fun hasPermission(permission: String) = permission in permissions
}

private val allUsers = mutableListOf<User>()

fun createUser(name: String, role: Role) {
    for (u in allUsers) {
        if (u.role == role) {
            allUsers += u.copy(name = name)
            return
        }
    }
    // Handle case that no other user with such a role exists
}

fun main() {
    val original: Shape = Shape().apply {
        xCoordinate = 10
        yCoordinate = 3
        color = "red"
    }

    val copy = original.cloneTo()?.apply {
        xCoordinate = 14
        yCoordinate = 80
        color = "blue"
    }

//    println(original.xCoordinate)
//    println(copy?.xCoordinate)





    val originalUser = User("admin1", Role.ADMIN, setOf("READ", "WRITE", "DELETE"))
    allUsers += originalUser

    createUser("admin2", Role.ADMIN)

    println(allUsers)
}

