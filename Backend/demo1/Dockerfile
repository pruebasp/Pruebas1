FROM ubuntu
WORKDIR /testdocker
RUN apt-get update

RUN apt install git -y
RUN git clone https://github.com/pruebasp/Pruebas1
WORKDIR /testdocker/Pruebas1

RUN git checkout Task_J_M
WORKDIR /testdocker/Backend/demo1

RUN apt install maven -y
CMD mvn package
ENTRYPOINT ["java","-jar","target/demo.0.0.1-SNAPSHOT.jar"]
