# Jenkins build job descriptions

This repository contains build job definitions for each of the build jobs associated with [UE-Jenkins-BuildSystem](https://github.com/falldamagestudio/UE-Jenkins-BuildSystem). Whenever someone runs the Seed job in that repository, these job definitions will be processed, and the corresponding job definitions in Jenkins get updated.

The job definitions are written in the [Job DSL](https://plugins.jenkins.io/job-dsl/) language. See [the Job DSL wiki](https://github.com/jenkinsci/job-dsl-plugin/wiki) for more information. There is [an API viewer](https://jenkinsci.github.io/job-dsl-plugin/) if you are looking for details on what functions are available - for best results, view the API directly within your own server.