# quarkus-http-HEAD

Before running the test install this archive in your local repo.
Here is the cmd to do it.

mvn install:install-file \
   -Dfile=___FIX_THIS___/lib/utils-arquillian-utils-4.5.0-SNAPSHOT.jar \
   -DgroupId=org.jboss.resteasy \
   -DartifactId=utils-arquillian-utils \
   -Dversion=4.5.0-SNAPSHOT \
   -Dpackaging=jar 

Execution env.
    jdk 11.0.2
    mvn 3.6.0
    quarkus 1.3.0.Alpha1
    
  The pom.xml file contains the minimum archives required to compile and run the tests.
  See lines 268-278 for the set of tests being run.
  
  
  Compile project:
    mvn clean test -DskipTests=true
  
  Set breakpoints
    HeadContentLengthTest lines 90, 96
    SimpleResource line 37
    ManualClosingApacheHttpClient43Engine line 233
    
    
  Run tests
    mvn test -Dmaven.surefire.debug