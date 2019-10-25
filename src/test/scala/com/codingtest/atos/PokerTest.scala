package com.codingtest.atos

import org.joda.time.DateTime
import org.junit.{Assert, Test}

/**
  * Created by Chronos on 10/25/2019.
  */
class PokerTest {

  @Test
  def itshouldMatachPlayerHandScorePairFive():Unit = {
    val cards = "5H 5C 6S 7S KD".split(" ").map(x => Poker.parseCard(x)).toList
    val expected = (9,Poker.parseCard("5H"),Poker.parseCard("KD"))
    val actual = Poker.playerHandScore(cards)
    Assert.assertEquals(expected,actual)
  }

  @Test
  def itshouldMatachPlayerHandScoreHighest():Unit = {
    val cards = "5D 8C 9S JS AC".split(" ").map(x => Poker.parseCard(x)).toList
    val expected = (10,Poker.parseCard("AC"),Poker.parseCard("AC"))
    val actual = Poker.playerHandScore(cards)
    Assert.assertEquals(expected,actual)
  }

  @Test
  def itshouldMatachComparisonResultHandType():Unit = {
    val value1 = (5,Poker.parseCard("AC"),Poker.parseCard("AC"))
    val value2 = (10,Poker.parseCard("KC"),Poker.parseCard("KC"))
    Assert.assertEquals(1,Poker.compare(value1,value2))
  }

  @Test
  def itshouldMatachComparisonResultHandTypeCard():Unit = {
    val value1 = (9,Poker.parseCard("AC"),Poker.parseCard("4C"))
    val value2 = (9,Poker.parseCard("KC"),Poker.parseCard("5C"))
    Assert.assertEquals(1,Poker.compare(value1,value2))
  }

  @Test
  def itshouldMatachComparisonResultHandTypeCardAndHighestCard():Unit = {
    val value1 = (9,Poker.parseCard("AC"),Poker.parseCard("4C"))
    val value2 = (9,Poker.parseCard("AC"),Poker.parseCard("5C"))
    Assert.assertEquals(2,Poker.compare(value1,value2))
  }

}
