plugins {
  alias(libs.plugins.android) apply false
  alias(libs.plugins.kotlin) apply false
  alias(libs.plugins.versions)
  alias(libs.plugins.version.catalog.update)
}

versionCatalogUpdate {
  sortByKey.set(false)
}
