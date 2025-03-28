package org.template

import org.common.*
import org.terraform.*
 
def call (String url, String branch='main', String creds, String terraform_path) {
 
 clean = new cleanWs()
 clone = new gitClone()
 terraformInit = new terraform_init()
 terraformPlan = new terraform_plan()
 terraformApply = new terraform_apply()


clean.call()
clone.call(url, branch, creds)
terraformInit.call(terraform_path)
terraformPlan.call(terraform_path)
terraformApply.call(terraform_path)

  
}
