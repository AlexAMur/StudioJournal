package ru.catshome.studiojournal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.catshome.studiojournal.R
import androidx.compose.material3.DatePicker
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.catshome.studiojournal.domain.models.Child
import javax.inject.Inject

@ExperimentalMaterial3Api
@Composable
fun newChildScreen(childViewModel: ChildViewModel = viewModel()){
    val child  by childViewModel.childState.collectAsStateWithLifecycle()
    newChildContent(Child())
    }
@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun newChildContent(child: Child ) {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)

    val modifier = Modifier
        .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        .fillMaxWidth()
        .wrapContentHeight()
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Top
    ) {

        OutlinedTextField(value = child.childName,
            label = { Text(stringResource(R.string.enter_name)) },
            onValueChange = { child.childName = it },
            modifier = modifier,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
        OutlinedTextField(value = child.childFam,
            label = { Text(stringResource(R.string.enter_Fam)) },
            onValueChange = { child.childFam = it },
            modifier = modifier,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
        Column(modifier = Modifier.padding(start = 24.dp, top = 0.dp)) {
            val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(state = state,
                title = null,
                headline ={
                       Text(stringResource(id = R.string.enter_brith),
                                fontSize = 16.sp)
                })
        }
        OutlinedTextField(value = child.note,
                    label = { Text(stringResource(R.string.enter_note)) },
                    onValueChange = { child.note = it },
                    modifier = modifier
                        .safeDrawingPadding()
                        .imePadding()
                        ,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.article_24),
                            contentDescription = null
                        )
                    }
                )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        customButton(
            label = stringResource(id = R.string.btn_save),
            modifier = modifier,
            onClick = {}
            //colors =
        )
        customButton(
            label = stringResource(id = R.string.btn_cancel),
            modifier = modifier,
            onClick = {}
            )


        }
    }
}

