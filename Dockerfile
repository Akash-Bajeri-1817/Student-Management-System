# Stage 1: Build WAR using Maven
FROM maven:3.8-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build with verbose output to see if PostgreSQL driver is included
RUN mvn clean package -X

# Verify the driver is in the WAR
RUN unzip -l /app/target/ROOT.war | grep postgresql || echo "WARNING: PostgreSQL driver not found in WAR!"

# Stage 2: Deploy to Tomcat
FROM tomcat:10.1-jdk17

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Download PostgreSQL JDBC driver to Tomcat lib directory as backup
# This ensures the driver is available even if WAR doesn't include it
RUN curl -L https://jdbc.postgresql.org/download/postgresql-42.7.4.jar -o /usr/local/tomcat/lib/postgresql-42.7.4.jar

# Copy the WAR file
COPY --from=builder /app/target/ROOT.war /usr/local/tomcat/webapps/ROOT.war

# Configure for Render's port (10000)
EXPOSE 10000
RUN sed -i 's/port="8080"/port="10000"/' /usr/local/tomcat/conf/server.xml

# Enable detailed logging for debugging
ENV JAVA_OPTS="-Djava.util.logging.config.file=/usr/local/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager"

CMD ["catalina.sh", "run"]