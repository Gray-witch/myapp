pipeline {
    agent any

    tools {
        maven 'mvn-3.9.6'
    }

    parameters {
        string(name: 'CONTAINER_NAME', defaultValue: 'my_app', description: '')
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    def groupId = sh(script: 'mvn help:evaluate -Dexpression=project.groupId -q -DforceStdout', returnStdout: true).trim()
                    def artifactId = sh(script: 'mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout', returnStdout: true).trim()

                    def IMAGE_NAME = "${groupId}/${artifactId}"

                    def containerId = sh(script: "docker ps | grep ${params.CONTAINER_NAME} | awk '{print \$1}'", returnStdout: true).trim()
                    if (!containerId.isEmpty()) {
                        echo "delete exists container ${containerId}"
                        sh "docker stop ${containerId} && docker rm ${containerId}"
                    }
                    sh "docker run -d --name ${params.CONTAINER_NAME} -p 7070:7070 ${IMAGE_NAME}:latest"
                    sh "docker rmi \$(docker images -q --filter 'dangling=true')"
                }
            }
        }
    }
}