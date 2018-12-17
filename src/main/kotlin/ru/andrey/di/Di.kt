package ru.andrey.di

import com.google.inject.Guice
import kotlin.reflect.KClass

object Di {

    private val injector = Guice.createInjector(SearcherModule())!!

    operator fun <T : Any> get(type: KClass<T>) = injector.getInstance(type.java)!!
}
