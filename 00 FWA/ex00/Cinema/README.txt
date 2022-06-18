
[//]: # (https://tomcat.apache.org/download-90.cgi#:~:text=Core%3A-,zip,-&#40;pgp%2C%20sha512&#41;)

chmod 777 start.sh

mvn clean package
cp target/Cinema.war ~/Desktop/apache-tomcat-10.0.22/webapps
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/startup.sh
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/catalina.sh
chmod 777 ~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh

~/Desktop/apache-tomcat-10.0.22/bin/shutdown.sh
~/Desktop/apache-tomcat-10.0.22/bin/startup.sh


# :pushpin: JAVA_piscine (project 2021) 
## :bulb: Day 00 - Management structures and arrays
### Task lists:
- [x] ex00
- [x] ex01
- [x] ex02
- [x] ex03
- [x] ex04
- [ ] ex05
### Useful links:
[Oracle standarts](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

## :bulb: Day 01 - OOP/Collections
### Task lists:
- [x] ex00
- [x] ex01
- [x] ex02
- [x] ex03
- [x] ex04
- [x] ex05

<!-- ### Useful links: -->


## :bulb: Day 02 - IO/Files
### Task lists:
- [x] ex00
- [x] ex01
- [x] ex02
