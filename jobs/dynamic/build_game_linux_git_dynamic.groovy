pipelineJob('dynamic/build_game_linux_git_dynamic') {

  displayName("Build Game - Linux - Git - Dynamic VM")

  properties {
    disableConcurrentBuilds()
  }

  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/falldamagestudio/UE-Jenkins-Game')
            credentials('github-user')
          }
          branch('*/main')
        }
      }
      scriptPath('Jenkinsfiles/build_game_linux_git_dynamic.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
