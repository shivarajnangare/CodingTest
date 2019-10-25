package com.codingtest.nisum

import org.apache.spark.sql.catalyst.encoders.RowEncoder
import org.apache.spark.sql.{Row, SparkSession}

import scala.collection.mutable

/**
  * Created by shivarajn on 10/1/2019.
  */

object Solution2 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkSolution").master("local").getOrCreate()

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
    import org.apache.spark.sql.types._
    val schema = StructType(
      List(
        StructField("vistorId",StringType,false),
        StructField("products",ArrayType(
          StructType(
            List(
              StructField("id",StringType,false),
              StructField("interest",DoubleType,false),
              StructField("name",StringType,true)
            )
          )
        ),false)
      )
    )

    import spark.implicits._
    val inputVisitorInterestData = spark.read.option("multiline",true).schema(schema).json(visitsData.map(x=> x.replaceAll("=",":")).toDS())

    //Manipulate date for updating name
    val visitorInterestDataWithInterestName = inputVisitorInterestData.map(x =>{
      val products = x(1).asInstanceOf[mutable.WrappedArray[Row]].array.map(x =>
        Row(x.get(0),x.get(1),productIdToNameMap.get(x.get(0).toString).get))
      Row(x(0),products)
    } )(RowEncoder(schema))

    visitorInterestDataWithInterestName.show(false)

    //Dataset API
    val inputVisitorInterestDataSet = spark.read.option("multiline",true)
      .schema(schema).
      json(visitsData.map(x=> x.replaceAll("=",":")).toDS())
      .as[VisitorInterest]

    val visitorInterestDataSetWithInterestName = inputVisitorInterestDataSet.map( x => {
      val updatedInterests = x.products.map(y => Solution1.populateInterestedProductName(y,productIdToNameMap))
      x.copy(x.vistorId,updatedInterests)
    })

    visitorInterestDataSetWithInterestName.show(false)
  }

}
