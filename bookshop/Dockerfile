FROM ubuntu
RUN apt update && apt install -y openjdk-8-jdk
COPY target/bookshop-1.0-SNAPSHOT.jar app.jar
CMD java -jar app.jar