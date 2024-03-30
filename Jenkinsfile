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

    post {
        always{
              echo "Slack Notifications"
              slackSend channel: '#test',
              color: COLOR_MAP[currentBuild.currentResult],
              message:"*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More Info at: ${env.BUILD_URL}"
        }

        success{
            script{
                try{
                    // Checkout the main branch
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/cmercadal/minorista.git']]])
                    git branch: 'develop', changelog: false, credentialsId: 'cmercadal', message: 'Merge develop into master', nff: true, remote: 'origin'
                    git push origin main
                }catch (Exception e){
                    echo "Error ocurred while merging ${e.message}"
                }
            }
        }
    }
}