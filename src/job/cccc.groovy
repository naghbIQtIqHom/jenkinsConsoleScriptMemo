// -*- coding:utf-8-unix -*-
import com.thalesgroup.hudson.plugins.cccc.*

def name = "cccc"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def metricFilePath = ".cccc/cccc.xml"
job.publishersList.add(new CcccPublisher(metricFilePath, true))

job.save()
jenkins.model.Jenkins.instance.reload()
