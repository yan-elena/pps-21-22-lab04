package u04lab.code

import scala.annotation.tailrec
import u04lab.code.Option.*
import u04lab.code.Option
// A generic linkedlist
enum List[E]:
  case Cons(head: E, tail: List[E])
  case Nil()

// a companion object (i.e., module) for List
object List:
  def sum(l: List[Int]): Int = l match
    case Cons(h, t) => h + sum(t)
    case _ => 0

  def map[A, B](l: List[A])(mapper: A => B): List[B] = l match
    case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
    case Nil() => Nil()

  def filter[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
    case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
    case Cons(_, t) => filter(t)(pred)
    case Nil() => Nil()

  def drop[A](list: List[A], n: Int): List[A] = (n, list) match
    case (0, l) => l
    case (n, List.Cons(_, tail)) => drop(tail, n - 1)
    case _ => list

  def append[A](left: List[A], right: List[A]): List[A] = left match
    case Cons(head, rest) => Cons(head, append(rest, right))
    case Nil() => right

  def length(list: List[_]): Int = List.sum(List.map(list)(_ => 1))

  def find[A](list: List[A])(f: A => Boolean): Option[A] = list match
    case Cons(elem, rest) if f(elem) => Some(elem)
    case Cons(elem, rest) => find(rest)(f)
    case _ => None()

  def contains[A](list: List[A])(elem: A): Boolean = !Option.isEmpty(find(list)(_ == elem))
