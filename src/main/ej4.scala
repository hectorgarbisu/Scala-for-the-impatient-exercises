import scala.io.Source

/**
  * Created by geco on 18/06/17.
  */
/** MAPS AND TUPLES **/
  
//1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the same keys and the
// prices at a 10 percent discount.
val gizmoPrices = Map("blip"->7.1,"blap"->3.2,"blup"->9.1)
println(gizmoPrices.getClass)
val gizmoSales = for((a,b) <- gizmoPrices) yield (a,0.9*b)
println("1. "+gizmoPrices+" -> "+gizmoSales)

//2. Write a program that reads words from a file. Use a mutable map to count how often each word appears. To read the
// words, simply use a java.util.Scanner:
val source = Source.fromFile("src/main/ej1.scala")
val fileContent = source.mkString.split("\\s+")
var wordCount = new scala.collection.mutable.HashMap[String, Int]
for(word <- fileContent) wordCount(word)=wordCount.getOrElse(word,0)+1
println("2. "+wordCount)

//3. Repeat the preceding exercise with an immutable map.
val distinctWords = fileContent.distinct
val separatedWordCount = for(i <- distinctWords.indices) yield fileContent.count(_==distinctWords(i))
val wordCount2 = distinctWords.zip(separatedWordCount).toMap
println("3. "+wordCount2)

//4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.

//5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.

//6. Define a linked hash map that maps 'Monday' to java.util.Calendar.MONDAY, and similarly for the other weekdays.
// Demonstrate that the elements are visited in insertion order.

//7. Print a table of all Java properties, like this:
//    java.runtime.name             | Java(TM) SE Runtime Environment
//  sun.boot.library.path         | /home/apps/jdk1.6.0_21/jre/lib/i386
//  java.vm.version               | 17.0-b16
//java.vm.vendor                | Sun Microsystems Inc.
//  java.vendor.url               | http://java.sun.com/
//  path.separator                | :
//  java.vm.name                  | Java HotSpot(TM) Server VM
//You need to find the length of the longest key before you can print the table.
//8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest values in the array.
def minmax(values: Array[Int]):(Int, Int) = {
  (values.min,values.max)
}
println("8. "+minmax(Array(1,23,4,5,6,7)))

//9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less
// than v, equal to v, and greater than v.
def lteqgt(values: Array[Int], v: Int): (Int,Int,Int) = {
  var (lt,eq,gt) = (0,0,0)
  for(i<-values) if(i<v) lt+=1 else if (i==v) eq+=1 else gt+=1
  (lt,eq,gt)
}
//Forma alternativa que no creo que sea mas eficiente
//>(values.filter(_<v).length,values.filter(_==v).length,values.filter(_>v).length)
println("9. "+lteqgt(Array(2,3,4,5,16,7,8,9,10),5))

//10. What happens when you zip together two strings, such as 'Hello'.zip('World')? Come up with a plausible use case.
println("10. "+("Hello" zip "World"))
//La principal funcion es despistar al usuario