package u03

import Generics.List

import scala.annotation.tailrec

object SumTypes extends App {

  // Sum type: a sealed base trait, and cases extending it
  sealed trait Person //sealed: no other impl. except Student, Teacher
  case class Student(name: String, year: Int) extends Person
  case class Teacher(name: String, course: String) extends Person

  def name(p: Person): String = p match {
    case Student(n,_) => n
    case Teacher(n,_) => n
  }

  def course(p: Person): String = p match {
    case Teacher(_, course) => course
  }

  def nicePresentation(p: Person): String = p match {
    case Student(n, y) => "Student: " + n + "Year: " + y
    case Teacher(n, c) => "Teacher: " + n + "Course: " + c
  }

  def extractCourse(listPerson: List[Person]): List[String] = {
    List.map(List.filter(listPerson)(_.isInstanceOf[Teacher]))(i => course(i))
  }

  /*
  println(extractCourse(Cons(Student("uno", 2),
    Cons(Teacher("mauro", "pallavolo"), Cons(Student("uno", 2),
      Cons(Student("uno", 2), Cons(Teacher("morris", "setaggio"),
        Cons(Teacher("lian", "educazione"), Cons(Student("uno", 2),
      Cons(Student("uno", 2), List.Nil()))))))))))

  //println(name(Student("mario",2015)))
  println(nicePresentation(Student("mario",2015)))
  println(nicePresentation(Teacher("mario","1")))
  */

  // A LinkedList of Int
  sealed trait IntList
  case class ILCons(head: Int, tail: IntList) extends IntList
  case class ILNil() extends IntList

  def sum(l: IntList): Int = l match {
    case ILCons(h, t) => h + sum(t)
//    case ILNil() => 0
    case _ => 0
  }

  /* esempio di ricorsione ottimizzata */
  @tailrec
  def sum2(l: IntList, acc: Int): Int = l match {
    case ILCons(h, t) => sum2(t, h + acc)
    //    case ILNil() => 0
    case _ => acc
  }

  def genOp(function: (Int, Int) => Int, i: Int) = {
    function(_, i)
  }

  def incBy(unit: Int) = {
    genOp(_+_, unit)
  }

  def compose(value: Int => Int, value2: Int => Int)(num: Int): Int = {
    val risInt = value2(num)
    value(risInt)
  }

  /*
  val minus3 = genOp(_-_, 3)
  val div2 = genOp(_/_, 2)

  println(compose(div2, minus3)(30))

  val plus7 = incBy(7);
  println(plus7(8)) // 15

  println(sum(ILCons(10, ILCons(20, ILCons(30, ILNil())))))
  println(sum2(ILCons(10, ILCons(20, ILCons(30, ILNil()))), 0))
  */

}
