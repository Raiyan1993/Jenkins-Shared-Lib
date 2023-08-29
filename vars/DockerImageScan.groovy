// def call(DockerHubUser, AppName, dockerImageTag) {
//     sh """
//     trivy image $DockerHubUser/$AppName:v$dockerImageTag > scan.txt
//     cat scan.txt
//     """
// }

def call(aws_account_id, repoName, dockerImageTag, region) {
    sh """
    trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName}:${dockerImageTag} > scan.txt
    cat scan.txt
    """
}
