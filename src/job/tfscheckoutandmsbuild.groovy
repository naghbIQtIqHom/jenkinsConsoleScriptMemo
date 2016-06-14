// -*- coding:utf-8-unix -*-

/*
  Checkout by TFS on the custom workspace
  then msbuild
 */

// import hudson.plugins.tfs // not need on console
import hudson.util.Secret

def name = "tfs_checkout_msbuild"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def serverUrl = "http://tfs:8080/"
def projectPath = "$/aaa/bbb/ccc/ddd"
def localPath = "."
def useUpdate = true
def workspaceName = "\${JOB_NAME}"
def userName = "ACVDIR\\me"
def password = new Secret("clef string")
job.scm = new hudson.plugins.tfs.TeamFoundationServerScm(serverUrl, projectPath, localPath, useUpdate, workspaceName, userName, password)

// custom workspace
job.setCustomWorkspace("C:\\customworkspace")

// MSBuild plugin
def msBuildName = "v4.0.30319\\MSBuild.exe" // depend on your setting
def msBuildFile = "FizzBuzz.sln"
def cmdLineArgs = ""
def buildVariablesAsProperties = false
def continueOnBuildFailure = false
def unstableIfWarnings = false
job.getBuildersList().add(new hudson.plugins.msbuild.MsBuildBuilder(msBuildName, msBuildFile, cmdLineArgs, buildVariablesAsProperties, continueOnBuildFailure, unstableIfWarnings))

// mail
def recipients = "nobody"
def notifyEveryUnstableBuild = false
def sendToIndividuals = false
mailer = new hudson.tasks.Mailer(recipients, notifyEveryUnstableBuild, sendToIndividuals)
job.getPublishersList().add(mailer)

// Emotional Jenkins
def emotionalJenkins = new org.jenkinsci.plugins.emotional_jenkins.EmotionalJenkinsPublisher()
job.getPublishersList().add(emotionalJenkins)

job.save()
jenkins.model.Jenkins.instance.reload()
