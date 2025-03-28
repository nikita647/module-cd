package org.template

import org.common.*
import org.terraform.*


def call(String repoUrl, String branch = 'main', String credentialsId, String terraform_path, String action = 'apply') {

    clean = new cleanWs()
    clone = new gitClone()
    terraformInit = new terraform_init()
    terraformPlan = new terraform_plan()
    terraformApply = new terraform_apply()
    terraformDestroy = new terraform_destroy()

    clean.call()
    clone.call(repoUrl, branch, credentialsId)
    terraformInit.call(terraform_path)
    terraformPlan.call(terraform_path)

    if (action == 'apply')
    {
        input message: 'Approval for infrastructure apply', ok: 'approval'
        terraformApply.call(terraform_path)
    }
        
    } else if (action == 'destroy') {
     input message: 'Approval for infrastructure destroy', ok: 'approval'
        terraformDestroy.call(terraform_path)
    } else {
        error("Invalid action: ${action}. Please specify 'apply' or 'destroy'.")
    }
}
