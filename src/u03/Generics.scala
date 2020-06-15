package u03

import u03.Generics.List.Cons

object Generics extends App {

  // A generic linkedlist
  sealed trait List[E]

  // a companion object (i.e., module) for List
  object List {
    case class Cons[E](head: E, tail: List[E]) extends List[E]
    case class Nil[E]() extends List[E]

    def sum(l: List[Int]): Int = l match {
      case Cons(h, t) => h + sum(t)
      case _ => 0
    }

    def drop[A](l: List[A], n: Int): List[A] = (l,n) match {
      case (Nil(), any) => Nil()
      case (l, 0) => l
      case (Cons(h, tail), num) => drop(tail, num-1)
    }

    def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
      case Cons(h, t) => if (f(h)) {
                          dropWhile(t)(f)
                        } else {
                          Cons(h, t)
                        }
      case _ => Nil()
    }

    def map[A,B](l: List[A])(f: A => B): List[B] = l match {
      case Cons(h, tail) => Cons(f.apply(h), map(tail)(f))
      case _ => Nil()
    }

    def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
      case Cons(h, tail) => append(f.apply(h), flatMap(tail)(f))
      case _ => Nil()
    }

    def filter[A](l : List [A])(pred : A => Boolean): List [A] = l match {
      case Cons (head, tail) if (pred(head)) => Cons(head, filter(tail)(pred))
      case Cons (head, tail) => filter(tail)(pred)
      case _ => Nil()
    }

    def append[A](l1: List[A], l2: List[A]): List[A] = (l1, l2) match {
      case (Cons(h, t), l2) => Cons(h, append(t, l2))
      case (l1, Cons(h, t)) => Cons(h, append(l1, t))
      case _ => Nil()
    }

    def foldLeft(list: List[Int]) (num: Int)(function: ((Int, Int) => Int)): Int = list match {
      case (Cons(h, t)) => foldLeft(t)(function.apply(num, h))(function)
      case _ => num
    }
  }

  /*
  import List._

  val lst = Cons(3,Cons(7,Cons(1,Cons(5, List.Nil()))))
  println(foldLeft(lst)(0)(_-_)) // -16

  // Note "List." qualification
  println(List.sum(List.Cons(10, List.Cons(20, List.Cons(30, List.Nil()))))) // 60
  import List._
  println(append(Cons("10", Nil()), Cons("1", Cons("2", Nil())))) // "10","1","2"

  println(drop(Cons(10, Cons(20, Cons(30, Nil()))),2)) // Cons(30, Nil())
  println(drop(Cons(10, Cons(20, Cons(30, Nil()))),5)) // Nil()

  println(map(Cons(10, Cons(20, Nil())))(_+1)) // Cons(11, Cons(21, Nil()))
  println(map(Cons(10, Cons(20, Nil())))(":"+_+":")) // Cons(":10:", Cons(":20:",Nil()))

  println(filter(Cons(10, Cons(20, Nil())))(_>15)) // Cons(20, Nil())
  println(filter(Cons("a", Cons("bb", Cons("ccc", Nil()))))( _.length <=2)) // Cons("a", Cons("bb", Nil()))

  println(dropWhile(Cons(100, Cons(25, Cons(24, Cons(20, Nil())))))(_>15)) // Cons(20, Nil())
  */

  //Suggested functions for exercises:
  // def drop[A](l: List[A], n: Int): List[A]
  // def dropWhile[A](l: List[A])(f: A => Boolean): List[A]
  // def map[A,B](l: List[A])(f: A => B): List[B]
  // def flatMap[A,B](l: List[A])(f: A => List[B]): List[B]
}
