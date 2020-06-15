package u03

object CaseMatch extends App {

  // case-based function (a partial function in this case)
  val f: Int => String = {
    case n if n>0 => "pos"
    case 0 => "zero"
    //case n if n<0 => "neg"
  }
  println(f(1)) // pos
  println(f(0)) // zero
  try { // catching an exception, if we were imperative..
    println(f(-1))
  } catch {
    case e => println(e) //scala.MatchError
  }

  // in-site application of a case-based function with 'match'
  val res = 5 match {
    case n if n>0 => "pos"
    case 0 => "zero"
    case _ => "neg" // default case, makes it a total function
  }
  println(res) // pos

}
