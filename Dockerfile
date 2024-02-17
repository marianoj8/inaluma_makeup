FROM openjdk:17
WORKDIR /app
COPY target/inaluma_api_anew.jar /app/inaluma_api_anew.jar
SHELL ["/bin/sh", "-c"]
EXPOSE 8080
CMD java -jar inaluma_api_anew.jar