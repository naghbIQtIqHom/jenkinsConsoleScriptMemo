// -*- coding:utf-8-unix -*-
import hudson.plugins.msbuild.MsBuildBuilder

def name = "msbuild"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def msbuild = new MsBuildBuilder("v3.5\\MSBuild.exe", // depend on your global setting // String msBuildName,
				 "foo.sln", // String msBuildFile,
				 "/p:a", // String cmdLineArgs,
				 true, // boolean buildVariablesAsProperties,
				 true, // boolean continueOnBuildFailure,
				 true /* boolean unstableIfWarnings */)
job.getBuildersList().add(msbuild)

job.save()
jenkins.model.Jenkins.instance.reload()
