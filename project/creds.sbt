credentials += Credentials(
  "Artifactory Realm",
  "artifactory.prod.lifeway.com",
  "bethlehem-build",
  sys.env.getOrElse("ARTIFACTORY_LW_KEY", "bogus")
)