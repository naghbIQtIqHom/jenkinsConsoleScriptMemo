// -*- coding:utf-8-unix -*-
import org.jenkinsci.plugins.fxcop_runner.FxCopBuilder

def name = "fxcop"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def fxcop = new FxCopBuilder("FxCopCmd12", //String toolName,
			     "undercheck.dll", // String files,
			     "fxcop_result.mxl", // String outputXML,
			     "", // String ruleSet,
			     true, // boolean ignoreGeneratedCode,
			     true, // boolean forceOutput,
			     "", // String cmdLineArgs,
			     false /*boolean failBuild*/)
job.getBuildersList().add(fxcop)

job.save()
jenkins.model.Jenkins.instance.reload()
