package com.to_panelka.zine.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
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
    ).asContent {  }
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