pipeline {
  agent {
    docker {
      image 'maven:3.3.9-jdk-8'
      args '-v //c/Users/SOA/.m2:/root/.m2'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install -Dmaven.test.failure.ignore=true '
      }
    }
    stage('Report') {
      steps {
        junit 'target/surefire-reports/*'
        archiveArtifacts 'target/*.war'
      }
    }
  }
}