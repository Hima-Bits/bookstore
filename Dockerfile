FROM openjdk:11
EXPOSE 8080
ADD target/bookstore-image.jar bookstore-image.jar
ENTRYPOINT ["java","-jar","/bookstore-image.jar"]