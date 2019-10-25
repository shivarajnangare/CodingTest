package com.codingtest.atos

import org.joda.time.DateTime
import org.junit.{Assert, Test}

/**
  * Created by Chronos on 10/25/2019.
  */
class NumberOfSundaysTest {

  @Test
  def itshouldMatchNumberOfSundays():Unit = {
    Assert.assertEquals(1,DateCalculation.numberOfSundays(new DateTime(2019, 1, 1, 0, 0, 0, 0)
      ,new DateTime(2019, 11, 1, 0, 0, 0, 0),0))
  }

}
