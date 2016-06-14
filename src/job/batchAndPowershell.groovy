// -*- coding:utf-8-unix -*-

// Windows batch and Powershell

def name = "batch_powershell"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def batchscript = '''echo %WORKSPACE%'''
def powershellscript = '''Write-Host Hello world!'''
job.getBuildersList().add(new hudson.tasks.BatchFile(batchscript))
job.getBuildersList().add(new hudson.plugins.powershell.PowerShell(powershellscript))

job.save()
jenkins.model.Jenkins.instance.reload()
