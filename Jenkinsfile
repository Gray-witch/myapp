pipeline {
    agent any

    tools {
        maven 'mvn-3.9.6'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker stop my_app && docker rm my_app'
                sh 'docker run -d --name my_app -p 7070:7070 my-app:latest'
            }
        }
    }
}
