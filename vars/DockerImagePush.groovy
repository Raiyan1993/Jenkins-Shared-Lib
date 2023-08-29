def call(DockerHubUser, AppName, dockerImageTag) {
    withCredentials([usernamePassword(
        credentialsId: 'docker-creds', 
        passwordVariable: 'PASS', 
        usernameVariable: 'USER'
        )]) {

        sh """
        docker login -u '$USER' -p '$PASS'
        docker push image $DockerHubUser/$AppName:v$dockerImageTag
        docker push image $DockerHubUser/$AppName:latest
        """
        }
}