listView('5. Kubernetes') {

  columns {
    // Show status of latest build
    status()

    // Show job name
    name()

    // Show time elapsed since start of latest successful build
    lastSuccess()

    // Show time elapsed since start of latest failed build
    lastFailure()

    // Show duration of latest build
    lastDuration()

    // Show button for manually triggering a new build
    buildButton()
  }

  jobs {
    // Show only jobs whose names match the given regex
    regex(/k8s_.+/)
  }
}