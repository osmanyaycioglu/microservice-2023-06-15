FROM openjdk:17-jdk-alpine
WORKDIR order
COPY target/ms-order-1.0.0.jar ms-order-1.0.0.jar
ENV PORT=80
ENV CHOST='configserver:http://config'
ENV DHOST='http://discovery/eureka/'
EXPOSE 80
ENTRYPOINT ["sh","-c","java -jar ms-order-1.0.0.jar"]
