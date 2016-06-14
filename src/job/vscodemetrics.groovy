// -*- coding:utf-8-unix -*-
import org.jenkinsci.plugins.vs_code_metrics.VsCodeMetricsBuilder

def name = "vscodemetrics"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def toolName = "metrics12" // depend on your setting
def files = "undertest.dll"
def outputXML = "vscodemetrics.xml"
def directory = "serchingDirectories"
def searchGac = false
def platform = "platform"
def reference = "referer.dll"
def ignoreInvalidTargets = false
def ignoreGeneratedCode = true
def cmdLineArgs = ""
def failBuild = true
def vscodemetrics = new VsCodeMetricsBuilder(toolName,
					     files,
					     outputXML,
					     directory,
					     searchGac,
					     platform,
					     reference,
					     ignoreInvalidTargets,
					     ignoreGeneratedCode,
					     cmdLineArgs,
					     failBuild)
job.getBuildersList().add(vscodemetrics)

job.save()
jenkins.model.Jenkins.instance.reload()
