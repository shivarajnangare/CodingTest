package com.codingtest.nisum

import com.google.gson.Gson

/**
  * Created by shivarajn on 10/1/2019.
  */

case class VisitorInterest(vistorId: String,products: Array[Interest])

case class Interest(id: String, interest: Double, name: String)

object Solution1 {

  def main(args: Array[String]): Unit = {

    //Input Data
    val rec1:String =
      """{
          "vistorId" = "v1",
          "products" = [{
            "id" = "i1",
            "interest" = 0.68
            },{
            "id" = "i2",
            "interest" = 0.42
          }]
        }
      """

    val rec2:String =
      """{
          "vistorId" = "v2",
          "products" = [{
             "id" = "i1",
             "interest" = 0.78
            },{
            "id" = "i3",
            "interest" = 0.11
          }]
        }
      """

    val visitsData: Seq[String] = Seq(rec1,rec2)

    val productIdToNameMap = Map("i1" -> "Nike Shoes",
        "i2"-> "Umbrella", "i3"->"Jeans")

    //Solution

    //Parse JSON atring using GSON
    val gson = new Gson()
    val dsFormatInput = visitsData.map(x => gson.fromJson(x,classOf[VisitorInterest]))

    //Update Name for Products visitor is interested in
    val visitsDataWithName = dsFormatInput.map(x => {
      val updatedInterests = x.products.map(y => populateInterestedProductName(y,productIdToNameMap))
      x.copy(x.vistorId,updatedInterests)
    })

    //Print updated data
    visitsDataWithName.foreach(x => {
      println(x.vistorId)
      x.products.foreach(println)
    })
  }

/**
  * Returns Interest with mapped name
  *
  * @param interestedProduct Interset for which name needs to be mapped
  * @param productIdToNameMap Map of Interset Id and associated name
  * @return Interest with name mapped to Interest Id
  */
  def populateInterestedProductName(interestedProduct: Interest,productIdToNameMap: Map[String,String]): Interest = {
    if (interestedProduct == null) {
      null
    } else {
      if (productIdToNameMap.contains(interestedProduct.id)) {
        val name: String = productIdToNameMap.get(interestedProduct.id).get
        interestedProduct.copy(interestedProduct.id, interestedProduct.interest, name)
      } else
        interestedProduct
    }
  }



}
