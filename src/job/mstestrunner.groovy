// -*- coding:utf-8-unix -*-
import org.jenkinsci.plugins.MsTestBuilder

def name = "mstestrunner"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def msTestName = "9.0\\Common7\\IDE\\MSTest.exe" // depend on your setting
def testFiles = "test.dll"
def categories = ""
def resultFile = "MSTestResult.trx"
def cmdLineArgs = ""
def continueOnFail = true
def msbuild = new MsTestBuilder(msTestName, testFiles, categories, resultFile, cmdLineArgs, continueOnFail)
job.getBuildersList().add(msbuild)

job.save()
jenkins.model.Jenkins.instance.reload()
