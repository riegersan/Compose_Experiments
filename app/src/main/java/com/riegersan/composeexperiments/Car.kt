package com.riegersan.composeexperiments

enum class Car(val value: String){
    AUDI("Audi"),
    VW("VW"),
    BMW("BWM"),
}

fun getAllCars(): List<Car>{
    return listOf(Car.AUDI, Car.VW, Car.BMW)
}

fun getCar(value: String): Car? {
    val map = Car.values().associateBy(Car::value)
    return map[value]
}
