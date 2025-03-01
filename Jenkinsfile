pipeline {
    agent any

    environment {
        IMAGE_NAME = 'eshwarchawda/scientific-calculator'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Clean Old Docker Image') {
            steps {
                script {
                    def imageExists = sh(script: "docker images -q ${IMAGE_NAME}:${IMAGE_TAG}", returnStdout: true).trim()
                    if (imageExists) {
                        echo "Deleting existing Docker image: ${IMAGE_NAME}:${IMAGE_TAG}"
                        sh "docker rmi -f ${IMAGE_NAME}:${IMAGE_TAG}"
                    } else {
                        echo "No existing Docker image found for ${IMAGE_NAME}:${IMAGE_TAG}"
                    }
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t eshwarchawda/scientific-calculator:latest .'
            }
        }
        stage('Docker Push') {
            steps {
                withDockerRegistry([credentialsId: '889830cd-89f3-4dbc-9a21-83dae639e2eb', url: 'https://index.docker.io/v1/']) {
                    sh 'docker push eshwarchawda/scientific-calculator:latest'
                }
            }
        }
        stage('Remove Docker Local Image') {
            steps {
                script {
                    def containerName = 'scientific-calculator'
                    def result = sh(script: "docker ps -a --filter \"name=${containerName}\" --format '{{.Names}}'", returnStdout: true).trim()

                    if (result == containerName) {
                        echo "Docker container '${containerName}' exists."
                        sh 'docker stop scientific-calculator'
                        sh 'docker rm scientific-calculator'
                    } else {
                        echo "Docker container '${containerName}' does not exist."
                    }
                }

                sh 'docker rmi eshwarchawda/scientific-calculator:latest'
            }
        }
        stage('Deploy with Ansible') {
            steps {
                script {
                    try {
                        sh 'ansible-playbook deploy_calculator.yml'
                    } catch (Exception e) {
                        error("Ansible Deployment failed: ${e}")
                    }
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
