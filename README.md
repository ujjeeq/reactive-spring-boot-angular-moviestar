# reactive-spring-boot-angular-moviestar
This example app shows how to build a basic reactive full stack app with Spring Boot 2.0, Spring Data, and Angular 5.0.


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

To run the client, cd into the `client` folder and run:
 
```bash
npm install && npm start
```

## Technologies Used

 - Language: [Kotlin](https://kotlin.link/) and  [TypeScript](https://www.typescriptlang.org/) 
 - Framework: [Spring Boot 2.0](https://projects.spring.io/spring-boot/) with [Spring 5 Kotlin support](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/kotlin.html) and [Spring WebFlux functional](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/reactive-web.html)
 - Engine: [Netty](http://netty.io/) used for client and server
 - FrontEnd: [Angular](https://angular.io/) 
 - Reactive API: [Reactor](http://projectreactor.io/)
 - Persistence : [Spring Data Reactive MongoDB](https://spring.io/blog/2016/11/28/going-reactive-with-spring-data)
 - Build: [Gradle](https://gradle.org/)
 
 ## License

Apache 2.0, see [LICENSE](LICENSE)
