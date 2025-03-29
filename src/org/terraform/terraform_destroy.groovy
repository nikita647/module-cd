package org.terraform

def call(String terraform_path) {
    stage('Terraform Destroy') {
    echo "Applying Terraform configuration in ${path}..."
    sh "terraform -chdir=${terraform_path} destroy --auto-approve"
    }
}
