// Choose a short name for this pipeline job
// The Kubernetes plugin will put the job's workspace at
// <agent workspace root>/workspace/<job name, including folders>
// and Windows requires that folder paths be less than 248 chars / file paths be less than 260 chars
pipelineJob('k8s/k8s_b_e_w64_git') {

  displayName("Kubernetes - Build Engine - Win64 - Git")

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
      scriptPath('Jenkinsfiles/kubernetes/kubernetes_build_engine_win64_git.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
