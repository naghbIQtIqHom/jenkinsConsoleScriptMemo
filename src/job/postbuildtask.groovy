// -*- coding:utf-8-unix -*-
import hudson.plugins.postbuildtask.*

def name = "postbuildtask"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def logText = "ビルドを中止しました。" // in Japanese environment
def operator = "OR"
def logprop = new LogProperties(logText, operator)
def logprops = [logprop]

def script = "abc"
def EscalateStatus = false
def RunIfJobSuccessful = false
def prop = new TaskProperties(script, EscalateStatus, RunIfJobSuccessful)
prop.setLogTexts((LogProperties[])logprops.toArray())

def script2 = "defg"
def prop2 = new TaskProperties(script2, false, false)
prop2.setLogTexts((LogProperties[])[new LogProperties("", null)].toArray())

def postbuildtask = new PostbuildTask([prop, prop2])

job.getPublishersList().add(postbuildtask)

job.save()
jenkins.model.Jenkins.instance.reload()
