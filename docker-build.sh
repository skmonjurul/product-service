mvn clean package
docker image rm -f product-service
docker build --no-cache -t product-service .