pipelineJob('docker_static_build_game_linux_git') {

  displayName("Docker - Static VM - Build Game - Linux - Git")

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
      scriptPath('Jenkinsfiles/docker_static/docker_static_build_game_linux_git.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
