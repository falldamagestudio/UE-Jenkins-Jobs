
// Choose a short name for this folder
// There will be Windows pipeline jobs within this folder
// The Kubernetes plugin will put those jobs' workspaces at
// <agent workspace root>/workspace/<job name, including folders>
// and Windows requires that folder paths be less than 248 chars / file paths be less than 260 chars
folder("k8s") {

    displayName("Kubernetes")
}
