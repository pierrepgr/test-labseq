FROM openjdk:17-jdk-alpine

ENV LANG C.UTF-8

RUN apk add --update bash

ADD target/*.jar /app/web-api.jar

CMD java -jar /app/web-api.jar