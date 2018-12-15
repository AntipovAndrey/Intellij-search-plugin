package ru.andrey.di

import com.google.inject.Guice
import com.google.inject.Injector

object Di : Injector by Guice.createInjector(SearcherModule())!!
