mvn clean package


cp target/Cinema.war ~/Desktop/apache-tomcat-9.0.58/webapps
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/startup.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/catalina.sh
chmod 777 ~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh

~/Desktop/apache-tomcat-9.0.58/bin/shutdown.sh
~/Desktop/apache-tomcat-9.0.58/bin/startup.sh



#cp target/Cinema.war ~/Desktop/apache-tomcat-10.0.22/webapps
#chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/startup.sh
#chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/catalina.sh
#chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh
#
#~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh
#~/Desktop/apache-tomcat-10.0.22/bin/startup.sh
