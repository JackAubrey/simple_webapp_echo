pipeline {
    agent any

    environment {
        GIT_REPO = 'git@github.com:JackAubrey/simple_webapp_echo.git'
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
    }

    stages {
        stage('Clone') {
            steps {
                echo "Clonando repository da ${GIT_REPO}..."
                git url: "${GIT_REPO}", credentialsId: 'jenkins-github-key'
            }
        }
        stage('Build') {
            steps {
                echo "Compilazione del progetto Quarkus: Simple Echo Server..."
                sh './mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                echo "Esecuzione test..."
                sh './mvnw test'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completata con successo!'
        }
        failure {
            echo 'La pipeline è fallita.'
        }
    }
}
