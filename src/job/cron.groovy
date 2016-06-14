// -*- coding:utf-8-unix -*-
import hudson.triggers.*

def name = "cron"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

// cf. https://wiki.jenkins-ci.org/display/JENKINS/Change+SCMTrigger+for+each+project+to+disable+during+the+night+and+the+week-end

def newTrigger = new hudson.triggers.TimerTrigger("0 20 * * *")
job.addTrigger(newTrigger)

job.save()
jenkins.model.Jenkins.instance.reload()
