pipelineJob('docker_static/build_game_linux_git_docker_static') {

  displayName("Build Game - Linux - Git - Docker - Static VM")

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
      scriptPath('Jenkinsfiles/build_game_linux_git_docker_static.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
