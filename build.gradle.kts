import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

plugins {
  alias(libs.plugins.android) apply false
  alias(libs.plugins.kotlin) apply false
  alias(libs.plugins.versions)
  alias(libs.plugins.version.catalog.update)
}

versionCatalogUpdate {
  sortByKey.set(false)
  keep {
    keepUnusedVersions.set(true)
  }
}

tasks.withType<DependencyUpdatesTask> {
  rejectVersionIf {
    isStable(currentVersion) && !isStable(candidate.version)
  }
}

fun isStable(version: String): Boolean =
  Regex("(alpha|beta|rc)") !in version.toLowerCaseAsciiOnly()
