package u03

object AnonymousFunctions extends App {
  // first-class, anonymous functions (lambdas) with various syntax
  val f1 = (x: Int, y: Int) => x + y
  val f2: (Int, Int) => Int = (x: Int, y: Int) => x + y
  val f3: (Int, Int) => Int = (x, y) => x + y
  val f4: (Int, Int) => Int = _ + _
  val f5: (Int, Int) => Int = f4
  // val f6 = _ + _ // won't type-check

   val truth: (String, String) => Boolean = (str1, str2) => (str1 != str2)

  //println(f1(10, 5), f4(10, 5)) // (15,15)

  // higher-order functions are smoothly handled
  val g: (Int , Int , (Int , Int ) => Int ) => Int =
    (a, b, f) => f(a, b)

  def compose(f: Int => Int, g: Int => Int): Int => Int = {
    a => f(g(a))
  }

  def metString (a: Int, b: Int) :String = {
    "Ciao ecco " + (a + b)
  }

  //println(g(10, 5, metString)) // 50

  val h: Int => Int =
    (x: Int) => { // a lambda with an imperative body
      println("hello")
      x + 1 // last statement is a return
    }

  val f: Int => String = {
    case n if n >0 => " pos "
    case 0 => " zero "
  }

  // in - site application of a case - based function with 'match '
  val res = 5 match {
    case n if n >0 => " pos "
    case 0 => " zero "
    case _ => " neg " // default case , makes it a total function
  }

  println(compose(_-1,_*2)(5))
}
