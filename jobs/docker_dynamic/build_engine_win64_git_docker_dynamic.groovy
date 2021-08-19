pipelineJob('docker_dynamic/build_engine_win64_git_docker_dynamic') {

  displayName("Build Engine - Win64 - Git - Docker - Dynamic VM")

  properties {
    disableConcurrentBuilds()
  }

  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/falldamagestudio/UE-Jenkins-Engine')
            credentials('github-user')
          }
          branch('*/main')
          extensions {

            // We use submoduleOption rather than submoduleOptions, since submoduleOption offers more configurability
            // Specifically, shallow clonning (with depth = 1) requires using submoduleOption
            submoduleOption {
              // Use credentials from the default remote of the parent project
              parentCredentials(true)
              // Retrieves all submodules recursively.
              recursiveSubmodules(true)
              // Perform shallow clone, so that Git will not download history of the project.
              shallow(true)
              // Set shallow clone depth, so that git will only download recent history of the project,
              //  saving time and disk space when you just want to access the latest version of a repository.
              depth(1)

              // Keep submodule support enabled
              disableSubmodules(false)
              // Retrieve exact commit rather than tip of tracking branch in submodules
              trackingSubmodules(false)
              // No reference path
              reference('')
              // Initial clone of UE repo is allowed to take a long time - it's a large repo!
              timeout(60)
            }
          }
        }
      }
      scriptPath('Jenkinsfiles/build_engine_win64_git_docker_dynamic.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
