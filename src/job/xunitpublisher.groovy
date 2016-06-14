// -*- coding:utf-8-unix -*-

import org.jenkinsci.plugins.xunit.*
import org.jenkinsci.plugins.xunit.types.*
import org.jenkinsci.plugins.xunit.threshold.*
import org.jenkinsci.lib.dtkit.type.TestType

def name = "xunitpublisher"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def types = [new JUnitType("**/junit.xml", false, true, true, true),
	     new NUnitJunitHudsonTestType("**/nunit.xml", false, true, true, true),
	     new BoostTestJunitHudsonTestType("**/boosttest.xml", false, true, true, true),
	     new MSTestJunitHudsonTestType("**/mstest.xml", false, true, true, true),
	     new GoogleTestType("**/googletest.xml", false, true, true, true)]
def thresholds = [new FailedThreshold("", "", "", ""),
		  new SkippedThreshold("", "", "", "")]
def publisher = new XUnitPublisher((TestType[])types, (XUnitThreshold[])thresholds)
job.publishersList.add(publisher)

job.save()
jenkins.model.Jenkins.instance.reload()
