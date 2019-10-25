package com.codingtest.atos

import scala.collection.SortedSet
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by shivarajn on 10/24/2019.
  *
  * Referred link - https://www.rosettacode.org/wiki/Poker_hand_analyser#Scala
  */



object Poker {

  val faces = "0023456789TJQKA"
  val suits = "CHSD"

  case class Card(value: Int,suit: Char) extends Ordered[Card]{

    override def hashCode(): Int = this.value

    override def equals(obj: scala.Any): Boolean = {
      val card = obj.asInstanceOf[Card]
      card.value==this.value && card.suit==this.suit
    }
    override def compare(that: Card) = {
      val value = (this.value - that.value)*100
      val suit = suits.indexOf(this.suit)-suits.indexOf(that.suit)
      value+suit
    }
  }

  def main(args: Array[String]): Unit = {

    val inputBuffer = Source.fromFile("src/main/resources/poker.txt")

    var solution = new ListBuffer[Integer]()
    for(line <- inputBuffer.getLines()){
      solution += (calcutateWinner(line))
    }
    inputBuffer.close()

    val wincount:Int = solution.toList.filter(x => x==1).size
    println(wincount)
  }

  def calcutateWinner(input: String):Int = {

    val cards=input.split(" ")


    val player1Hand=cards.zipWithIndex.filter(x=>x._2<5).map(x => parseCard(x._1)).toList.sorted
    val player2Hand=cards.zipWithIndex.filter(x=>x._2>4).map(x => parseCard(x._1)).toList.sorted

    //println(player1Hand)
    //println(player2Hand)

    val player1HandScore = playerHandScore(player1Hand)
    val player2HandScore = playerHandScore(player2Hand)

    //println(player1HandScore)
    //println(player2HandScore)
    //println(compare(player1HandScore,player2HandScore))

    compare(player1HandScore,player2HandScore)
  }

  def compare(value1: (Int,Card,Card),value2: (Int,Card,Card)) = value1 match {
    case _ if value1._1 < value2._1 => 1
    case _ if value2._1 < value1._1 => 2
    case _ if value1._2.value > value2._2.value => 1
    case _ if value2._2.value > value1._2.value => 2
    case _ if value1._3 > value2._3 => 1
    case _ if value2._3 > value1._3 => 2
    case _ => 1
  }

  def parseCard(str: String): Card = {
    Card(faces.indexOf(str(0)), str(1))
  }

  def playerHandScore(hand: List[Card]):(Int,Card,Card) = {

    def royalflush(hand: List[Card]):Boolean = {
      (hand.head.value==10 && straight(hand) && flush(hand))
    }

    def straightflush(hand: List[Card]):Boolean = {
      straight(hand) && flush(hand)
    }

    def fourofkind(hand: List[Card]):Boolean = {
      groupByValue(hand,4,1)
    }

    def fullhouse(hand: List[Card]):Boolean = {
      groupByValue(hand,3,1) && groupByValue(hand,2,1)
    }

    def flush(hand: List[Card]):Boolean = {
      val cardSuitSet = hand.map(x => x.suit).toSet
      cardSuitSet.size==1
    }

    def straight(hand: List[Card]):Boolean = {
      val cardValueSet = hand.map(x => x.value).toSet
      cardValueSet.min == cardValueSet.max -4
    }

    def threeofkind(hand: List[Card]):Boolean = {
      groupByValue(hand,3,1)
    }

    def twopairs(hand: List[Card]):Boolean = {
      groupByValue(hand,2,2)
    }

    def pair(hand: List[Card]):Boolean = {
      groupByValue(hand,2,1)
    }

    def highCard(hand: List[Card],skipCard: Int=1):Card = {
      hand.filter(x => x.value!=skipCard).toSet.max
    }

    def groupByValue(hand: List[Card],groupSize: Int,groupOccurrence: Int):Boolean = {
      hand.groupBy(_.value).values.count(_.size == groupSize) >= groupOccurrence
    }

    def groupByValueKey(hand: List[Card],groupSize: Int):Card = {
      val cardList: List[List[Card]] = hand.groupBy(_.value).values.filter(_.size == groupSize).toList
      if(cardList.size==1){
        cardList.head.head
      } else{
        val card1 = cardList.head.head
        val card2 = cardList.tail.head.head
        if(card1.value>card2.value) card1 else card2
      }
    }

    //Needs work
    if(royalflush(hand)) {
      val card: Card = highCard(hand)
      (1, card, card)
    }
    else if(straightflush(hand)) {
      val card: Card= highCard(hand)
      (2,card,card)
    }else if(fourofkind(hand)) {
      val card1 = groupByValueKey(hand,4)
      val card2 = highCard(hand,card1.value)
      (3,card1,card2)
    }else if(fullhouse(hand)){
      val card1 = groupByValueKey(hand,3)
      val card2 = highCard(hand,card1.value)
      (4,card1,card2)
    }else if(flush(hand)) {
      val card1 = highCard(hand)
      val card2 = highCard(hand, card1.value)
      (5, card1, card2)
    }else if(straight(hand)) {
      val card1 = highCard(hand)
      val card2 = highCard(hand, card1.value)
      (6, card1, card2)
    }else if(threeofkind(hand)) {
      val card1 = groupByValueKey(hand,3)
      val card2 = highCard(hand, card1.value)
      (7, card1, card2)
    }else if(twopairs(hand)) {
      val card1 = groupByValueKey(hand,2)
      val card2 = highCard(hand, card1.value)
      (8, card1, card2)
    }else if(pair(hand)) {
      val card1 = groupByValueKey(hand,2)
      val card2 = highCard(hand, card1.value)
      (9, card1, card2)
    }else {
      (10, highCard(hand), highCard(hand))
    }
  }
}
