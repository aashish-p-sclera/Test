pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Manual Approval') {
            steps {
                input message: 'Do you want to deploy this change?', ok: 'Deploy'
            }
        }
        stage('Checkout and Deploy') {
            steps {
                script {
                    // Pull from Git
                    git url: 'https://github.com/aashishpanthi13/Test.git', branch: 'main'
                    // Build the app
                    bat 'mvn clean package'
                    // Build Docker image
                    bat 'docker build -t demo1:latest .'
                    // Stop and remove old container
                    bat 'docker stop demo1-container || exit 0'
                    bat 'docker rm demo1-container || exit 0'
                    // Run new container
                    bat 'docker run -d --name demo1-container -p 8080:8080 demo1:latest'
                }
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