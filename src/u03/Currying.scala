package u03

object Currying extends App {

  // standard function with no currying
  def mult(x: Double, y: Double): Double = x*y

  def argMinBase(x: Number, y: Number) : Boolean = {
    x.doubleValue() <= y.doubleValue()
  }

  def argMin(x: Number, y: Number, z: Number) : Boolean = {
    argMinBase(x, y) && argMinBase(y, z)
  }

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x*y

  def curriedArgMinBase(x: Number) (y: Number) : Boolean = {
    argMinBase(x, y)
  }

  def curriedArgMin(x: Number) (y: Number) (z: Number) : Boolean = {
    argMin(x, y, z)
  }

  // curriedMult can be partially applied!
  val twice: Double => Double = curriedMult(2)

  val argumentMin: Number => Boolean = curriedArgMin(8)(9)

  val curriedMultAsFunction: Double => Double => Double = x => y => x*y

  val curriedArgMinAsFunction: Number => Number => Number => Boolean = {
    x => y => z => argMinBase(x, y) && argMinBase(y, z)
  }

  /*
  println(mult(10,2)) // 20
  println(curriedMult(10)(2)) // 20
  println(twice(10)) // 20
  println(curriedMultAsFunction(10)(2)) // 20
  println(curriedMultAsFunction) // u03.Currying$$$Lambda$7/1221555852@3d24753a
  println(curriedMultAsFunction(10)) // u03.Currying$$$Lambda$12/1468177767@3d24753a

  println(argMin(10, 20, 30))
  println(curriedArgMin(10) (20) (30))
  println(argumentMin(30))
  */
  println(curriedArgMinAsFunction(10)(20)(40))
}
