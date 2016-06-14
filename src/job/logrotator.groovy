// -*- coding:utf-8-unix -*-

def name = "logrotator"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def logrotator = new hudson.tasks.LogRotator("300", "", "300", "")
job.setBuildDiscarder(logrotator)

job.save()
jenkins.model.Jenkins.instance.reload()
