package com.codingtest

import org.junit.{Assert, Test}

/**
  * Created by shivarajn on 10/2/2019.
  */
class VisitorInterestTest {

  val productIdToNameMap = Map("i1" -> "Nike Shoes",
    "i2"-> "Umbrella", "i3"->"Jeans")

  @Test
  def itShouldMatchPopulatedInterestedProductName(): Unit ={

    val interest = new Interest("i2",0.42,null)

    val result = new Interest("i2",0.42,"Umbrella")

    Assert.assertEquals(result,Solution1.populateInterestedProductName(interest,productIdToNameMap))
  }

  @Test
  def itShouldHandleNullIncasePopulatedInterestedProductNameNotPresent(): Unit ={

    val interest = new Interest("i4",0.42,null)

    val result = new Interest("i4",0.42,null)

    Assert.assertEquals(result,Solution1.populateInterestedProductName(interest,productIdToNameMap))
  }


}
