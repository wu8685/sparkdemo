package com.demo.hello;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.net.URL;

/**
 * Created by root on 6/3/17.
 */

public class SimpleApp {

    public static void main(String[] args) throws InterruptedException {
        String file = "simple_app_file.txt";

        SparkConf conf = new SparkConf()
                .setAppName("Simple Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(file);

        long numAs = logData.filter(new Function<String, Boolean>() {

            public Boolean call(String s) throws Exception {
                return s.contains("a");
            }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {

            public Boolean call(String s) throws Exception {
                return s.contains("b");
            }
        }).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        sc.stop();
    }
}
