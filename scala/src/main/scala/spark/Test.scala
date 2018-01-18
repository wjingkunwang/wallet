package spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wjk on 2017/9/8.
  */
object Test {
  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf().setAppName("Spark SQL Test Case")
    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)
  }
}
