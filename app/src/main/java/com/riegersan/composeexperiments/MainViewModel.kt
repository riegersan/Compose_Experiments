package com.riegersan.composeexperiments

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riegersan.composeexperiments.chipgroup.Car

interface MainViewModelInterface {

    val selectedCar: MutableState<Car?>
    val selectedCars: MutableState<List<Car?>>
}


class MainViewModel: ViewModel(), MainViewModelInterface {

    companion object {

        val composeViewModel by lazy {
            object : MainViewModelInterface {
                override val selectedCar: MutableState<Car?> = mutableStateOf(Car.AUDI)
                override val selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf(*Car.values()))
            }
        }
    }

    override val selectedCar: MutableState<Car?> = mutableStateOf(null)
    override val selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf())
}