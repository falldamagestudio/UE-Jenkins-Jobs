pipelineJob('build_engine_linux') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/Kalmalyzer/UE-Jenkins-Engine')
            credentials('github-user')
          }
          branch('*/main')
          extensions {
            cloneOptions {
              // Perform shallow clone, so that Git will not download history of the project.
              shallow()
            }
            submoduleOptions {
              // Retrieves all submodules recursively.
              recursive()
            }
          }
        }
      }
      scriptPath('build_engine_linux.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
