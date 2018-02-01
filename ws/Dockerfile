FROM openjdk:8-jdk-alpine as jdk
WORKDIR /build
COPY ./gradle /build/gradle/
COPY ./gradle** /build/
COPY ./build.gradle /build/
RUN ./gradlew resolveDependencies --no-daemon
ADD . /build/
RUN ./gradlew -Pprod --no-daemon bootRepackage

FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war
EXPOSE 8081
COPY --from=jdk /build/build/libs/*.war /app.war
