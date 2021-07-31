pipelineJob('static/build_game_win64_git_static') {

  displayName("Build Game - Win64 - Git - Static VM")

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
          branch('*/main')
        }
      }
      scriptPath('build_game_win64_git_static.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
