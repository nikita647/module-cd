package org.terraform

def call(String terraform_path) {
    stage('Terraform apply') {
    echo "Applying Terraform configuration in ${path}..."
    sh "terraform -chdir=${terraform_path} apply --auto-approve"
    }
}
