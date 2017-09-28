FROM jenkins:alpine

USER root 
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
 
COPY default-sgs-user.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy

COPY default-sgs-plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

#COPY nexus-jenkins-plugin-1.1.0-05.hpi $JENKINS_HOME/plugins/nexus-jenkins-plugin-1.1.0-05.hpi 

COPY hudson.util.Secret $JENKINS_HOME/secrets/hudson.util.Secret
COPY master.key $JENKINS_HOME/secrets/master.key
