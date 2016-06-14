// -*- coding:utf-8-unix -*-
//import org.jenkinsci.plugins.envinject

def name = "envinject"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);


// env inject into build wrapper
def content = '''A=abc
B=xyz'''
def prop = new org.jenkinsci.plugins.envinject.EnvInjectBuildWrapper()
prop.setInfo(new org.jenkinsci.plugins.envinject.EnvInjectJobPropertyInfo(null, content, null, null, null, false))
job.getBuildWrappersList().add(prop)

// inject global setting possword
def passwordWrapper = new org.jenkinsci.plugins.envinject.EnvInjectPasswordWrapper()
passwordWrapper.setInjectGlobalPasswords(true)
passwordWrapper.setMaskPasswordParameters(true)
job.getBuildWrappersList().add(passwordWrapper)

// env inject into build
// The first arg is that vars.properties is a relative file path from $workspace. If it doesn't exist, set null.
// The second arg is that properties of a=b format.
job.getBuildersList().add(new org.jenkinsci.plugins.envinject.EnvInjectBuilder("vars.properties", "TEXT_VAR=tvalue\nHOGE=uge"));

job.save()
jenkins.model.Jenkins.instance.reload()
