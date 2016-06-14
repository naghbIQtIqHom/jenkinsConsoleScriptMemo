// -*- coding:utf-8-unix -*-
import hudson.plugins.parameterizedtrigger.*

def name = "triggercallbuild"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name)

def predefined = "FOO=BAR\nFIZZ=BUZZ"
def predefinedbuildparameters = new PredefinedBuildParameters(predefined)
def buildParameters = [predefinedbuildparameters, new CurrentBuildParameters(), new NodeParameters()]
def projectToTrigger = "aaa"
def neverFail = new BlockingBehaviour("never", "never", "never")
def config = new BlockableBuildTriggerConfig(projectToTrigger, neverFail, buildParameters)
job.getBuildersList().add(new TriggerBuilder([config]))

def predefined2 = "FOO=BAR\nFIZZ=BUZZ"
def predefinedbuildparameters2 = new PredefinedBuildParameters(predefined)
def projectToTrigger2 = "bbb"
def config2 = new BuildTriggerConfig(projectToTrigger,
				     ResultCondition.SUCCESS,
				     predefinedbuildparameters)
job.getBuildersList().add(new BuildTrigger([config2]))

job.save()
jenkins.model.Jenkins.instance.reload()
