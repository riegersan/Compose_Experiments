package com.riegersan.composeexperiments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.riegersan.composeexperiments.chipgroup.Car
import com.riegersan.composeexperiments.ui.theme.ComposeExperimentsTheme


class MainActivity : ComponentActivity() {

    val selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf())
    val selectedCar: MutableState<Car?> = mutableStateOf(Car.AUDI)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExperimentsTheme {
                DefaultPreview(
                    selectedCar = selectedCar,
                    selectedCars = selectedCars
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    selectedCar: MutableState<Car?> = mutableStateOf(Car.AUDI),
    selectedCars: MutableState<List<Car?>> = mutableStateOf(listOf(*Car.values()))
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            style = MaterialTheme.typography.body1,
            text = "ChipGroup Multiple Selection"
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ChipGroupMultiSelection(
            cars = listOf(*Car.values()),
            selectedCars = selectedCars.value,
            onSelectedChanged = { changedSelection ->
                val oldList: MutableList<Car?> = selectedCars.value.toMutableList()
                val carFromString = Car.valueOf(changedSelection)

                if (oldList.contains(carFromString)) {
                    oldList.remove(carFromString)
                } else {
                    oldList.add(carFromString)
                }

                selectedCars.value = oldList
            }
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Text(
            style = MaterialTheme.typography.body1,
            text = "ChipGroup Single Selection"
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ChipGroupSingleSelection(
            cars = listOf(*Car.values()),
            selectedCar = Car.AUDI,
            onSelectedChanged = { changedSelection ->
                selectedCar.value = Car.valueOf(changedSelection)
            }
        )
    }
}