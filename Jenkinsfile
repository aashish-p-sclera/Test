pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Manual Approval') {
            steps {
                echo "Building branch: main"  // Optional: Hard-code this too
                input message: 'Do you want to deploy this change?', ok: 'Deploy'
            }
        }
        stage('Checkout and Deploy') {
            steps {
                script {
                    git url: 'https://github.com/aashishpanthi13/Test.git', branch: 'main'
                    bat 'mvn clean package'
                    bat 'docker build -t demo1:latest .'
                    bat 'docker stop demo1-container || exit 0'
                    bat 'docker rm demo1-container || exit 0'
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