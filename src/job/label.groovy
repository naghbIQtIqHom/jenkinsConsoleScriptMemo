// -*- coding:utf-8-unix -*-

def name = "label"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def label = Hudson.instance.getLabel('computerA')
job.setAssignedLabel(label)

job.save()
jenkins.model.Jenkins.instance.reload()
