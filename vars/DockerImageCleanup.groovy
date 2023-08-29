def call(aws_account_id, repoName, dockerImageTag, region) {
    sh """
    docker rmi ${repoName}:${dockerImageTag}
    docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName}:${dockerImageTag}
    """
}