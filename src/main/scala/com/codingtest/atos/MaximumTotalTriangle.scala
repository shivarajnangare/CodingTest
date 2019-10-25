package com.codingtest.atos

import java.io.{BufferedReader, InputStreamReader}

import scala.io.Source

/**
  * Created by shivarajn on 10/24/2019.
  */
object MaximumTotalTriangle {

  def main(args: Array[String]): Unit = {

    val inputBuffer = Source.fromFile("src/main/resources/triangle.txt")

    var solution=(1,0L)
    for(line <- inputBuffer.getLines()){
      solution = calcutateSumBasedOnPosition(line,solution._1,solution._2)
    }
    inputBuffer.close()
    println(solution._2)
  }

  def calcutateSumBasedOnPosition(input: String,position: Int,sum: Long):(Int,Long) = {
    val arrayInputString = input.split(" ")
    val inputBasedOnPosition = arrayInputString(position-1).toInt
    (if(arrayInputString.length==1)1 else arrayInputString.length,sum+inputBasedOnPosition)
  }

}
