def call(DockerHubUser, AppName, dockerImageTag) {
    withCredentials([usernamePassword(
        credentialsId: 'docker-creds', 
        passwordVariable: 'PASS', 
        usernameVariable: 'USER'
        )]) {

        sh """
        docker login -u '$USER' -p '$PASS'
        docker push $DockerHubUser/$AppName:v$dockerImageTag
        docker push $DockerHubUser/$AppName:latest
        """
        }
}