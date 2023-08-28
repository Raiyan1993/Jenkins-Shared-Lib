def call(DockerHubUser, AppName, dockerImageTag) {
    sh """
    docker build -t $DockerHubUser/$AppName:$dockerImageTag .
    docker tag $DockerHubUser/$AppName:$dockerImageTag $DockerHubUser/$AppName:latest
    """
}