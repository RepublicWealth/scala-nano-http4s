# Scala Nano Http4s

This is a spike project to test out

- Joint compilation of mixed Scala and Java8 code using Gradle and IntelliJ
- Scala nanomsg integration
- Http4s microframework

The `build.gradle` is based on the sample provided by [punya/spark-gradle-test-example](https://github.com/punya/spark-gradle-test-example/blob/develop/build.gradle):

## Usage

Run Hello World:

    ./gradlew helloJava
    ./gradlew helloScala

Run Nanomsg, install `nanomsg` binary first:

    brew install nanomsg
    
Go into each sub-packges in `au.com.republicwealth.nano` and run the main classes.