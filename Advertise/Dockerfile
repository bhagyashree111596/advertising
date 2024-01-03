#
# Build stage
#
FROM maven:2.7.17-jdk-1.8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:1.8-jdk-slim
COPY --from=build /target/Advertise-0.0.1-SNAPSHOT.jar Advertise.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Advertise.jar"]
