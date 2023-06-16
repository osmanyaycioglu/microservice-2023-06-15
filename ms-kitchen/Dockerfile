FROM openjdk:17-jdk-alpine
WORKDIR kitchen
COPY target/ms-kitchen-1.0.0.jar ms-kitchen-1.0.0.jar
ENV PORT=80
ENV CHOST='configserver:http://config'
ENV DHOST='http://discovery/eureka/'
EXPOSE 80
ENTRYPOINT ["sh","-c","java -jar ms-kitchen-1.0.0.jar"]
