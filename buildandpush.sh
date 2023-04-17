#!/bin/bash
echo "## Starting building java project"
./gradlew build
clear
echo "## finished building java project"

# Set variables for EC2 instance login
EC2_HOST="ec2-13-50-245-101.eu-north-1.compute.amazonaws.com"
EC2_USER="ubuntu"
EC2_KEY_PATH="C:\Users\morris.okworo\Downloads\aws-key-pair.pem"

# If Java 17 is not installed, install it
ssh -i "${EC2_KEY_PATH}" "${EC2_USER}@${EC2_HOST}" 'if ! type "java" &> /dev/null; then sudo apt-get update && sudo apt-get install -y openjdk-17-jdk; fi'

## SCP the executable Java file to the EC2 instance
scp -i "${EC2_KEY_PATH}" ./build/libs/spring-boot-aws-0.0.1-SNAPSHOT.jar "${EC2_USER}@${EC2_HOST}:"

## Run the executable Java file on the EC2 instance
ssh -i "${EC2_KEY_PATH}" "${EC2_USER}@${EC2_HOST}" "sudo kill \$(sudo lsof -t -i:8080) && java -jar spring-boot-aws-0.0.1-SNAPSHOT.jar"
