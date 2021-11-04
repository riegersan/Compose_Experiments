package com.riegersan.composeexperiments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.riegersan.composeexperiments.chipgroup.Car
import com.riegersan.composeexperiments.ui.theme.ComposeExperimentsTheme


class MainActivity : ComponentActivity() {

    val selectedCar: MutableState<List<Car?>> = mutableStateOf(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExperimentsTheme {
                ChipGroup(
                    cars = listOf(*Car.values()),
                    selectedCars = selectedCar.value,
                    onSelectedChanged = {
                        val oldList: MutableList<Car?> = selectedCar.value.toMutableList()
                        val carFromString = Car.valueOf(it)

                        if(oldList.contains(carFromString)){
                            oldList.remove(carFromString)
                        }else{
                            oldList.add(carFromString)
                        }


                        selectedCar.value = oldList
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExperimentsTheme {
        Greeting("Android")
    }
}