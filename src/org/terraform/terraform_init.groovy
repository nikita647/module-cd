package org.terraform

    def call(String terraform_path) { 
        stage('Terraform init') {
        sh "terraform -chdir=${terraform_path} init"
        }
    }
