mvn clean package

cp target/Cinema.war ~/Desktop/apache-tomcat-9.0.64/webapps
chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/startup.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/catalina.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.64/bin/shutdown.sh

~/Desktop/apache-tomcat-9.0.64/bin/shutdown.sh
~/Desktop/apache-tomcat-9.0.64/bin/startup.sh