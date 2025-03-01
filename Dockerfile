FROM openjdk:17
COPY target/Scientific-Calculator-1.0-SNAPSHOT.jar /app.jar
CMD ["tail", "-f", "/dev/null"]