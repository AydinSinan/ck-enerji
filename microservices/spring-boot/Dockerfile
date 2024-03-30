# OpenJDK 17 kullanarak bir Docker imajı oluştur
FROM openjdk:17-alpine
COPY target/product-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

