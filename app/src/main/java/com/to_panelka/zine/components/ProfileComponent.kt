package com.to_panelka.zine.components

import androidx.lifecycle.ViewModel
import com.arkivanov.decompose.ComponentContext

class ProfileComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    val listSettings = mutableListOf("Создать расписание","Статистика","Настройки","Импортировать расписание","Экспортировать расписание")



}