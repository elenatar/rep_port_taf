pipeline {
    agent any
    stages {
        stage("Pull code") {
            steps {
                git branch: 'ci-cd-module',
                credentialsId: 'elenatar',
                url: 'https://github.com/elenatar/rep_port_taf.git'
            }
        }
    }
}