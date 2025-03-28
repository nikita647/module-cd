package org.template

import org.common.*
import org.terraform.*
 
def call (String repoUrl, String branch='main', String credentialsId, String terraform_path) {
 
 clean = new cleanWs()
 clone = new gitClone()
 terraformInit = new terraform_init()
 terraformPlan = new terraform_plan()
 // terraformApply = new terraform_apply()
 // terraformDestroy = new terraform_destroy()


clean.call()
clone.call(repoUrl, branch, credentialsId)
terraformInit.call(terraform_path)
terraformPlan.call(terraform_path)
// terraformApply.call(terraform_path)
// terraformDestroy.call(terraform_path)

  
}
