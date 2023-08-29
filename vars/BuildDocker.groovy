// def call(DockerHubUser, AppName, dockerImageTag) {
//     sh """
//     docker build -t $DockerHubUser/$AppName:v$dockerImageTag .
//     docker tag $DockerHubUser/$AppName:v$dockerImageTag $DockerHubUser/$AppName:latest
//     """
// }

def call(aws_account_id, ecr-repoName, region) {
    sh """
    docker build -t ${ecr-repoName}:${dockerImageTag} .
    docker tag ${ecr-repoName}:${dockerImageTag} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr-repoName}:${dockerImageTag}
    """
}