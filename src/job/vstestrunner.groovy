// -*- coding:utf-8-unix -*-
import org.jenkinsci.plugins.vstest_runner.VsTestBuilder

def name = "vstestrunner"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def vsTestName         = "VSTEST14" // depend on your setting
def testFiles	       = "test.dll"
def settings	       = ""
def tests	       = ""
def testCaseFilter     = ""
def enablecodecoverage = true
def inIsolation	       = false
def useVsixExtensions  = false
def platform	       = ""
def otherPlatform      = ""
def framework	       = ""
def otherFramework     = ""
def logger	       = "trx"
def otherLogger	       = ""
def cmdLineArgs	       = ""
def failBuild	       = false
def vstest = new VsTestBuilder(vsTestName
			       testFiles
			       settings
			       tests
			       testCaseFilter
			       enablecodecoverage
			       inIsolation
			       useVsixExtensions
			       platform
			       otherPlatform
			       framework
			       otherFramework
			       logger
			       otherLogger
			       cmdLineArgs
			       failBuild)
job.getBuildersList().add(vstest)

job.save()
jenkins.model.Jenkins.instance.reload()
