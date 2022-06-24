# :pushpin: FWA - Java Servlet API (project 2022) 

### Topics lists:
- Servlets
- Authentication
- JSP

# :v: To compile code and launch FWA:

1. Go to Desktop
2. Clone project 
    - git clone https://github.com/gbroccol/java_projects.git fwa
3. Download tomcat server and run it
    - curl + unzip ...
    - chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/startup.sh
    - chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/catalina.sh
    - chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh
4. Launch project
    - cd fwa
    - mvn clean package
    - cp target/Cinema.war ~/Desktop/apache-tomcat-9.0.58/webapps
    - ~/Desktop/apache-tomcat-9.0.58/bin/startup.sh
5. Stop project 
    - ~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh
