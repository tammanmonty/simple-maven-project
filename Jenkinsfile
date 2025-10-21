pipeline {
    agent any
    tools {
        maven 'maven_3_6_3'
    }
    stages {
        stage('Build Maven Project') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/tammanmonty/simple-maven-project']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build --tag tammanmonty/devops-integration .'
                }
            }
        }
        stage('Push Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u tammanmonty -p ${dockerhubpwd}'
                    }
                    sh 'docker push tammanmonty/devops-integration'
                }
            }
        }
    }
}