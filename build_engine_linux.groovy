pipelineJob('build_engine_linux') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/Kalmalyzer/UE-Jenkins-Engine')
            credentials('github-user')
          }
          branch('*/main')
        }
      }
      lightweight()
    }
  }
}
