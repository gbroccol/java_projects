
[//]: # (https://tomcat.apache.org/download-90.cgi#:~:text=Core%3A-,zip,-&#40;pgp%2C%20sha512&#41;)

chmod 777 start.sh

mvn clean package
cp target/Cinema.war ~/Desktop/apache-tomcat-10.0.22/webapps
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/startup.sh
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/catalina.sh
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh

~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh
~/Desktop/apache-tomcat-10.0.22/bin/startup.sh


