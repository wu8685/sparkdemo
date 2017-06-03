A demo to test a spark cluster in working

# build

```
mvn package
```

# submit an application

```
$cd <path-to-sparkdemo>

# submit to local spark with 4 threads
$spark-submit --class "com.demo.hello.SimpleApp" --master local[4] target/sparkdemo-1.0-SNAPSHOT.jar

# submit to a standalone spark cluster
$spark-submit --class "com.demo.hello.SimpleApp" --master spark://192.168.31.67:7077 target/sparkdemo-1.0-SNAPSHOT.jar
```
