@Library('terraform@Nikita-187') _

def cipipeline = new org.template.terraformCD()

def call(String repoUrl, String branch = 'main', String credentialsId, String terraform_path, String action = 'apply') {

    def clean = new org.common.cleanWs()
    def clone = new org.common.gitClone()
    def terraformInit = new org.terraform.terraform_init()
    def terraformPlan = new org.terraform.terraform_plan()
    def terraformApply = new org.terraform.terraform_apply()
    def terraformDestroy = new org.terraform.terraform_destroy()

    clean.call()
    clone.call(repoUrl, branch, credentialsId)
    terraformInit.call(terraform_path)
    terraformPlan.call(terraform_path)

    if (action == 'apply') {
        terraformApply.call(terraform_path)
    } else if (action == 'destroy') {
        terraformDestroy.call(terraform_path)
    } else {
        error("Invalid action: ${action}. Please specify 'apply' or 'destroy'.")
    }
}
