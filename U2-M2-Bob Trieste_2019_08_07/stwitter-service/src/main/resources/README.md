Stwitter System Project - Summative 8 Bob Trieste

This assessment includes the use of queues, edge services, Feign, caching, config servers, and Eureka in a project that allows users to create new posts and comments inside a company intranet platform.

This is a simple  social media service. The project was started as a proof of concept for use on the company intranet.

System Design

General Requirements
the services use the Config Server for their configuration settings.
the services register with Eureka.
web service to web service communication is done using a Feign client.
services must have a complete set of unit/integration tests.
data must be cached as appropriate.

Component Specifications
Spring Cloud Config Server
Port
Config Server on port 1999.

Eureka
Eureka in the standard configuration.

Stwitter Service is the edge service with which end user applications

Port
Run the Stwitter Service on port 8889.

The environment contains a post-service, comment-service, Stwitter service, and a comment-service-queue plus cloud, and eureka.

The stwitter contains a service layer that contacts Post and Comment through Feign (for almost all methods) or the Queue (just when we create a new comment).
