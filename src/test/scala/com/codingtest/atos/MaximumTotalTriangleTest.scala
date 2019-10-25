package com.codingtest.atos

import org.junit.{Assert, Test}

/**
  * Created by shivarajn on 10/25/2019.
  */
class MaximumTotalTriangleTest {

  @Test
  def itshouldMatchCalcutateSumBasedOnPosition():Unit = {
    Assert.assertEquals((1,1),MaximumTotalTriangle.calcutateSumBasedOnPosition("1",1,0))
  }

  @Test
  def itshouldMatchCalcutateSumBasedOnPositionNth():Unit = {
    Assert.assertEquals((4,7),MaximumTotalTriangle.calcutateSumBasedOnPosition("1 3 4 5",3,3))
  }

}
