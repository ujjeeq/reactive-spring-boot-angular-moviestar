FROM openjdk:8-slim
VOLUME /tmp
RUN mkdir /work
COPY . /work
WORKDIR /work
RUN /work/gradlew build --stacktrace
RUN mv /work/build/libs/*.jar /work/app.jar
ENTRYPOINT exec java -jar /work/app.jar --debug
