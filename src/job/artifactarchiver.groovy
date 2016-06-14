// -*- coding:utf-8-unix -*-
import hudson.tasks.ArtifactArchiver

def name = "artifactarchiver"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def artifactArchiver = new ArtifactArchiver("artifact.dll")
artifactArchiver.setOnlyIfSuccessful(false)
job.getPublishersList().add(artifactArchiver)

job.save()
jenkins.model.Jenkins.instance.reload()
