import sun.misc.ASCIICaseInsensitiveComparator

/**
  * Created by geco on 21/06/17.
  */

/** OPERATORS **/


//1. According to the precedence rules, how are 3 + 4 -> 5 and 3 -> 4 + 5 evaluated?
println("1. 3+4->5 : 7,5 ; 3->4+5 : Error")

//2. The BigInt class has a pow method, not an operator. Why didn’t the Scala library designers choose **
// (as in Fortran) or ^ (as in Pascal) for a power operator?
val ** = 3
println("2. ** is a valid identifier maybe because pow is not commutative nor associative, dunno" + **)

//3. Implement the Fraction class with operations + - * /. Normalize fractions, for example turning 15/–6 into –5/2.
// Divide by the greatest common divisor, like this:

class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
  override def toString: String = {num + "/" + den}
  def sign(a: Int):Int = if (a > 0) 1 else if (a < 0) -1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)
  def + (that: Fraction): Fraction ={new Fraction(that.num*this.den+this.num*that.den,that.den*this.den)}
  def - (that: Fraction): Fraction ={new Fraction(that.num*this.den-this.num*that.den,that.den*this.den)}
  def * (that: Fraction): Fraction ={new Fraction(that.num*this.num,that.den*this.den)}
  def / (that: Fraction): Fraction ={new Fraction(this.num*that.den,this.den*that.num)}
}
println("3. "+new Fraction(2,3)*{new Fraction(5,10)})

//4. Implement a class Money with fields for dollars and cents. Supply +, - operators as well as comparison operators
//== and <. For example, Money(1, 75) + Money(0, 50) == Money(2, 25) should be true. Should you also supply * and /
// operators? Why or why not?
class Money (val dollars: Double, val cents: Double){
  def + (that: Money) : Money = new Money(that.dollars+dollars,that.cents+cents)
  def - (that: Money) : Money = new Money(dollars-that.dollars,cents-that.cents)
  def == (that: Money) : Boolean = that.dollars==dollars && that.cents==cents
  def < (that: Money) : Boolean = dollars<that.dollars || (dollars==that.dollars && cents<that.cents)
  override def toString: String = {"($"+dollars+"."+cents+")"}
}
println("4. "+{new Money(3,20)+new Money(4,50)})

//5. Provide operators that construct an HTML table. For example,
//Table() | 'Java' | 'Scala' || 'Gosling' | 'Odersky' || 'JVM' | 'JVM, .NET'
//<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling...
class Table (val inner:String = ""){
  override def toString: String = "<table><tr>"+inner+"</tr></table>"
  def | (that:String) : Table = new Table(inner+"<td>"+that+"</td>")
  def || (that:String) : Table = new Table(inner+"</tr><tr><td>"+that+"</td>")
}
object Table {def apply(inner: String = ""): Table = new Table(inner)}
println("5. " + {Table() | "ta" | "te" || "ti" | "to"})

//  6. Provide a class ASCIIArt whose objects contain figures such as
//
val cat= new ASCIIArt("""
  /\_/\.
 ( ' ' )
 (  -  )
  | | |.
 (__|__)
""")
val sCoder = new ASCIIArt("""
   -----__
 / Hello \
<  Scala |
 \ Coder /
   -----__
""")
//    or vertically. Choose operators with appropriate precedence.
class ASCIIArt (val stringSeq : Seq[String] = Seq("")){
  def this(ristra:String) = this(ristra.split('\n').toSeq)
  override def toString: String = stringSeq.mkString("\n")
  def + (that: ASCIIArt): ASCIIArt = {
    new ASCIIArt(stringSeq.zip(that.stringSeq).map(x=>x._1+x._2))
  }
  def / (that: ASCIIArt): ASCIIArt = {
    new ASCIIArt(stringSeq++that.stringSeq)
  }
}
println("6. "+{{cat+cat+cat+sCoder+cat}/{sCoder+cat}})

//    7. Implement a class BitSequence that stores a sequence of 64 bits packed in a Long value. Supply apply and
// update operators to get and set an individual bit.

//    8. Provide a class Matrix—you can choose whether you want to implement 2 × 2 matrices, square matrices of any
// size, or m × n matrices. Supply operations + and *. The latter should also work with scalars, for example mat * 2.
// A single element should be accessible as mat(row, col).

//    9. Define an unapply operation for the RichFile class that extracts the file path, name, and extension. For
// example, the file /home/cay/readme.txt has path /home/cay, name readme, and extension txt.


//    10. Define an unapplySeq operation for the RichFile class that extracts all path segments. For example, for the
// file /home/cay/readme.txt, you should produce a sequence of three segments: home, cay, and readme.txt.