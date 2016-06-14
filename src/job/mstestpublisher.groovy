// -*- coding:utf-8-unix -*-
import hudson.plugins.mstest.MSTestPublisher

def name = "mstestpublisher"
def jenkins = jenkins.model.Jenkins.getInstance()

def job = new FreeStyleProject(jenkins, name);
job.publishersList.add(new MSTestPublisher("build.trx", true, true))

// or
// job.publishersList.add(new MSTestPublisher("build.trx"))

job.save()
jenkins.model.Jenkins.instance.reload()
