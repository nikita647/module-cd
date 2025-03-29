package org.terraform

def call(String terraform_path) { 
        stage('Terraform plan') {
        echo "Running Terraform Plan in ${terraform_path}..."
        sh "terraform -chdir=${terraform_path} plan"
        }
    }
