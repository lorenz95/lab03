package u03

object Values extends App {

  val v = 1

  val w: Int = 1

  println(v)

  println("result is " + v);

  // primitive types as expected
  val i: Int = 10 + 5 // as in Java, to be read +(10,5)
  val l: Long = 100000000000L // as in Java
  val d: Double = 5.4 * 1.3 // as in Java
  val f: Float = 3.0f // as in Java
  val b: Boolean = true && false // as in Java
  val s: String = "hello" concat " to all" // method as operator
  val n: String = null // null can be passed to "objects"

  println(i, l, d, f, b, s, n) // println has a var-arg
}
