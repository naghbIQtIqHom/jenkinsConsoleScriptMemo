// -*- coding:utf-8-unix -*-
import hudson.plugins.createfingerprint.CreateFingerprint

def name = "fingerprint"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

// create dummy file
job.getBuildersList().add(new hudson.tasks.BatchFile("if not exist test.txt echo \"aaaaa\" >test.txt"))

def createFingerPrint = new CreateFingerprint("test.txt")
job.getBuildersList().add(createFingerPrint)

job.save()
jenkins.model.Jenkins.instance.reload()


