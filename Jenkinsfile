def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']

pipeline {
    agent any
    //agent {label "my_agent"}

    tools {
        maven "mvn386"
        jdk "java11"
    }

    stages {
        stage('Hello') {
            steps {
                echo "Initializing pipeline"
            }
        }
        stage("Git pulling"){
            steps {
                //git branch: 'main', url: 'https://github.com/cmercadal/apirest1.git'
                 // Checkout the repository using SSH
                // git branch:'master', credentialsID
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'git@github.com:cmercadal/minorista.git']],
                          extensions: [[$class: 'CleanBeforeCheckout']]])
            }
        }

        stage("Build con Maven"){
            steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean install"
            }

            post{
                success{
                echo 'archivando artefactos'
                archiveArtifacts "target/*.jar"
                }
            }
        }

        stage("Test maven"){
            steps{
                sh "mvn test"
            }
        }

        stage("Sonar scan"){
            steps{
                echo 'Sonar analysis'
                withSonarQubeEnv('sonar'){
                    sh 'mvn clean package sonar:sonar -Dsonar.junit.reportsPath=/target/surefire-reports/'
                }
            }
        }

    }
}