def call(DockerHubUser, AppName, dockerImageTag) {
    sh """
    docker build -t $DockerHubUser/$AppName:v$dockerImageTag .
    docker tag $DockerHubUser/$AppName:v$dockerImageTag $DockerHubUser/$AppName:latest
    """
}