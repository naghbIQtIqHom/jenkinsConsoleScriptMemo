// -*- coding:utf-8-unix -*-
import hudson.plugins.violations.ViolationsPublisher

def name = "violation"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def violation = new ViolationsPublisher()
def config = violation.getConfig()
config.setEncoding("UTF-8")

def typeconfigmap = config.getTypeConfigs()
def fxcop = typeconfigmap["fxcop"]
fxcop.setPattern("fxcop_result.xml")

def stylecop = typeconfigmap["stylecop"]
stylecop.setPattern("stylecop_result.xml")

def cpplint = typeconfigmap["cpplint"]
cpplint.setPattern("cpplint_result.xml")

def gendarme = typeconfigmap["gendarme"]
gendarme.setPattern("gendarme_result.xml")

job.getPublishersList().add(violation)

job.save()
jenkins.model.Jenkins.instance.reload()
