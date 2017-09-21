/**
  * Created by geco on 17/06/17.
  */
import math._
import util.Random
import BigInt._
/** 1. BASICS **/

//1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?
//> a lot

//2. In the Scala REPL, compute the square root of 3, and then square that value. By how much does the result differ
// from 3? (Hint: The res variables are your friend.)
val sqrt3 = sqrt(3.0)
println("2. diferencia entre sqrt(3²) y 3: " + (3-pow(sqrt3, 2)))

//3. Are the res variables val or var?
//> They're val

//4. Scala lets you multiply a string with a number—try out 'crazy' * 3 in the REPL.
// What does this operation do? Where can you find it in Scaladoc?
val crazy3 = "crazy"*3 //> crazycrazycrazy busca en StringOps
println("4. \"crazy\"*3 = "+crazy3)

//5. What does 10 max 2 mean? In which class is the max method defined?
val max10_2 = 10 max 2 //> equal to max(10,2) hay un max en muchas clases incluyendo int, float, Double
println("5. max10_2 = "+ max10_2)

//6. Using BigInt, compute 2^1024.
val big2to1024 = BigInt(2) pow 1024
println("6. 2^1024 = "+big2to1024)

//7. What do you need to import so that you can get a random prime as probablePrime(100, Random), without any qualifiers
// before probablePrime and Random?
//> import BigInt._
//> import util.Random
val probPrime = probablePrime(100,Random)
println("7. probPrime = "+probPrime)

//8. One way to create random file or directory names is to produce a random BigInt and convert it to base 36, yielding
// a string such as 'qsnvbevtomcj38o06kul'. Poke around Scaladoc to find a way of doing this in Scala.
//> Hay que usar una base de conversion (radix)
val probPrimeString = probPrime.toString(36)
println("8. probPrime.toString con radix 36 (probPrime.toString(36) "+probPrimeString )

//9. How do you get the first character of a string in Scala? The last character?
println("9. "+probPrimeString(0) + " " + probPrimeString.last )

//10. What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they have over using substring?
val take2 = probPrimeString.take(2)
val drop2 = probPrimeString.drop(2)
val takeRight2 = probPrimeString takeRight 2
val dropRight2 = probPrimeString dropRight 2
println("10. take2: "+take2+" drop2: "+drop2+" takeRight2: "+takeRight2+" dropRight2: "+dropRight2)

