FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir /work
COPY . /work
WORKDIR /work
RUN /work/gradlew build
RUN mv /work/build/libs/*.jar /work/app.jar
ENTRYPOINT exec java -jar /work/app.jar --debug