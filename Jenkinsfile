@Library('terraform@Nikita-SCRUM-337') _

def cipipeline = new org.template.terraformCD()

node {
    def repoUrl = 'https://github.com/nikita647/terraform_infra.git'
    def branch = 'main'
    def gitPassword = 'git-cred'
    def terraformPath = "/var/lib/jenkins/workspace/job6"
    def terraformHome = tool 'terraform'
    env.PATH = "${terraformHome}/bin:${env.PATH}"
    
    properties([
        parameters([
            choice(name: 'action', choices: ['apply', 'destroy'], description: 'Choose any one option')
        ])
    ])
    
  def message = (params.action == 'apply') ? 'Approval for infrastructure apply' : 'Approval for infrastructure destroy'


    cipipeline.call(repoUrl, branch, gitPassword, terraformPath, message, params.action)
}
