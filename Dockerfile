FROM openjdk:11
WORKDIR ./
ENV MNGMT_PORT 10100
EXPOSE 10100
ENV SERVICE_PORT 9001
EXPOSE 9001
COPY build/libs/k8s-health-checks-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "k8s-health-checks-0.0.1-SNAPSHOT.jar"]
