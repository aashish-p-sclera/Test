pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/aashishpanthi13/Test.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t demo1:latest .'
            }
        }
        stage('Manual Approval') {
            steps {
                input message: 'Do you want to deploy this change?', ok: 'Deploy'
            }
        }
        stage('Deploy') {
            steps {
                bat 'docker stop demo1-container || exit 0'
                bat 'docker rm demo1-container || exit 0'
                bat 'docker run -d --name demo1-container -p 8080:8080 demo1:latest'
            }
        }
    }
    post {
        success {
            echo 'Deployment completed successfully!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}