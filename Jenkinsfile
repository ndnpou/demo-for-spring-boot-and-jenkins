pipeline {
    agent any
    environment{
        TEST_VAR = "good game"
    }
    options {
      buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')
      disableConcurrentBuilds abortPrevious: true
    }
    parameters {
        string name: "GREETING", defaultValue: "Hello Default", description: ""
        booleanParam name: "IS_9_ON", defaultValue: "false", description: ""
        choice choices: ['RED', 'GREEN', 'BLUE', 'YELLOW', 'BLACK'], name: 'COLOR'
    }
    stages {
        stage('Stage 1') {
            steps {
                echo "GREETING = $params.GREETING"
                echo 'Hello World from Stage 1'
                echo "A stage can have multiple steps."
            }
        }
        stage('Stage 2') {
            steps {
                echo 'Hello World from Stage 2'
            }
        }
        stage('Stage 3') {
            steps {
                echo 'Hello World from Stage 3'
            }
        }
        stage('Stage 4 - Investigating env variables') {
            steps {
                echo "env.BUILD_ID = $env.BUILD_ID"
                echo "env.JENKINS_HOME = $env.JENKINS_HOME"
            }
        }
        stage('Stage 5 - Investigating currentBuild variables') {
            steps {
                echo "currentBuild.id = $currentBuild.id"
                echo "currentBuild.duration = $currentBuild.duration"
            }
        }
        stage('Stage 6 - Investigating variables some more') {
            steps {
                echo "env.TEST_VAR = $env.TEST_VAR"
            }
        }
        stage('Stage 7 - Investigating variables some more SCOPING') {
             environment{
                  TEST_VAR = "fun game"
             }
            steps {
                echo "env.TEST_VAR = $env.TEST_VAR"
            }
        }
        stage('Stage 8 - Investigating variables - freestyle params') {
            steps {
                echo "params.GREETING = $params.GREETING"
                echo "params.GREETING (access using curly braces) = ${params.GREETING}"
            }
        }
        stage('Stage 9 - Investigating input for manual confirmation') {
            when {
                expression {
                    params.IS_9_ON == true
                }
            }
            steps {
                input "Are you ready to continue with stage 10 - for example deployment to production"
            }
        }
        stage("Stage 10"){
            steps{
                echo "Reached stage 10"
            }
        }
        stage("Stage 11"){
            steps{
                echo "Now the pipeline is stored in version control in the Jenkinsfile on github"
            }
        }
    }
}
