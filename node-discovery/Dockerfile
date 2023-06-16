FROM openjdk:17-jdk-alpine
WORKDIR discovery
COPY target/node-discovery-1.0.0.jar node-discovery-1.0.0.jar
ENV DPORT=80
ENV DHOST='http://discovery/eureka/'
EXPOSE 80
ENTRYPOINT ["sh","-c","java -jar node-discovery-1.0.0.jar"]
