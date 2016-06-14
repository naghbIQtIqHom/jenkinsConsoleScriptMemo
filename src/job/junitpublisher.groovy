// -*- coding:utf-8-unix -*-

import hudson.tasks.junit.JUnitResultArchiver

def name = "junitpublisher"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);


def testResults = "**/junit.xml"
def keepLongStdio = true
def testDataPublishers = null
def healthScaleFactor = 3.14

def publisher = new JUnitResultArchiver(testResults,
					keepLongStdio,
					testDataPublishers,
					healthScaleFactor)
def job.publishersList.add(publisher)

// or
// def publisher = new JUnitResultArchiver("**/junit.xml")

job.save()
jenkins.model.Jenkins.instance.reload()
