package org.terraform

def call(String terraform_path) {
    echo "Applying Terraform configuration in ${path}..."
    sh "terraform -chdir=${terraform_path} apply --auto-approve"
}
