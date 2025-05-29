def call(String gitRepo, String branch = 'main') {
    pipeline {
        agent any

        options {
            timestamps()
            disableConcurrentBuilds()
        }

        stages {
            stage('Clone Code') {
                steps {
                    git branch: branch, url: gitRepo
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
