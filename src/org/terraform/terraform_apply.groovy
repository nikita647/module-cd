package org.terraform


    def call(def steps, String dir = '.', boolean autoApprove = true) { 
        steps.sh """
        cd ${dir}
        terraform apply -var-file="dev.tfvars" ${autoApprove ? "-auto-approve" : ""}
        """
    
}
