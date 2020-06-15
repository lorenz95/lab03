package u03

import scala.util.Failure

object DefinedFunctions extends App {

  /*
  // defined function
  def square(d: Double): Double = d*d
  println(square(3.0)) // 9.0

  // defined function, using pattern matching
  def factorial(n: Int): Int = n match {
    case 0 | 1 => 1   // 0 or 1 gets mapped to 1
    case _ => n * factorial(n - 1)  // otherwise
  }
  println(factorial(6)) // 720

  // nested function
  def abs(n: Int): Int = {
    def sign(m:Int):Int = m match {case i if i>0 => 1; case 0 => 0; case _ => -1}
    n * sign(n)
  }
  println(abs(-2),abs(2),abs(0)) // 2,2,0
  */

  /*
  // tail recursion check, as a nested function
  def factorial2(n: Int): Int = {
    n match {
      case num if (n < 0) => {
        println("Negative number")
        return Int.MinValue
      }
    }

    @annotation.tailrec  // checks only if optimisation is possible
    def _fact(n: Int, acc: Int): Int = n match {
      case 0 | 1 => acc
      case _ => _fact (n - 1, n * acc)
    }
    _fact(n, 1)
  }
  println(factorial2(-3)) //
  */

  def fibTail2(n:Int): Int = {
    @annotation.tailrec
    def _fib(n:Int, curr:Int, secondLast:Int, last:Int): Int = curr match {
      case `n` => secondLast + last
      case 0 => _fib(n, curr + 1, 0, 1) // smells a bit, secondLast should be "undefined" and last 0
      case 1 => _fib(n, curr + 1, 0, 1)
      case _ => _fib(n, curr + 1, last, secondLast + last)
    }
    _fib(n, 0, 0, 0)
  }

  println(fibTail2(6))
}
