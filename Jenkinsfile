pipeline {
    agent any

    tools {
        maven 'mvn-3.9.6'
    }

    stages {
        stage('Build') {
            steps {
                echo 'mvn build start'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy'
            }
        }
    }

    post {
        always {
            echo 'Completed'
        }
    }
}
