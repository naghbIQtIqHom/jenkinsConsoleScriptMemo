// -*- coding:utf-8-unix -*-
import hudson.plugins.git.GitSCM
import hudson.plugins.git.BranchSpec 
import hudson.plugins.git.SubmoduleConfig
import hudson.plugins.git.UserRemoteConfig
import hudson.plugins.git.extensions.GitSCMExtension
import hudson.plugins.git.extensions.impl.RelativeTargetDirectory

def name = "git"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def credentialid = "01234567-89ab-cdef-0123-456789abcdef" // look for this string in your certain config.xml
def userRemoteConfigs = new ArrayList<UserRemoteConfig>()
userRemoteConfigs.add(new UserRemoteConfig("https:///gitbucket/git/me/FizzBuzz.git", "origin", "", credentialid))
def branches = Collections.singletonList(new BranchSpec("master"))
def doGenerateSubmoduleConfigurations = false
def submoduleCfg = Collections.<SubmoduleConfig>emptyList()
def browser = null
def gitTool = "msysGit"

def extensions = new ArrayList<GitSCMExtension>()
extensions.add(new RelativeTargetDirectory("FizzBuzz"))

def git = new GitSCM(userRemoteConfigs,
		     branches,
		     doGenerateSubmoduleConfigurations,
		     submoduleCfg,
		     browser,
		     gitTool,
		     extensions)
job.setScm(git)

job.save()
jenkins.model.Jenkins.instance.reload()
