package u03

object Modules extends App {

  // An ADT: type + module
  sealed trait Person
  object Person {

    case class Student(name: String, year: Int) extends Person

    case class Teacher(name: String, course: String) extends Person

    def name(p: Person): String = p match {
      case Student(n, _) => n
      case Teacher(n, _) => n
    }
  }

  //println(filter(Cons(Person("uno", 2), Cons(Person("mauro", "pallavolo"), Nil())))(_.getClass.isInstanceOf[Teacher])) // Cons(20, Nil())

  //println(sum(Cons(10, Cons(20, Cons(30, Nil()))))) // 60
  //println(filter(Cons(10, Cons(20, Nil())))(_>15)) // Cons(20, Nil())

  /*
  println(Person.name(Person.Student("mario",2015)))

  import Person._
  println(name(Student("mario",2015)))
  */
}
