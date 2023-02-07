pipelineJob('docker_static_build_game_linux_plastic') {

  displayName("Docker - Static VM - Build Game - Linux - Plastic")

  properties {
    disableConcurrentBuilds()
  }

  definition {
    cpsScm {
      scm {
        plasticSCM {

          // Rely on authentication configuration in client.conf
          workingMode('NONE')

          // No credentials provided, since we rely on client.conf settings instead
          credentialsId('')

          // Which repository & branch to check out
          // Reference: https://github.com/jenkinsci/plasticscm-plugin#selector-format
          selector('''repository "UE-Jenkins-Game@ue_jenkins_buildsystem@cloud"
                      path "/"
                      smartbranch "/main"''')

          // At start of checkout, undo any changed files in the workspace directory and then run a workspace update
          // Reference: https://github.com/jenkinsci/plasticscm-plugin#freestyle-projects
          cleanup('MINIMAL')

          // Perform single-workspace checkout
          useMultipleWorkspaces(false)

          // Place checkout result directly into Jenkins' workspace folder
          directory('')

          // Perform polling operations on the controller, not on the agent used for the latest build
          pollOnController(true)
        }
      }
      scriptPath('Jenkinsfiles/docker_static/docker_static_build_game_linux_plastic.groovy')
      // Obtain the Pipeline script contents directly from the SCM without performing a full checkout.
      lightweight()
    }
  }
}
