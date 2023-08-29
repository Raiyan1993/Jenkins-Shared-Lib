def call(DockerHubUser, AppName, dockerImageTag) {
    sh """
    trivy image $DockerHubUser/$AppName:v$dockerImageTag > scan.txt
    cat scan.txt
    """
}