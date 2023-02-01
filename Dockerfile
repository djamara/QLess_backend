
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

FROM maven:3.8.3-openjdk-17 as MAVEN_BUILD

#copy the pom and source code to the container
COPY ./ ./

# package our application code
RUN mvn clean package

FROM openjdk:17-jdk-slim-buster

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD ./target/nomorequeue-0.0.1-SNAPSHOT.jar nomorequeue_backend.jar

##EXPOSE 8080
CMD ["java", "-jar", "nomorequeue_backend.jar"]
