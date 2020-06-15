package u03

object Lazyness extends App {

  // standard CALL-BY-VALUE, arguments are evaluated as they are passed
  def pairOrElse[A](cond: Boolean,
                    elem: A,
                    onFalse: (A,A)): (A,A) =
    if (cond) (elem,elem) else onFalse
  println(pairOrElse(true, 10, { print("e"); (0,0) })) // e(10,10)
  println(pairOrElse(false, 10, { print("e"); (0,0) })) // e(0,0)

  // simulating CALL-BY-NAME, arguments are evaluated each time they occur in the body
  def pairOrElseByName[A](cond: Boolean,
                          elem: ()=> A,
                          onFalse: ()=> (A,A)): (A,A) =
    if (cond) (elem(),elem()) else onFalse()
  println(pairOrElseByName(true, ()=>{ print("i"); 10},
                                 ()=>{ print("e"); (0,0) })) // ii(10,10)
  println(pairOrElseByName(false, ()=>{ print("i"); 10},
                                 ()=>{ print("e"); (0,0) })) // e(0,0)

  // simulating CALL-BY-NEED, arguments are evaluated each time they occur in the body
  def pairOrElseByNeed[A](cond: Boolean,
                          elem: ()=> A,
                          onFalse: ()=> (A,A)): (A,A) = {
    lazy val v = elem() //  a value actually evaluated only at first occurrence
    if (cond) (v, v) else onFalse()
  }
  println(pairOrElseByNeed(true, ()=>{ print("i"); 10},
                                 ()=>{ print("e"); (0,0) })) // i(10,10)
  println(pairOrElseByNeed(false, ()=>{print("i"); 10},
                                 ()=>{ print("e"); (0,0) })) // e(0,0)

  // supported CALL-BY-NAME
  // syntax =>T is a shorthand to avoid verbose 0-ary lambdas
  def pairOrElseByName2[A](cond: Boolean,
                           elem: => A,
                           onFalse: => (A,A)): (A,A) =
    if (cond) (elem,elem) else onFalse

  println(pairOrElseByName2(true, { print("i"); 10}, { print("e"); (0,0) })) // ii(10,10)
  println(pairOrElseByName2(false, { print("i"); 10}, { print("e"); (0,0)})) // e(0,0)

  // simulating CALL-BY-NEED
  // arguments are evaluated when/if needed, and only once..
  // .. thanks to the lazy val
  def pairOrElseByNeed2[A](cond: Boolean,
                          elem: => A,
                          onFalse: => (A,A)): (A,A) = {
    lazy val v = elem;
    if (cond) (v,v) else onFalse
  }

  println(pairOrElseByNeed2(true, { print("i"); 10}, { print("e"); (0,0) })) // i(10,10)
  println(pairOrElseByNeed2(false, { print("i"); 10}, { print("e"); (0,0) })) // e(0,0)
}

