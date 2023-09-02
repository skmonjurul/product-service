FROM eclipse-temurin:17-jdk-alpine AS build
LABEL authors="Sk Monjurul Haque"
WORKDIR /app
COPY /product-application/target/*.jar /app/
RUN mkdir -p app/extracted && (java -Djarmode=layertools -jar app/*.jar extract --destination app/extracted)

FROM eclipse-temurin:17-jre-alpine
ARG EXTRACTED=/app/extracted
COPY ${EXTRACTED}/dependencies/ ./
COPY ${EXTRACTED}/spring-boot-loader/ ./
COPY ${EXTRACTED}/snapshot-dependencies/ ./
COPY ${EXTRACTED}/application/ ./
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]