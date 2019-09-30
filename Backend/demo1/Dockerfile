from maven:3.3-jdk-8
workdir app/
copy src/ src/
copy pom.xml pom.xml
run mvn package
ENTRYPOINT ["java","-jar","target/demo1-0.0.1-SNAPSHOT.jar"]