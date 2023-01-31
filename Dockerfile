
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

#FROM ubuntu:latest
##FROM public.ecr.aws/lts/ubuntu:latest

##RUN \
# Update
##apt-get update -y && \
# Install Java
##apt-get install -y openjdk-17-jdk

##ADD ./target/nomorequeue-0.0.1-SNAPSHOT.jar nomorequeue_backend.jar
##EXPOSE 8080

##CMD java -jar nomorequeue_backend.jar
##FROM maven:3.8.3-openjdk-17
FROM openjdk:17-jdk-slim-buster

COPY ./target/nomorequeue-0.0.1-SNAPSHOT.jar nomorequeue_backend.jar
EXPOSE 8080
CMD ["java", "-jar", "nomorequeue_backend.jar"]
##CMD ["in.png"]
 
##RUN echo "Hello World"


