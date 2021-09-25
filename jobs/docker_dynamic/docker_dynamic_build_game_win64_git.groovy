pipelineJob('docker_dynamic_build_game_win64_git') {

  displayName("Docker - Dynamic VM - Build Game - Win64 - Git")

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
      scriptPath('Jenkinsfiles/docker_dynamic/docker_dynamic_build_game_win64_git.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
