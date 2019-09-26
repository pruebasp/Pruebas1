FROM ubuntu
WORKDIR /testdocker
RUN apt-get update

RUN apt install git -y
RUN git clone https://github.com/pruebasp/Pruebas1
WORKDIR /testdocker/Pruebas1

RUN git checkout Task_J_M
WORKDIR /testdocker/Pruebas1/Backend/springboot-rest-api-demo

RUN apt install maven -y
RUN mvn package -Dmaven.test.skip=true
ENTRYPOINT ["java","-jar","target/springboot-rest-api-demo-0.1.jar"]
