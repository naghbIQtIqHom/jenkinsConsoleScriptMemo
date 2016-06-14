// -*- coding:utf-8-unix -*-

import hudson.plugins.nunit.NUnitPublisher

def name = "nunitPublisher"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def testResultsPattern = "**/*.xml"
def debug = true
def keepJUnitReports = false
def skipJUnitArchiver = false
def failIfNoResults = true
job.publishersList.add(new NUnitPublisher(testResultsPattern, debug, keepJUnitReports, skipJUnitArchiver, failIfNoResults))

// or
// job.publishersList.add(new NUnitPublisher("**/*.xml", true, false, false, true))

job.save()
jenkins.model.Jenkins.instance.reload()
