pipeline {
    agent any
    tools {
        maven 'Maven' // Tells Jenkins to use the Maven installation named 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/aashishpanthi13/Test.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package' // Builds the Spring Boot JAR
            }
        }
        stage('Manual Approval') {
            steps {
                input message: 'Do you want to deploy this change?', ok: 'Deploy'
            }
        }
        stage('Deploy') {
            steps {
                bat 'start java -jar target/hello-app-0.0.1-SNAPSHOT.jar' // Runs the JAR in a new window
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