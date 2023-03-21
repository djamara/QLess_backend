
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

from maven:3.8.3-openjdk-17 as MAVEN_BUILD

ADD ./ ./
RUN mvn clean && mvn install

FROM openjdk:17-jdk-slim-buster
COPY --from=MAVEN_BUILD ./target/nomorequeue-v1.jar nomorequeue.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "nomorequeue.jar"]
