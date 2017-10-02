# Welcome to the Java One 2017 Escape Room
Your task will be to 'fix' this broken application, when it runs successfully you will be show a word on the screen - use that word to ESCAPE !

## Getting started
* Open a terminal
* Clone this repository : git clone https://github.com/gameontext/j12017escape.git

## Configuring your Kubernetes client
* Open Firefox 
* Click on 'IBM Cloud private' in the toolbar
* Click the 'admin' profile option in the top left hand portion of the screen
* Select 'Configure Client', copy the instructions and paste into the terminal window.

## Other useful information
* Build app with `bx dev build`
* Deploy to local Kubernetes with `bx dev deploy`

## Notes

### Configuration
The application is configured to provide JAX-RS REST capabilities, JNDI, JSON parsing and Contexts and Dependency Injection (CDI).

These capabilities are provided through dependencies in the pom.xml file and Liberty features enabled in the server config file found in `src/main/liberty/config/server.xml`.

### Project contents
The microservice application has a health endpoint which is accessible at `<host>:<port>/j12017escape/health`. The context root is set in the `src/main/webapp/WEB-INF/ibm-web-ext.xml` file. The ports are set in the pom.xml file and exposed to the CLI in the cli-config.yml file.

The project contains Bluemix specific files that are used to deploy the application as part of a Bluemix DevOps flow. The `.bluemix` directory contains files used to define the Bluemix toolchain and pipeline for your application. The `manifest.yml` file specifies the name of your application in Bluemix, the timeout value during deployment and which services to bind to.

This microservice application is configured to connect to the following services :
* [Bluemix Cloudant service](https://console.ng.bluemix.net/catalog/services/cloudant-nosql-db).

Credentials are either taken from the VCAP_SERVICES environment variable that Bluemix provides or from environment variables passed in by JNDI (see the server config file `src/main/liberty/config/server.xml`).

### Run

To build and run the application:
1. `mvn install`
1. `mvn liberty:run-server`


To run the application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

### Endpoints

The application exposes the following endpoints:
* Health endpoint: `<host>:<port>/<contextRoot>/health`
* Cloudant example endpoint: `<host>:<port>/<contextRoot>/v1/example/cloudant`

The context root is set in the `src/main/webapp/WEB-INF/ibm-web-ext.xml` file. The ports are set in the pom.xml file and exposed to the CLI in the cli-config.yml file.

### Notices

This project was generated using:
* generator-java v2.5.10
* java-common v2.3.0
* generator-ibm-service-enablement v0.0.88
* generator-ibm-cloud-enablement v0.0.98
* generator-liberty v5.3.3



