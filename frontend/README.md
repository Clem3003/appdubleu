# Frontend

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 20.1.4.

# \> Docker

## Node
```bash
  npm install
```
## Angular build
```bash
  npm run build --prod
```
## Build image
```dockerfile
    docker build --no-cache . -t appdubleu-frontend
```
## Run container
```dockerfile
    docker run -p 4200:80 --name appdubleu-frontend -d appdubleu-frontend
```
## Check running containers
```dockerfile
docker ps
```
## Open browser
```http request
http://localhost:4200/
```


## Install no tests
```bash
    mvn clean install -DskipTests
```
```bash
    RUN BACKEND DOCKERFILE (with docker desktop open)
```
```bash
    docker image ls
```
```bash
    docker save -o C:\Users\cleme\Downloads\appdubleu-backend.tar CONTAINER_ID
```
### Debian
```bash
   docker load -i /home/debian/appdubleu-backend.tar
```
```bash
   docker image ls
```
```bash
   docker run -i -t -d --env=SPRING_DATASOURCE_URL=jdbc:postgresql://appdubleu-postgres:5432/cbstlo --env=SPRING_DATASOURCE_USERNAME=postgres --env=SPRING_DATASOURCE_PASSWORD=secret --network=stlo_network CONTAINER_ID
```

## Angular

```bash
  npm run build --prod
```
```bash
  docker build --no-cache . -t appdubleu-frontend
```
```bash
  docker image ls
```
```bash
  docker save -o C:\Users\cleme\Downloads\appdubleu-frontend.tar CONTAINER_ID
```
### Debian

```bash
  docker load -i /home/debian/appdubleu-frontend.tar
```
```bash
  
```






















# Other

## Development server

To start a local development server, run:

```bash
  ng serve
```
```bash
  ng serve --host 0.0.0.0
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.
