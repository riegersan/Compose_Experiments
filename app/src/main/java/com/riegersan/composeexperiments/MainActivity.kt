package com.riegersan.composeexperiments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.riegersan.composeexperiments.chipgroup.Car
import com.riegersan.composeexperiments.ui.theme.ComposeExperimentsTheme


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExperimentsTheme {
                DefaultPreview(
                    viewModel
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    viewModel: MainViewModelInterface = MainViewModel.composeViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            style = MaterialTheme.typography.body1,
            text = stringResource(R.string.chip_group_multi_selection)
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ChipGroupMultiSelection(
            cars = listOf(*Car.values()),
            selectedCars = viewModel.selectedCars.value,
            onSelectedChanged = { changedSelection ->
                val oldList: MutableList<Car?> = viewModel.selectedCars.value.toMutableList()
                val carFromString = Car.valueOf(changedSelection)

                if (oldList.contains(carFromString)) {
                    oldList.remove(carFromString)
                } else {
                    oldList.add(carFromString)
                }

                viewModel.selectedCars.value = oldList
            }
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Text(
            style = MaterialTheme.typography.body1,
            text = stringResource(R.string.chip_group_single_selection)
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ChipGroupSingleSelection(
            cars = listOf(*Car.values()),
            selectedCar = viewModel.selectedCar.value,
            onSelectedChanged = { changedSelection ->
                viewModel.selectedCar.value = Car.valueOf(changedSelection)
            }
        )
    }
}