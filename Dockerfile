
FROM gradle:7.4-jdk8 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon 

FROM openjdk:8

EXPOSE 8082

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/client-api-0.0.1-SNAPSHOT-plain.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/client-api-0.0.1-SNAPSHOT-plain.jar"]