// def call(DockerHubUser, AppName, dockerImageTag) {
//     withCredentials([usernamePassword(
//         credentialsId: 'docker-creds', 
//         passwordVariable: 'PASS', 
//         usernameVariable: 'USER'
//         )]) {

//         sh """
//         docker login -u '$USER' -p '$PASS'
//         docker push $DockerHubUser/$AppName:v$dockerImageTag
//         docker push $DockerHubUser/$AppName:latest
//         """
//         }
// }

def call(aws_account_id, repoName, dockerImageTag, region) {
    withCredentials([string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'), 
                     string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')]) {

        sh """
        aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
        docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repoName}:${dockerImageTag}
        """                   
    }
}