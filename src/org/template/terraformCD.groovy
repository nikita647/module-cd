package org.template

import org.common.*
import org.terraform.*

def call(String repoUrl, String branch = 'main', String credentialsId, String terraform_path, String message, String action) {

    def clean = new cleanWs()
    def clone = new gitClone()
    def terraformInit = new terraform_init()
    def terraformPlan = new terraform_plan()
    def terraformApply = new terraform_apply()
    def terraformDestroy = new terraform_destroy()
    def manualApproval = new manualapproval()
    
    clean()
    clone(repoUrl, branch, credentialsId)
    terraformInit(terraform_path)
    terraformPlan(terraform_path)

    if (action == 'apply') {
        manualApproval('Approval for infrastructure apply')
        terraformApply(terraform_path)
    } else if (action == 'destroy') {
        manualApproval('Approval for infrastructure destroy')
        terraformDestroy(terraform_path)
    } else {
        error("Invalid action: ${action}. Please specify 'apply' or 'destroy'.")
    }
}
