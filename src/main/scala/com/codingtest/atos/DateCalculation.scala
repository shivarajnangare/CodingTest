package com.codingtest.atos

import java.util.Calendar

import org.apache.commons.lang3.time.DateUtils
import org.joda.time.DateTime

/**
  * Created by shivarajn on 10/23/2019.
  */
object DateCalculation {

  def main(args: Array[String]): Unit = {
    val from = new DateTime(1901, 1, 1, 10, 11, 12, 123)
    val to = new DateTime(2000, 12, 31, 10, 11, 12, 123)
    println(numberOfSundays(from, to, 0))
  }


  def numberOfSundays(from: DateTime, to: DateTime, countOfSundays: Int): Int = from match {
    case x if (x.isAfter(to)) => countOfSundays
    case x if (x.dayOfMonth().get() == 1) => {
      val calendar = DateUtils.toCalendar(x.toDate)
      if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        numberOfSundays(from.plusDays(1), to, countOfSundays + 1)
      } else {
        numberOfSundays(from.plusDays(1), to, countOfSundays)
      }
    }
    case _ => {
      numberOfSundays(from.plusDays(1), to, countOfSundays)
    }
  }

}
