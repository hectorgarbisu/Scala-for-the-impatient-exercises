import scala.collection.mutable.ArrayBuffer

/**
  * Created by geco on 20/06/17.
  */
/** INHERITANCE **/

//1. Extend the following BankAccount class to a CheckingAccount class that charges $1 for every deposit and withdrawal.
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class NastyBankAccount(initialBalance: Double) extends BankAccount(initialBalance){
  override def deposit(amount: Double) = {super.deposit(amount);super.withdraw(1)} // sin las llaves hace los withdraw
  override def withdraw(amount: Double) = {super.withdraw(amount);super.withdraw(1)} // unitarios al crear el objeto
}
val nastyBankAccount = new NastyBankAccount(40)
print("1. ")
print(nastyBankAccount.withdraw(20)+" ") // deberia quedan 19
println(nastyBankAccount.deposit(10)) // deberia haber 28


//2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest every
// month (when a method earnMonthlyInterest is called) and has three free deposits or withdrawals every month. Reset
// the transaction count in the earnMonthlyInterest method.
class InterestBankAccount(initialBalance: Double) extends NastyBankAccount(initialBalance){
  private var freeOpCount = 3
  private var interest = 0
  override def deposit(amount: Double) = {freeOpCount={freeOpCount-1 max 0};super.deposit(amount)}
  override def withdraw(amount: Double) = {freeOpCount={freeOpCount-1 max 0};super.withdraw(amount)}
  def earnMonthlyInterest():Unit = {interest+=1;freeOpCount=3}
}
println("2. what")

//3. Consult your favorite Java or ++ textbook that is sure to have an example of a toy inheritance hierarchy, perhaps
// involving employees, pets, graphical shapes, or the like. Implement the example in Scala.

//4. Define an abstract class Item with methods price and description. A SimpleItem is an item whose price and
// description are specified in the constructor. Take advantage of the fact that a val can override a def. A Bundle is
// an item that contains other items. Its price is the sum of the prices in the bundle. Also provide a mechanism for
// adding items to the bundle and a suitable description method.
abstract class Item(){
  def price: Double
  def description: String
}
class SimpleItem(val price: Double, val description: String) extends Item //lol
class Bundle extends Item {
  var items = new ArrayBuffer[Item]
  def addItem(item: Item) = items.append(item)
  def addItems(items: Item*) = for (item <- items) addItem(item)
  override def price: Double = items.view.map(_.price).sum
  override def description: String = "Bundle with items:"+items.map(x=>x.description+":"+x.price).mkString("[",",","]")
}
val bundle,biggerBundle = new Bundle
biggerBundle.addItems(new SimpleItem(10,"pato_goma"), new SimpleItem(20, "ganso_goma"))
println("4. "+bundle.description+" ; "+biggerBundle.description)

//5. Design ua class Point whose x and y coordinate values can be provided in a constructor. Provide a subclass
// LabeledPoint whose constructor takes a label value and x and y coordinates, such as
//new LabeledPoint('Black Thursday', 1929, 230.07)
class Point (val x: Double, val y: Double) {def getXY = (x,y)}
class LabeledPoint(labelValue: String, override val x: Double, override val y: Double) extends Point(x,y)
val cuac = new LabeledPoint("cuac",2,3)
println("5. "+cuac.x+" "+cuac.y)

//6. Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and Circle. Provide
// appropriate constructors for the subclasses and override the centerPoint method in each subclass.
abstract class Shape {def area: Double}
class Rectangle (bottomLeftCorner: Point, width: Double, height: Double) extends Shape {override def area = width*height}
class Circle (center: Point, radius: Double) extends Shape {override def area = math.Pi*radius*radius}
println("6. "+new Rectangle(cuac,4,5).area+" "+new Circle(cuac,2).area)

//7. Provide a class Square that extends java.awt.Rectangle and has three constructors: one that constructs a square
// with a given corner point and width, one that constructs a square with corner (0, 0) and a given width, and one that
// constructs a square with corner (0, 0) and width 0.
class Square(val corner: Point, val width: Double) extends Rectangle(corner, width, width){
  def this(width: Double) = this(new Point(0,0),width)
  def this() = this(new Point(0,0), 0)
}
val (sq1,sq2,sq3) = (new Square(1),new Square(cuac, 3),new Square)
println("7. "+sq1.width+" "+sq2.width+" "+sq3.width)

//8. Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,” on page 89 and analyze the class
// files with javap. How many name fields are there? How many name getter methods are there? What do they get? (Hint:
// Use the -c and -private options.)


//9. In the Creature class of Section 8.10, “Construction Order and Early Definitions,” on page 92, replace val range
// with a def. What happens when you also use a def in the Ant subclass? What happens when you use a val in the
// subclass? Why?

//10. The file scala/collection/immutable/Stack.scala contains the definition
//class Stack[A] protected (protected val elems: List[A])
//Explain the meanings of the protected keywords. (Hint: Review the discussion of private constructors in Chapter 5.)
