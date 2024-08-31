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
//    versionCatalogs {
//        create("libs") {
//            from(files("./gradle/libs.versions.toml.todo"))
//        }
//    }
}

rootProject.name = "WalmartTakeHome"

include(":app")
include(":feature-data")
include(":feature-domain")
include(":network-data")
include(":feature-ui")
include(":analytics")
