package com.to_panelka.zine.components

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.bringToFront
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.to_panelka.zine.ui.Screens
import com.to_panelka.zine.ui.composable.profile.ProfileUI
import com.to_panelka.zine.util.Content
import com.to_panelka.zine.util.asContent

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {

    private val router = router<RootConfiguration, Content>(
        initialConfiguration = RootConfiguration.Schedule,
        childFactory = ::createChild
    )
    val routerState = router.state
    val screens = Screens.values().toList()
    val currentScreen = mutableStateOf("Schedule")

    fun onClickBar(name: String) {
        currentScreen.value = name
        when (name) {
            "Profile" -> {
                router.bringToFront(RootConfiguration.Profile)
            }
            "Students" -> {
                router.bringToFront(RootConfiguration.Students)
            }
            "Schedule" -> {
                router.bringToFront(RootConfiguration.Schedule)
            }
        }
    }


    private fun createChild(configuration: RootConfiguration, context: ComponentContext): Content =
        when (configuration) {
            is RootConfiguration.Profile -> profile()
            is RootConfiguration.Schedule -> schedule()
            is RootConfiguration.Students -> students()
        }


    private fun profile(): Content = ProfileComponent(
        componentContext = childContext(
            key = "Profile",
            lifecycle = LifecycleRegistry()
        )
    ).asContent {  ProfileUI(component = it)}
    private fun schedule(): Content = ScheduleComponent(
        componentContext = childContext(
            key = "Schedule",
            lifecycle = LifecycleRegistry()
        )
    ).asContent { }
    private fun students(): Content = StudentsComponent(
        componentContext = childContext(
            key = "Students",
            lifecycle = LifecycleRegistry()
        )
    ).asContent { }


    sealed class RootConfiguration : Parcelable {

        @Parcelize
        object Profile: RootConfiguration()

        @Parcelize
        object Schedule : RootConfiguration()

        @Parcelize
        object Students : RootConfiguration()
    }
}