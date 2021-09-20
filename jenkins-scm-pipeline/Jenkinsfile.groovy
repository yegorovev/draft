pipeline {
    agent any

    options {
        timestamps()
    }
    stages {
        stage('First stage') {
            steps {
                sh 'echo This is bash'
            }
        }
        stage ('Parallel') {
            parallel {
                stage('Parallel 1') {
                    steps {
                        sh 'echo 1'
                    }
                }
                stage('Parallel 2') {
                    steps {
                        sh 'echo 2'
                    }
                }
            }
        }
    }
}