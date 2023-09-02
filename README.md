# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Sprin doc opeanAPI](https://springdoc.org/)
* [OpenAPI Generator](https://openapi-generator.tech/)
* [OpenAPI Generator Plugin](https://openapi-generator.tech/docs/plugins)
* [OpeanAPI Spring Generator](https://openapi-generator.tech/docs/generators/spring)
* [OpenAPI Generator Maven Plugin Github](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin)


### Prerequisite
* Java 17

### Guides
The following guides illustrate how to run this project

* #### using maven
    * ```shell
        ./mvnw clean install
    or  
    * ```shell
        ./mvnw spring-boot:run -pl product-application
    or
    * ```shell
        java -jar product-application/target/*.jar
    or
    * [run from the IDE](https://www.jetbrains.com/help/idea/run-debug-configuration-spring-boot.html)
* #### using Docker
    * ```shell
        ./docker-build.sh
    * ```shell
        ./docker-run.sh

#### Access the Swagger UI by below url:
`http://localhost:9000/swagger-ui/index.html`