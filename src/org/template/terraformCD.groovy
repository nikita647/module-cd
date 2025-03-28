package org.template

import org.common.*
import org.golang.*
import org.genric.*
 
def call (String branch = 'main', String repoUrl, String gitPassword, String terraform_path) {
 
 clean = new cleanworkspace()
 clone = new gitclone()


clean.call()
clone.call(branch, repoUrl, gitPassword)

  
}
