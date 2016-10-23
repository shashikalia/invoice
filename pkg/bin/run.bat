@echo off
echo "starting application "
cd ../..
call mvn validate
call mvn package
call mvn clean install tomcat7:run
pause
@echo on