pipeline {
    agent any
    
    environment {
        REPO_URL = 'https://github.com/pasangimhana/suggest-engine.git'
        JAR_NAME = 'suggest-engine-0.0.1-SNAPSHOT.jar'
    }

    stages {
        stage('Initial Cleanup') {
            steps {
                script {
                    def port = 8657
                    def runningProcess = sh(script: "sudo netstat -nlp | grep :${port} | awk '{print \$7}' | cut -d '/' -f 1", returnStdout: true).trim()
                    if (runningProcess) {
                        echo "Stopping process running on port ${port}"
                        sh "sudo kill -9 ${runningProcess}"
                    }
                    else {
                        echo "No process running!"
                    }
                }
            }
        }

        
        stage('Cloning Repository') {
            steps {
                git credentialsId: 'GitHub', url: 'https://github.com/pasangimhana/suggest-engine.git'
            }
        }
        
        stage('Cleaning Previous Downloads') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('Installing Dependancies') {
            steps {
                sh 'mvn install'
            }
        }
        
        stage('Building Artifact') {
            steps {
                sh 'mvn package'
            }
        }
        
        stage('Copy Artifact') {
                    steps {
                        sh 'cp target/${env.JAR_NAME} ~/'
                    }
        }
    }

    
        post {
            always {
                echo 'Cleaning up workspace'
                cleanWs()
                dir("${env.WORKSPACE}@tmp") {
                deleteDir()
                }
                dir("${env.WORKSPACE}@script") {
                deleteDir()
                }
                dir("${env.WORKSPACE}@script@tmp") {
                deleteDir()
                }
            }
        }
}