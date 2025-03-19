pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/aashishpanthi13/Test.git', branch: 'main' // Replace with your repo URL
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package' // Builds the Spring Boot JAR
            }
        }
        stage('Manual Approval') {
            steps {
                input message: 'Do you want to deploy this change?', ok: 'Deploy' // Waits for user approval
            }
        }
        stage('Deploy') {
            steps {
                sh 'java -jar target/hello-app-0.0.1-SNAPSHOT.jar &' // Runs the JAR in the background
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