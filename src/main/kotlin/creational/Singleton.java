package creational;

public class Singleton {

    //create an object of SingleObject
    private static Singleton instance = new Singleton();

    //make the constructor private so that this class cannot be
    //instantiated
    private Singleton() {
    }

    //Get the only object available
    public static Singleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}

//public class SingletonPatternDemo {
//    public static void main(String[] args) {
//
//        //illegal construct
//        //Compile Time Error: The constructor SingleObject() is not visible
//        //SingleObject object = new SingleObject();
//
//        //Get the only object available
//        Singleton object = Singleton.getInstance();
//
//        //show the message
//        object.showMessage();
//    }
//}