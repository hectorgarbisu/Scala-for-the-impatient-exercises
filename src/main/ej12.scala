/**
  * Created by geco on 11/07/17.
  */

// Start writing your ScalaFiddle code here
/* scala for the impatient 12: higher functions */
def f (c: Int)= {println("### "+c+" ###")}
f(1)//1. Write a function values(fun: (Int) => Int, low: Int, high: Int) that yields a collection of function inputs and
// outputs in a given range. For example, values(x => x * x, -5, 5) should produce a collection of pairs (-5, 25),
// (-4, 16), (-3, 9), . . ., (5, 25).

def values(fun: (Int)=> Int, low:Int, high:Int) = {
  {low to high} map {x=>(x,fun(x))}
}
println(values((x:Int)=>x*x,1,3))

f(2)//2. How do you get the largest element of an array with reduceLeft?
val myArray = (for(_ <- 1 to 20) yield scala.util.Random.nextInt(23)).toArray
println(myArray.mkString(" "))
def largest (arr:Array[Int])={arr.reduceLeft(_ max _)}
println(largest(myArray))

f(3)//3. Implement the factorial function using to and reduceLeft, without a loop or recursion.
def fucktorial (of: Int): Int = {
  1 to of reduceLeft {_*_}
}
println(fucktorial(4))

f(4)//4. The previous implementation needed a special case when n < 1. Show how you can avoid this with foldLeft.
// (Look at the Scaladoc for foldLeft. It’s like reduceLeft, except that the first value in the chain of combined values
// is supplied in the call.)
def fucktorial2 (of: Int): Int = {
  {1 to of }.foldLeft(1)(_*_)
}
println(fucktorial2(-3))

f(5)//5. Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest value of a function
// within a given sequence of inputs. For example, largest(x => 10 * x - x * x, 1 to 10) should return 25. Don’t use a
// loop or recursion.
def largest2(fun: (Int) => Int, inputs: Seq[Int])={
  inputs map fun reduce {_ max _}
}
println(largest2(fucktorial2,1 to 5))

f(6)//6. Modify the previous function to return the input at which the output is largest. For example,
// largestAt(fun: (Int) => Int, inputs: Seq[Int]) should return 5. Don’t use a loop or recursion.
def largest3(fun: (Int) => Int, inputs: Seq[Int])={
  inputs map ((x:Int)=>(x,fun(x))) reduce {(x,y)=>if(x._2>y._2)x else y}
}
println(largest3(fucktorial2,1 to 5))

f(7)//7. It’s easy to get a sequence of pairs, for example
//val pairs = (1 to 10) zip (11 to 20)
//Now suppose you want to do something with such a sequence—say, add up the values. But you can’t do
//pairs.map(_ + _)
//the function _ + _ takes two Int parameters, not an (Int, Int) pair. Write a function adjustToPair that receives a
// function of type (Int, Int) => Int and returns the equivalent function that operates on a pair. For example,
// adjustToPair(_ * _)((6, 7)) is 42.
//Then use this function in conjunction with map to compute the sums of the elements in pairs.
def adjustToPairs(fun:(Int,Int)=>Int):((Int,Int))=>Int = {
  (x:(Int,Int))=>fun(x._1,x._2)
}
val pairs = 1 to 20 zip {-4 to 14}
println(pairs zip {pairs map adjustToPairs(_+_)})

f(8)//8. In Section 12.8, “Currying,” on page 149, you saw the corresponds method used with two arrays of strings.
// Make a call to corresponds that checks whether the elements in an array of strings have the lengths given in an array
// of integers.
val myArrayOfStrings = for(i<-myArray.indices) yield myArray(i).toString
val theirLength = myArrayOfStrings map {(x:String)=>x.length}
val notTheirLength = theirLength map {_+3}
println(myArrayOfStrings.corresponds(theirLength)(_.length==_))
println(myArrayOfStrings.corresponds(notTheirLength)(_.length==_))

f(9)//9. Implement corresponds without currying. Then try the call from the preceding exercise.
// What problem do you encounter?
def myCorresponds [B,C](th1s:Seq[B],that:Seq[C],fun:(B,C)=>Boolean): Boolean = {
  th1s.zip(that).map((x:(B,C))=>fun(x._1,x._2)).foreach((x:Boolean) => if (x == false) return false); true
}
// this doesnt work: println(myCorresponds(myArrayOfStrings,theirLength,_.length==_))
// Specifying types in lower function is now required
println(myCorresponds(myArrayOfStrings,theirLength,(x:String,y:Int)=>x.length==y))
println(myCorresponds(myArrayOfStrings,notTheirLength,(x:String,y:Int)=>x.length==y))

f(10)//10. Implement an unless control abstraction that works just like if, but with an inverted condition.
// Does the first parameter need to be a call-by-name parameter? Do you need currying?
def unless (condition : => Boolean)(block : => Unit){
  if (!condition) block
}
unless(3>4){
  println("unless 3>4")
}

unless(3<4){
  println("unless 3<4")
}