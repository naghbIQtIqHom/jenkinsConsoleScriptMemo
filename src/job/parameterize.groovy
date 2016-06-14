// -*- coding:utf-8-unix -*-

def name = "parameterize"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

job.addProperty(new ParametersDefinitionProperty(
    new StringParameterDefinition("A", "aaa", "Description1"),
    new StringParameterDefinition("C", "ccc", "Description2"),
    new StringParameterDefinition("B", "AAAA", "Description3")
))

job.save()
jenkins.model.Jenkins.instance.reload()
