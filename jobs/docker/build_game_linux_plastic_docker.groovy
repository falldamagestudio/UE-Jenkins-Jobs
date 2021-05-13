pipelineJob('docker/build_game_linux_Plastic_docker') {

  displayName("Build Game - Linux - Plastic - Docker")

  properties {
    disableConcurrentBuilds()
  }

  definition {
    cpsScm {
      scm {
        plasticSCM {
          // Which repository & branch to check out
          // Reference: https://github.com/jenkinsci/plasticscm-plugin#selector-format
          selector('''repository "UE-Jenkins-Game@ue_jenkins_buildsystem@cloud"
                      path "/"
                      smartbranch "/main"''')

          // At start of checkout, undo any changed files in the workspace directory and then run a workspace update
          // Reference: https://github.com/jenkinsci/plasticscm-plugin#freestyle-projects
          cleanup('MINIMAL'

          // Perform single-workspace checkout
          useMultipleWorkspaces(false)

          // Place checkout result directly into Jenkins' workspace folder
          directory('')
        }
      }
      scriptPath('build_game_linux_plastic_docker.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
