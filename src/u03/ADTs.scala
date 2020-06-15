package u03

import u03.Generics.List.{Cons, Nil}

object ADTs extends App {

  /*
  // Build-in tuples
  val tu: (Int,Boolean) = (10, true)
  //val tup: Tuple2[Int,Boolean] = Tuple2(10, true)
  println(tu)
  //println(tu match { case (a,_) => a}) // 10

  def method (tu: (Int,Boolean)) : Int = {
    tu._1
  }

  println(method(tu)) // 10
  */

  // A custom tree
  sealed trait Tree[A]
  object Tree {
    case class Leaf[A](value: A) extends Tree[A]
    case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

    def size[A](t: Tree[A]): Int = t match {
      case Branch(l, r) => 1 + size(l) + size(r)
      case _ => 1
    }
  }

  import Tree._
  val tree = Branch(Branch(Leaf(1),Leaf(2)),Leaf(3))
  //println(tree, size(tree)) // ..,3
  /*
  def max(l: List[Int]): Option[Int]
I max(Cons(10, Cons(25, Cons(20, Nil())))) // Some(25)
I max(Nil()) // None()
   */
}
