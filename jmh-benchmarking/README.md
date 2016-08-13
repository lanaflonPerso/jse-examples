## Code Tools: 

jmh

JMH is a Java harness for building, running, and 

analysing nano/micro/

milli/macro benchmarks written in Java and other languages 

targetting the JVM.

### Basic Considerations

The recommended way to run a JMH benchmark is to use [Maven](http://maven.apache.org/) to setup a standalone project that depends on the jar files of your application. This approach is preferred to ensure that the benchmarks are correctly initialized and produce reliable results. It is possible to run benchmarks from within an existing project, and even from within an IDE, 

however setup is more complex and the results are less reliable.

In all cases, the key to using JMH is enabling the annotation- or bytecode-processors to generate the synthetic benchmark code. Maven archetypes are the primary mechanism used to enable this. We strongly recommend new users make use of the archetype to setup the correct environment.

### Preferred Usage: Command Line

- **Setting up the benchmarking project.**The following command will generate the new JMH-driven project in _test_ folder:

$ mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-**java**-benchmark-archetype \
          -DgroupId=org.sample \
          -DartifactId=_test_ \
          -Dversion=1.0
 If you want to benchmark an alternative JVM language, use another_archetype artifact ID_ from the [list of existing ones](http://central.maven.org/maven2/org/openjdk/jmh/), it usually amounts to replacing **java** to another language in the artifact ID given below. Using alternative archetypes may require additional changes in the build configuration, see the 

pom.xml in the generated project. 
- **Building the benchmarks.** After the project is generated, you can build it with the following Maven command:

$ cd test/
$ mvn clean install
 
- **Running the benchmarks.** After the build is done, you will get the self-contained executable JAR, which holds your benchmark, and all essential JMH infrastructure code:

$ java -jar target/benchmarks.jar
 Run with _-h_ to see the command line options available. 

When dealing with large projects, it is customary to keep the benchmarks in a separate subproject, which then depends on the tested modules via the usual build dependencies.

### IDE support

While the command line approach is the suggested one, some people prefer to use IDEs. The user experience varies between different IDEs, but we will outline the general things here. Running benchmarks from the IDE is generally not recommended due to 

generally uncontrolled environment in which the benchmarks run.

- **Setting up the benchmarking project.** Some IDEs provide the GUI to create the Maven project from the given archetype. Make sure your IDE knows about Central archetype 

catalog, and look for _org.openjdk.jmh:jmh-${lang}-benchmark-archetype_ there. Alternatively, you can use the command line to generate the benchmark project, see above.**NOTE**: JMH is not intended to be used in the same way as a typical testing library such as JUnit. Simply adding the 

jmh-core jar file to your build is not enough to be able to run benchmarks.   

- **Building the benchmarks.**Most IDEs are able to open/import Maven projects, and infer the build configuration from Maven project configuration. IDEA and Netbeans are able to build JMH benchmark projects with little to no effort. Eclipse build configuration may need to set up JMH annotation processors to run.   

- **Running the benchmarks.** There is no direct support for JMH benchmarks in the IDE, but one can use JMH Java API to invoke the benchmark. It usually amounts to having the 

main method, which will then call into JMH. See [JMH Samples](http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/) for the examples of this approach. Before you run any benchmark, the project build is required. Most IDEs do this automatically, but some do require explicit build action to be added 

before the run: adding Maven target "

install" should help there.

### Other build systems

We do not ship the build scripts for other build systems, but there are community-supported bindings to Gradle, 

sbt, and probably other builders, see **Links** section below. If you want to build with an alternative build system, you may reference the[Ant sample](http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-ant-sample/) which describes the steps to build JMH benchmark projects with Ant.

### Building the "Bleeding Edge" JMH

In some cases, you want bleeding edge code which contains fixes, features, and APIs not available yet in released versions. This section explains how to get the "bleeding edge" JMH in your project.

1. Check out JMH source with [Mercurial](http://mercurial.selenic.com/):

$ hg clone http://hg.openjdk.java.net/code-tools/jmh/ jmh
 
2. Build JMH. You can optionally skip the tests:

$ cd jmh/
$ mvn clean install -DskipTests
 You only need to do this step once, and Maven will deploy JMH into Maven repo on your local machine. 
3. If you already have the benchmark project, then it is enough to change JMH dependencies version to the latest 

SNAPSHOT version (look up the actual latest version in [parent POM](http://hg.openjdk.java.net/code-tools/jmh/file/tip/pom.xml#l33)). If not, create the JMH benchmark project and change the version there. 
4. Done! Build the benchmark project, and run it: 

$ mvn clean install
$ java -jar target/benchmarks.jar

Reference:
http://hg.openjdk.java.net/code-tools
http://psy-lob-saw.blogspot.com/2013/05/using-jmh-to-benchmark-multi-threaded.html
http://psy-lob-saw.blogspot.com/2013/04/writing-java-micro-benchmarks-with-jmh.html
http://nitschinger.at/Using-JMH-for-Java-Microbenchmarking/