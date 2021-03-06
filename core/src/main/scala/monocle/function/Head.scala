package monocle.function

import monocle.SimpleLens

trait Head[S, A] {

  /**
   * Creates a Lens from S to its first element
   * head is safe, it should only be implemented on object with a first element
   */
   def head: SimpleLens[S, A]

}


object Head extends HeadInstances

trait HeadInstances {

  def head[S, A](implicit ev: Head[S, A]): SimpleLens[S, A] = ev.head

  def field1Head[S, A](implicit ev: Field1[S,A]): Head[S, A] = new Head[S, A]{
    def head = ev._1
  }

  implicit def tuple2Last[A1, A2]                 = field1Head[(A1, A2), A1]
  implicit def tuple3Last[A1, A2, A3]             = field1Head[(A1, A2, A3), A1]
  implicit def tuple4Last[A1, A2, A3, A4]         = field1Head[(A1, A2, A3, A4), A1]
  implicit def tuple5Last[A1, A2, A3, A4, A5]     = field1Head[(A1, A2, A3, A4, A5), A1]
  implicit def tuple6Last[A1, A2, A3, A4, A5, A6] = field1Head[(A1, A2, A3, A4, A5, A6), A1]

}