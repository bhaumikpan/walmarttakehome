pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WalmartTakeHome"

include(":app")
include(":network-data")
include(":feature-data")
include(":feature-domain")
include(":feature-ui")
include(":analytics")
