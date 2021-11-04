package com.riegersan.composeexperiments

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.riegersan.composeexperiments.chipgroup.Car

interface MainViewModelInterface {

    val selectedCar: MutableState<Car?>
    val selectedCars: MutableState<List<Car?>>
}

/**
 * View model for the main activity which holds all the states for main activity data.
 *
 * This view model contains an implementation of the interface for the Jetpack Compose preview.
 * More about this pattern can be found here @see
 * <a href="https://medium.com/@Rieger_san/jetpack-compose-with-more-complex-previews-live-previews-and-viewmodels-37eea588e6db">Complex Previews</a>
 */
class MainViewModel: ViewModel(), MainViewModelInterface {

    companion object {

        val composeViewModel by lazy {
            object : MainViewModelInterface {
                override val selectedCar: MutableState<Car?> = mutableStateOf(Car.AUDI)
                override val selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf(*Car.values()))
            }
        }
    }

    override val selectedCar: MutableState<Car?> = mutableStateOf(Car.AUDI)
    override val selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf(Car.VW))
}