# :pushpin: FWA - Java Servlet API (project 2022) 

### Topics lists:
- Servlets
- Authentication
- JSP

# :v: To compile code and launch FWA:
1. Make sure maven is installed, postgres server is running.
2. Go to Desktop
3. Clone project
    git clone git@vogsphere.msk.21-school.ru:vogsphere/intra-uuid-4444c711-0903-4b16-b7ce-812ee61d665f-4199227-sjolynn fwa
4. Download tomcat server and run it
    curl http://dlcdn.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.zip --output tomcat.zip
    unzip tomcat.zip
    chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/startup.sh
    chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/catalina.sh
    chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/shutdown.sh
5. Fill out application.properties file with db connection data and avatar storage path.
6. Go to project directory and launch project
    mvn clean package
    cp target/Cinema.war ~/Desktop/apache-tomcat-9.0.64/webapps
    ~/Desktop/apache-tomcat-9.0.64/bin/startup.sh
7. Stop project
    ~/Desktop/apache-tomcat-9.0.64/bin/shutdown.sh
