pipeline {
    agent {label 'docker-maven'}

    stages {
        stage('Utests') {
            steps {
                dir('jenkins-pipelines-utests') {
                    sh 'mvn -B -Dmaven.test.failure.ignore clean verify'
                    junit '**/target/surefire-reports/TEST-*.xml'
                }                
            }
        }
    }

    post { 
        always { 
            cleanWs()
        }
    }
}
