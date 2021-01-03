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
            submoduleOptions {
              // Use credentials from the default remote of the parent project
              parentCredentials(true)
              // Retrieves all submodules recursively.
              recursive(true)
              // Perform shallow clone, so that Git will not download history of the project.
              shallow(true)
              // Set shallow clone depth, so that git will only download recent history of the project,
              //  saving time and disk space when you just want to access the latest version of a repository.
              depth(1)
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
