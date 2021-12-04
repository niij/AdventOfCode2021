package dev.niij
package aoc2021

import scala.io.Source

object day1 {
  val f: List[Int] = Source.fromFile("src/main/scala/aoc2021/day1input.txt").getLines.toList.map(_.toInt)

  case class Acc(counter: Int, previousValue: Int)
  // MaxValue for the first value because we don't want the 1st line to be considered greater than the previous (nothing)
  val result = f.foldLeft(Acc(0, Int.MaxValue)) { (acc, curValue) =>
    {
     if (curValue > acc.previousValue)
        Acc(acc.counter+1, curValue)
      else
        Acc(acc.counter, curValue)
    }
  }
}

object main extends App {
  println(s"result: ${day1.result.counter}")
}