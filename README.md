# reactive-spring-boot-angular-moviestar
This example app shows how to build a basic non-blocking reactive full stack app with Spring Boot 2.0, Spring Data, and Angular 5.0.

The server(Backend) part provides two REST APIs, `/stars` and `/stars/{id}` that return data from a reactive MongoDB database. And accessing all other actuator endpoints(eg. `/actuator/info`, `/actuator/env`) requires authorization which is empowered by Spring Security(usernmae,passwords are configured in `applicatoin.properties`).The programming language for backend is using Kotlin. And it brings with a [Kotlin routing DSL](https://docs.spring.io/spring-framework/docs/5.0.4.RELEASE/kdoc-api/spring-framework/org.springframework.web.reactive.function.server/-router-function-dsl/) that allows one to leverage the [WebFlux functional API](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn) for writing clean and idiomatic code. 

The client(Frontend) part is using Angular 5 to present the data list from REST API and provied operation on them. And also add function to retrieve movie star images from a public open movie and TV database [TMDB](https://www.themoviedb.org/documentation/api?language=en).

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Kotlin TargetJVM 1.8) and [Node.js](https://nodejs.org/).

* [Getting Started](#getting-started)
* [Technologies Used](#technologies-used)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/ujjeeq/reactive-spring-boot-angular-moviestar.git
cd reactive-spring-boot-angular-moviestar
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server, directly run:
 
```bash
./gradlew bootRun
```
then to reach the REST APIs on `//localhost:8080`.

To run the client, cd into the `client` folder and run:
 
```bash
npm install && npm start
```
then to check the FrontEnd on `//localhost:4200`.

## Technologies Used

 - Language: [Kotlin](https://kotlin.link/) and  [TypeScript](https://www.typescriptlang.org/) 
 - Framework: [Spring Boot 2.0](https://projects.spring.io/spring-boot/) with [Spring 5 Kotlin support](https://docs.spring.io/spring/docs/current/spring-framework-reference/languages.html#kotlin) and [Spring WebFlux functional](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn)
 - Engine: [Netty](http://netty.io/) used for client and server
 - FrontEnd: [Angular](https://angular.io/) 
 - Reactive API: [Reactor](http://projectreactor.io/)
 - Persistence : [Spring Data Reactive MongoDB](https://spring.io/blog/2016/11/28/going-reactive-with-spring-data)
 - Build: [Gradle](https://gradle.org/)
 
 ## License

Apache 2.0, see [LICENSE](LICENSE)
