pipeline {
    agent any

    tools {
        maven 'mvn-3.9.6'
    }

    parameters {
           string(name: 'CONTAINER_NAME', defaultValue: 'my_app', description: '')
           string(name: 'IMAGE_NAME', defaultValue: 'my-app', description: '')
       }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Deploy') {
            steps {
                def CONTAINER_ID = sh(script: "docker ps | grep portainer | awk '{print $1}'", returnStdout: true).trim()
                if (!CONTAINER_ID.isEmpty()) {
                   echo 'delete exists container'
                   sh 'docker stop ${CONTAINER_ID} && docker rm ${CONTAINER_ID}'
                }
                sh 'docker run -d --name ${CONTAINER_NAME} -p 7070:7070 ${IMAGE_NAME}:latest'
            }
        }
    }
}
