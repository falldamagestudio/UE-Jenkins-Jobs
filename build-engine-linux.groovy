pipelineJob('build-engine-linux') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/Kalmalyzer/UE-Jenkins-Engine')
          }
          branch('*/master')
        }
      }
      lightweight()
    }
  }
