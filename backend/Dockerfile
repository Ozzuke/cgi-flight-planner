LABEL authors="osvald"
FROM gradle:jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
