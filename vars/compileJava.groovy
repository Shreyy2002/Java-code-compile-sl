def call(Map config) {
    pipeline {
        agent any

        stages {
            stage('Clone Code') {
                steps {
                    git branch: config.branch, url: config.gitRepo
                }
            }

            stage('Compile Code') {
                steps {
                    sh 'mvn clean compile'
                }
            }
        }
    }
}
