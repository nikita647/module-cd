package org.terraform

    def call(String terraform_path) { 
        sh "terraform -chdir=${terraform_path} init"
    }
