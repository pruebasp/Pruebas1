FROM ubuntu
WORKDIR /testdocker
RUN apt-get update

RUN git clone https://github.com/pruebasp/Pruebas1
RUN git checkout Task_J_M
RUN cd Backend/springboot-rest-api-demo

RUN apt install maven -y
CMD mvn package
ENTRYPOINT ["java","-jar","target/springboot-rest-api-demo.0.1.jar"]
