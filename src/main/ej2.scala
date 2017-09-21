/**
  * Created by geco on 17/06/17.
  */


/**2. CONTROL STRUCTURES AND FUNCTIONS **/

//1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function
// that computes this value.
def signum(x: Int) = if(x>0) 1 else if(x<0) -1 else 0
//>for(i <- -5 to 5)print(signum(i)+" ")
println ("1. "+ (-5 to 5 map signum))

//2. What is the value of an empty block expression {}? What is its type?
val tres2 ={}
println("2. "+tres2+" "+tres2.getClass)

//3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
var x = ()
var y = 0
x = y = 1
println("3. x:"+x+" y:"+y)

//4. Write a Scala equivalent for the Java loop
//for (int i = 10; i >= 0; i--) System.out.println(i);
print("4. "); for(i <- (1 to 10).reverse) print(i+" ");print("\n")

//5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
def countDown(n: Int) = { for(i <- (0 to n).reverse) print(i+" ")}
print("5. ");
countDown(5);print("\n")

//6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product
// of the characters in 'Hello' is 9415087488L.
var pr: Long = 1
for(c <- "Hello")pr*=c.toLong
println("6. "+pr)

//7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
//> Creo que esto es lo que piden; hace el producto antes de castear a Long, por lo que el resultado es shit
println("7. "+"Hello".product)
//> Haciendo la transformacion previamente si da el resultado correcto pero creo que esa leccion no toca
//println("7. "+"Hello".map(x => x.toLong).product)
//println("7. "+"Hello".map(_.toLong).product)
//> Esto esta mejor:
//println("7. "+"Hello".foldLeft(1L)((a,b)=>a*b.toLong))
//println("7. "+"Hello".foldLeft(1L)(_*_.toLong))


//8. Write a function product(s : String) that computes the product, as described in the preceding exercises.
def unicodeProduct(str: String): Long ={
  var pr: Long  = 1
  for(c <- str){pr*=c.toLong}
  pr
}
println("8. "+unicodeProduct("Hello"))

//9. Make the function of the preceding exercise a recursive function.
def unicodeProduct2(str: String): Long = {
  if(str == "") 1
  else str.head.toLong * unicodeProduct2(str.tail)
}
println("9. "+unicodeProduct2("Hello"))

//10. Write a function that computes xn, where n is an integer. Use the following recursive definition:
//• xn = y2 if n is even and positive, where y = xn / 2.
//• xn = x·xn – 1 if n is odd and positive.
//• x0 = 1.
//• xn = 1 / x–n if n is negative.
//  Don’t use a return statement.
def mipow (x: Double, n: Double): Double = {
if(n>0){
  if(n%2==0) mipow(x,n/2) * mipow(x,n/2) //mipow(mipow(x,n/2),2) era demasiado pedir
  else x*mipow(x,n-1)
}
else if (n<0) 1/mipow(x,-n)
else 1
}
print("10. ")
for(i <- -2 to 3; j<- -1 to 4) print(" mipow("+i+","+j+") :"+mipow(i,j))