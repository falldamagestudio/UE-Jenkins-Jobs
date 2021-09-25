listView('1. Docker - Dynamic VMs') {
  description("Docker - Dynamic VMs")

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
    regex(/docker_dynamic_.+/)
  }
}