# Kubernetes Probes Demo

This project is a demonstration of how to implement liveness, readiness, and start probes in a
Kubernetes environment using Spring Boot, Gradle, and LaunchDarkly feature flags.

## Description

Kubernetes probes are essential for ensuring the health and availability of your application in a
containerized environment. This demo showcases the implementation of liveness, readiness, and start
probes, along with the use of feature flags provided by LaunchDarkly to enable or disable each probe
dynamically.

## Features

- **Liveness Probe**: Checks if the application is running properly. If the liveness probe fails,
  Kubernetes restarts the container.
- **Readiness Probe**: Determines if the application is ready to accept traffic. If the readiness
  probe fails, Kubernetes removes the pod from the endpoints of all services.
- **Start Probe**: Verifies if the application has completed its startup process successfully. It's
  particularly useful for applications that have a longer startup time.

## Getting Started

To run this demo locally, follow these steps:

1. Clone this repository to your local machine.
2. Set up a LaunchDarkly account and obtain an SDK key.
3. Update the application properties file with your LaunchDarkly SDK key.
4. Build the project using Gradle.
5. Run the Spring Boot application.
6. Access the application endpoints to test the probes.

## Usage

- **Liveness Probe**: Access the `/actuator/health/liveness-indicator` endpoint to trigger the liveness probe.
- **Readiness Probe**: Access the `/actuator/health/readiness-indicator` endpoint to trigger the readiness
  probe.
- **Start Probe**: The start probe is automatically triggered during application startup.
