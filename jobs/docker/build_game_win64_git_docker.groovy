pipelineJob('docker/build_game_win64_git_docker') {

  displayName("Build Game - Win64 - Git - Docker")

  properties {
    disableConcurrentBuilds()
  }

  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/Kalmalyzer/UE-Jenkins-Game')
            credentials('github-user')
          }
          branch('*/agent-vms')
        }
      }
      scriptPath('build_game_win64_git_docker.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
