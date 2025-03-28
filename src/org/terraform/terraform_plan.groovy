package org.terraform

def call(def steps, String dir = '.') { 
        steps.sh """
        cd ${dir}
        terraform plan -var-file="dev.tfvars"
        """
    }
