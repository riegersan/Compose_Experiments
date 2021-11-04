package com.riegersan.composeexperiments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.riegersan.composeexperiments.chipgroup.Car

@Preview(showBackground = true)
@Composable
fun ChipGroupMultiSelection(
    modifier: Modifier = Modifier,
    cars: List<Car> = listOf(*Car.values()),
    selectedCars: List<Car?> = listOf(),
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        LazyRow {
            items(cars) { item ->
                Chip(
                    name = item.value,
                    isSelected = selectedCars.contains(item),
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroupSingleSelection(
    modifier: Modifier = Modifier,
    cars: List<Car> = listOf(*Car.values()),
    selectedCar: Car? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        LazyRow {
            items(cars) { item ->
                Chip(
                    name = item.value,
                    isSelected = selectedCar == item,
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                )
            }
        }
    }
}