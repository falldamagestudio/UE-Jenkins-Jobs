pipelineJob('docker_static_build_game_win64_git') {

  displayName("Docker - Static VM - Build Game - Win64 - Git")

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
      scriptPath('Jenkinsfiles/docker_static/docker_static_build_game_win64_git.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
