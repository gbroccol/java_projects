mvn clean package

cp target/Cinema.war ~/Desktop/apache-tomcat-9.0.58/webapps
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/startup.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/catalina.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh

~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh
~/Desktop/apache-tomcat-9.0.58/bin/startup.sh