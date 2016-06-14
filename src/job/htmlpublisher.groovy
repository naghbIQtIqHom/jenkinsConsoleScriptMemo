// -*- coding:utf-8-unix -*-
import htmlpublisher.*

def name = "htmlpublisher"
def jenkins = jenkins.model.Jenkins.getInstance()
def job = new FreeStyleProject(jenkins, name);

def l = [new HtmlPublisherTarget("a", "b", "c.html", true, true, false), new HtmlPublisherTarget("", "", "", false, false, false)]

job.publishersList.add(new HtmlPublisher(l));

job.save()
jenkins.model.Jenkins.instance.reload()
