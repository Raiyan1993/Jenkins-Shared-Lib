// def call(DockerHubUser, AppName, dockerImageTag) {
//     sh """
//     docker build -t $DockerHubUser/$AppName:v$dockerImageTag .
//     docker tag $DockerHubUser/$AppName:v$dockerImageTag $DockerHubUser/$AppName:latest
//     """
// }

def call(aws_account_id, repoName, dockerImageTag, region) {
    sh """
    docker build -t ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName} .
    docker tag ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName}:${dockerImageTag}
    """
}