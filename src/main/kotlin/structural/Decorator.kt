package structural

fun main() {
    fun sendWhatsupAndEmailNotification() {
        val emailAndSlack = EmailNotification(SlackNotification())
        val result = emailAndSlack.send()
        println(result)
    }

    fun personioAndSlackNotification() {
        val personioAndSlack = PersonioNotification(SlackNotification())
        val result = personioAndSlack.send()
        println(result)
    }

    sendWhatsupAndEmailNotification()
    personioAndSlackNotification()
}

interface Notification {

    fun send(): String
}

class SlackNotification : Notification {

    override fun send() = "send slack notification"
}

/*
* When using composition to implement the Decorator pattern, we’ll need an abstract
* class that will act as the composer or decorator for our target object
*/
abstract class NotificationDecorator
    (private val not: Notification) : Notification {

    override fun send(): String {
        return not.send()
    }
}

/*
* We’ll now create the decorating element. This decorator will extend our abstract NotificationDecorator
* class and will modify its send() method according to our requirement:
*/

class WhatsupNotification(notification:  Notification) : NotificationDecorator(notification) {

    override fun send(): String {
        return super.send() + sendSlackNotification()
    }

    private fun sendSlackNotification(): String {
        return " and whatsup"
    }
}

class EmailNotification(notification:  Notification) : NotificationDecorator(notification) {

    override fun send(): String {
        return super.send() + sendEmailNotification()
    }

    private fun sendEmailNotification(): String {
        return " and email"
    }
}

/* The Delegation pattern has proven to be a good alternative to implementation inheritance,
* and Kotlin supports it natively, requiring zero boilerplate code.
* This feature makes it easy to create decorators using class delegation with the use of the by keyword.

* We’ll now define the class that can implement the ChristmasTree
* interface by delegating the decorator() method to a specified object
*/
class PersonioNotification(private val notification: Notification) : Notification by notification {

    override fun send(): String {
        return notification.send() + sendPersonioNotification()
    }

    private fun sendPersonioNotification(): String {
        return " and personio"
    }
}