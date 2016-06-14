// -*- coding:utf-8-unix -*-
import hudson.plugins.copyartifact.CopyArtifact
import hudson.plugins.copyartifact.StatusBuildSelector

def name = "copyArtifacts"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def otherProject = "copyfrom"
def parameters = null
def statusBuildSelector = new StatusBuildSelector(true)
def filter = "aaa/*.txt"
def target = "new/deep/dir" // ignore copy source
def excludes = "*.obj"
def flatten = false
def optional = false
def fingerprintArtifacts = true
def resultVariableSuffix = null

copyArtifact = new CopyArtifact(otherProject)
copyArtifact.setParameters(parameters)
copyArtifact.setSelector(statusBuildSelector)
copyArtifact.setFilter(filter)
copyArtifact.setExcludes(excludes)
copyArtifact.setTarget(target)
copyArtifact.setFlatten(flatten)
copyArtifact.setOptional(optional)
copyArtifact.setFingerprintArtifacts(fingerprintArtifacts)
copyArtifact.setResultVariableSuffix(resultVariableSuffix)

job.getBuildersList().add(copyArtifact)

job.save()
jenkins.model.Jenkins.instance.reload()
