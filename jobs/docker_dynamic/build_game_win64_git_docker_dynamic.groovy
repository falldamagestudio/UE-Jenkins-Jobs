pipelineJob('docker_dynamic/build_game_win64_git_docker_dynamic') {

  displayName("Build Game - Win64 - Git - Docker - Dynamic VM")

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
      scriptPath('Jenkinsfiles/build_game_win64_git_docker_dynamic.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
