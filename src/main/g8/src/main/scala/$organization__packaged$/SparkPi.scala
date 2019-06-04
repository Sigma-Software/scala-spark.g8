package $organization$

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

import scala.math.random

object SparkPi extends App {

  val rootLogger = Logger.getRootLogger()
  rootLogger.setLevel(Level.ERROR)

  Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
  Logger.getLogger("org.spark-project").setLevel(Level.WARN)

  val spark = SparkSession
    .builder
    .appName("Pi")
    .getOrCreate()
  val sc = spark.sparkContext

  val samples = 1000000

  val count = sc
    .parallelize(1 to samples)
    .filter { _ =>
      val x = math.random
      val y = math.random
      x*x + y*y < 1
    }
    .count()

  val pi = 4.0 * count / samples

  println("Pi is roughly " + pi)

}

