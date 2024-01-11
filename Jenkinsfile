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
    }
}
