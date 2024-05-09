FROM tomcat:latest
COPY ${WAR_FILE} /usr/local/tomcat/webapps/app.jar
EXPOSE 1235
CMD ["catalina.sh","run"]
