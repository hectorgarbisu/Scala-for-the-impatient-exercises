/**
  * Created by geco on 18/06/17.
  */
/** CLASSES **/

//1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless Methods,” on page 49 so that it
// doesn’t turn negative at Int.MaxValue.
class Counter {
  private var value = 0 // You must initialize the field
  def increment() { if(value<Int.MaxValue) value += 1 } // Methods are public by default
  def current():Int = value
}
println("1. ")

//2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
class BankAccount {
  private var pbalance = 0
  def balance :Int= pbalance
}
println("2. ")

//3. Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean that
// checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min), where
// hrs is in military time format (between 0 and 23).
class Time(val hrs: Int, val min: Int) {
  def before(other:Time): Boolean = {
    hrs<other.hrs || (hrs==other.hrs && min<other.min)
  }
}
println("3. "+(new Time(21,34) before new Time(21,35))+" "+(new Time(3,0) before new Time(0,0)))

//4. Reimplement the Time class from the preceding exercise so that the internal representation is the number of minutes
// since midnight (between 0 and 24 × 60 – 1). Do not change the public interface. That is, client code should be
// unaffected by your change.
class Time2( hrs: Int,  min: Int) {
  private val time = hrs*60+min
  def before(other:Time2):Boolean=  time < other.time
}
println("4. "+(new Time2(21,34) before new Time2(21,35))+" "+(new Time2(3,0) before new Time2(0,0)))

//5. Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long). What methods
// are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala Should you?


//6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 49, provide a primary
// constructor that turns negative ages to 0.
class Person (var age: Int){ // This is Java
  if(age<0) age *= -1
}
println("6. "+new Person(-2).age)

//7. Write a class Person with a primary constructor that accepts a string containing a first name, a space, and a last
// name, such as new Person('Fred Smith'). Supply read-only properties firstName and lastName. Should the primary
// constructor parameter be a var, a val, or a plain parameter? Why?
class Person2(private val str: String){
  def firstName():String = str.split(" ")(0)
  def lastName():String = str.split(" ")(1)
}
println("7. "+new Person2("John Smith").firstName+" "+new Person2("Alfredo Macarrón").lastName)

//8. Make a class Car with read-only properties for manufacturer, model name, and model year, and a read-write property
// for the license plate. Supply four constructors. All require the manufacturer and model name. Optionally, model year
// and license plate can also be specified in the constructor. If not, the model year is set to -1 and the license plate
// to the empty string. Which constructor are you choosing as the primary constructor? Why?
class Car(private val manufacturer: String, private val modelName: String,
          private val modelYear: Int, private var licensePlate: String){
  def this(manufacturer:String, modelName:String, modelYear:Int) {
    this(manufacturer,modelName,modelYear, "")
  }
  def this(manufacturer:String, modelName:String, licensePlate:String) {
    this(manufacturer,modelName,-1,licensePlate)
  }
  def this(manufacturer:String, modelName:String) {
    this(manufacturer,modelName,-1,"")
  }
}
println("8. ")

//9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much shorter is the Scala
// class?
//10. Consider the class
//class Employee(val name: String, var salary: Double) {
//  def this() { this('John Q. Public', 0.0) }
//}
//Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?

class Employee {
  var name = "John Q. Public"
  var salary:Double = 0.0
  def this(name:String, salary: Double){
    this()
    this.name = name
    this.salary = salary
  }
}
println("9. Prefiero la implementacion original porque es más corta y no involucra reescritura")