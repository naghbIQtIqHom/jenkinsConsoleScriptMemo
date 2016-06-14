// -*- coding:utf-8-unix -*-
import org.jenkinsci.plugins.cppcheck.*

def name = "cppcheck"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def pattern = "cppcheck_result.xml"
def ignoreBlankFiles = true
def threshold = ""
def allowNoReport = true
def String newThreshold,
def failureThreshold = ""
def newFailureThreshold = ""
def healthy = ""
def unHealthy = ""
def severityError = true
def severityWarning = true
def severityStyle = true
def severityPerformance = true
def severityInformation = true
def severityNoCategory = true
def severityPortability = true
def xSize = 500
def ySize = 200
def numBuildsInGraph = 0
def displayAllErrors = true
def displayErrorSeverity = true
def displayWarningSeverity = true
def displayStyleSeverity = true
def displayPerformanceSeverity = true
def displayInformationSeverity = true
def displayNoCategorySeverity = true
def displayPortabilitySeverity = true

job.publishersList.add(new CppcheckPublisher(pattern,
                                             ignoreBlankFiles,
                                             threshold,
                                             allowNoReport,
                                             newThreshold,
                                             failureThreshold,
                                             newFailureThreshold,
                                             healthy,
                                             unHealthy,
                                             severityError,
                                             severityWarning,
                                             severityStyle,
                                             severityPerformance,
                                             severityInformation,
                                             severityNoCategory,
                                             severityPortability,
                                             xSize,
                                             ySize,
                                             numBuildsInGraph,
                                             displayAllErrors,
                                             displayErrorSeverity,
                                             displayWarningSeverity,
                                             displayStyleSeverity,
                                             displayPerformanceSeverity,
                                             displayInformationSeverity,
                                             displayNoCategorySeverity,
                                             displayPortabilitySeverity))


job.save()
jenkins.model.Jenkins.instance.reload()
