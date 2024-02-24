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

rootProject.name = "Template_Jetpack_Compose_CleanArchitecture_MultiModule_MVI_SqlDelight_CRUD_Voyager_Koin"
include(":app")
include(":data")
include(":domain")
