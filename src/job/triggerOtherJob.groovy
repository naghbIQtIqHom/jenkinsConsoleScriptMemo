// -*- coding:utf-8-unix -*-
                                           
import hudson.tasks.BuildTrigger

def name = "triggerOtherJob"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name)

def evenWhenUnstable = true
job.getPublishersList().add(new BuildTrigger("aaa", evenWhenUnstable))

// or
// job.getPublishersList().add(new BuildTrigger("aaa", "SUCCESS"))
// job.getPublishersList().add(new BuildTrigger("aaa", "UNSTABLE"))
// job.getPublishersList().add(new BuildTrigger("aaa", "FAILURE"))

job.save()
jenkins.model.Jenkins.instance.reload()
