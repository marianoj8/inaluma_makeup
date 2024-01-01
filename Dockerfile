FROM openjdk:17
WORKDIR /app
COPY target/inaluma_api.jar /app/inaluma_api.jar
SHELL ["/bin/sh", "-c"]
EXPOSE 8080
CMD java -jar inaluma_api.jar
#CMD java -jar -Dspring.profiles.active=h2-dev wasp_avt_api.jar


# docker buildx build --platform linux/arm64/v8 -t waspti/wasp-avt-api:arm64-v8-dev-1.0-beta .
# docker push waspti/wasp-avt-api:arm64-v8-dev-1.0-beta