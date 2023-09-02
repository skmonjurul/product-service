FROM eclipse-temurin:17-jre-alpine AS build
WORKDIR /workspace
COPY /product-application/target/*.jar /workspace/
RUN java -Djarmode=layertools -jar /workspace/*.jar extract

FROM eclipse-temurin:17-jre-alpine
LABEL authors="Sk Monjurul Haque"
WORKDIR /app
ARG EXTRACTED=/workspace
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
EXPOSE 9000
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]