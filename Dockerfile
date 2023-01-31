
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install -y openjdk-17-jdk

ADD ./target/nomorequeue-0.0.1-SNAPSHOT.jar nomorequeue.jar
EXPOSE 8080

CMD java -jar nomorequeue.jar
