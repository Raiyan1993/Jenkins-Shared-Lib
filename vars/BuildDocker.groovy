def call(DockerHubUser, AppName, ImageTag) {
    sh """
    docker build -t $DockerHubUser/$AppName:$ImageTag .
    docker tag -t $DockerHubUser/$AppName:$ImageTag $DockerHubUser/$AppName:latest
    """

}