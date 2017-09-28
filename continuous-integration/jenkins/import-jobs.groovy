import jenkins.model.Jenkins
import hudson.plugins.git.*;

def scm = new GitSCM("https://github.com/SatoGlobal/CoreServices.git")
scm.branches = [new BranchSpec("*/release_v1.2")];

def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")

def parent = Jenkins.instance
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, "CoreServices")
job.definition = flowDefinition

parent.reload()


def gitUrl = 'git://github.com/test/test'

job('CoreServices') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/release_v1.2')
    }
    steps {
        maven('clean verify -D skipTests')
    }
}