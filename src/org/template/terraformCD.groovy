package org.template

import org.common.*
import org.terraform.*

def call(String repoUrl, String branch, String credentialsId, String terraform_path,  String action, String message) {

    clean = new cleanWs()
    clone = new gitClone()
    terraformInit = new terraform_init()
    terraformPlan = new terraform_plan()
    terraformApply = new terraform_apply()
    terraformDestroy = new terraform_destroy()
    manualApproval = new manualapproval()
    
    clean.call()
    clone.call(repoUrl, branch, credentialsId)
    terraformInit.call(terraform_path)
    terraformPlan.call(terraform_path)

    if (action == 'apply') {
        manualApproval('Approval for infrastructure apply')
        terraformApply.call(terraform_path)
    } else if (action == 'destroy') {
        manualApproval('Approval for infrastructure destroy')
        terraformDestroy.call(terraform_path)
    } else {
        error("Invalid action: ${action}. Please specify 'apply' or 'destroy'.")
    }
}
