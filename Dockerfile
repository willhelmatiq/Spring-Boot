FROM eclipse-temurin:17-jdk-jammy as base

WORKDIR /app

COPY ./ /app

RUN chmod +x /app/gradlew

RUN ["./gradlew", "init"]

FROM base as build
CMD ["./gradlew", ":bootRun", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

