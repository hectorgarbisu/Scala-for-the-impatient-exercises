/**
  * Created by geco on 18/06/17.
  */

/** OBJECTS **/
val e = 1
//1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.
object Conversions {
  def inchesToCentimeters(inches:Double):Double = {2.54*inches}
  def gallonsToLiters(gallons:Double):Double = {gallons*3.78541}
  def milesToKilometers(miles:Double):Double = {miles*1.60934}
}
import Conversions._
println("1. "+inchesToCentimeters(3)+" "+gallonsToLiters(1.1)+" "+milesToKilometers(61.2))

//2. The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion and define objects
// InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
abstract class UnitConversion {
  def convert(fromVal:Double): Double
}
object InchesToCentimeters extends UnitConversion {
  override def convert(fromVal:Double): Double = {fromVal*2.54}
}
object GallonsToLiters extends UnitConversion {
  override def convert(fromVal:Double): Double = {fromVal*3.78541}
}
object MilesToKilometers extends UnitConversion {
  override def convert(fromVal:Double): Double = {fromVal*1.60934}
}
println("2. "+InchesToCentimeters.convert(3)+" "+GallonsToLiters.convert(1.1)+" "+MilesToKilometers.convert(61.2))
//No se si esto es mejor que InchesToCentimeters(3).convert()

//3. Define an Origin object that extends java.awt.Point. Why is this not actually a good idea? (Have a close look at
// the methods of the Point class.)
object Origin extends java.awt.Point {
   // Point no tiene metodos propios
}
println("3. ")

//4. Define a Point class with a companion object so that you can construct Point instances as Point(3, 4), without
// using new.
class Point(private val x:Int, private val y:Int){override def toString:String = x+" "+y}
object Point{
  def apply(x: Int, y:Int) = new Point(x,y)
}
println("4. "+Point(1,2))

//5. Write a Scala application, using the App trait, that prints the command-line arguments in reverse order, separated
// by spaces. For example, scala Reverse Hello World should print World Hello.
object miApp extends App {
   println(args.reverse)
}
// Error: no se ha encontrado o cargado la clase principal ej6miApp

//6. Write an enumeration describing the four playing card suits so that the toString method returns ♣, ♦, ♥, or ♠.
object Palo extends Enumeration {
  val trebol = Value("♣")
  val rombo = Value("♦")
  val corazon = Value("♥")
  val pica = Value("♠")
}
println("6. "+Palo.trebol+Palo.rombo+Palo.corazon+Palo.pica)

//7. Implement a function that checks whether a card suit value from the preceding exercise is red.
def isRedSuit(palo: Palo.Value): Boolean = {
  palo == Palo.rombo || palo == Palo.corazon
}
println("7. "+isRedSuit(Palo.trebol)+" "+isRedSuit(Palo.rombo)+" "+
  isRedSuit(Palo.corazon)+" "+isRedSuit(Palo.pica)+" ")

//8. Write an enumeration describing the eight corners of the RGB color cube. As IDs, use the color values
// (for example, 0xff0000 for Red).
object RgbColor extends Enumeration {
  val Black = Value(0x000000,"Black")

  val Red = Value(0xff0000,"Red")
  val Green = Value(0x00ff00,"Green")
  val Blue = Value(0x0000ff,"Blue")

  val Yellow = Value(0xffff00,"Yellow")
  val Purple = Value(0xff00ff,"Purple")
  val Cyan = Value(0x00ffff,"Cyan")

  val White = Value(0xffffff,"White")
}

println("8. "+ {for (blep <- RgbColor.values) yield f"${blep.id}%x"}.mkString(" "))
