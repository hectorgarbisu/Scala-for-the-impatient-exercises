import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.awt.datatransfer._

/**
  * Created by geco on 18/06/17.
  */

/** ARRAYS **/

//1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
val n = 9
val a = new Array[Int](n).map(_+Random.nextInt(n))
println("1. "+a.mkString(" "))


//2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
for (i <- 1.until(a.length,2)){
  val aux = a(i) // no me gusta pero creo que es aceptable
  a(i)=a(i-1)
  a(i-1)=aux
}
println("2. "+a.mkString(" "))


//3. Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield.
val nuArray = for(i <- a.indices) yield
  if(i % 2 == 0){
    if(i<a.length-1) a(i+1)
    else a(i)
  } else a(i-1)
println("3. "+nuArray.mkString(" "))


//4. Given an array of integers, produce a new array that contains all positive values of the original array,
// in their original order, followed by all values that are zero or negative, in their original order.
val b = (for(_ <- 1 to 10)yield Random.nextInt(10)-5).toArray
val c = {b.filter(_>0)++b.filter(_<=0)}.toArray
println("4. "+c.mkString(" "))

//5. How do you compute the average of an Array[Double]?
val arrDbl = for(_<- 1 to 10) yield Random.nextDouble*20
val avg = arrDbl.sum/arrDbl.length
println("5. "+"avg: "+avg+" from: "+arrDbl.mkString(" "))

//6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order? How do you do the
// same with an ArrayBuffer[Int]?
print("6. ")
val d = b++c
val e = new ArrayBuffer ++ d
println(d.sortWith(_>_).mkString(" ")+" "+d.getClass)
println("   "+e.sortWith(_>_).mkString(" ")+" "+e.getClass)


//7. Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)
println("7. "+e.distinct.mkString(" "))

//8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect indexes of the negative
// elements, reverse the sequence, drop the last index, and call a.remove(i) for each index. Compare the efficiency of
// this approach with the two approaches in Section 3.4.
val indexes = {for(i <- e.indices.reverse if e(i)<0) yield i} dropRight 1
for(i <- indexes) e.remove(i)
println("8. "+e.mkString(" "))

//9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America. Strip off
// the 'America/' prefix and sort the result.
val ids =java.util.TimeZone.getAvailableIDs
val ids2 = ids.filter(_.contains("America/")).map(_.stripPrefix("America/")).sorted
println("9. "+ids2.mkString(" "))

//10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//val what = getNativesForFlavor(DataFlavor.imageFlavor)
// MEGA WHAT
//Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as a Scala
// buffer. (Why this obscure class? It’s hard to find uses of java.util.List in the standard Java library.)
