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
import ru.catshome.studiojournal.domain.models.Child
import javax.inject.Inject

//@ExperimentalMaterial3Api
//@Composable
fun newChildScreen(vm:ChildViewModel){
    //var child: Child by vm.child.observe(Child(uid = -1, brith = 1578096000000, childName = ""))
    //newChildContent(child)
    }
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun newChildContent(child: Child = Child(uid = -1, brith = 1578096000000, childName = "")) {
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

        OutlinedTextField(value = nameChild,
            label = { Text(stringResource(R.string.enter_name)) },
            onValueChange = { nameChild = it },
            modifier = modifier,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
        OutlinedTextField(value = nameChild,
            label = { Text(stringResource(R.string.enter_Fam)) },
            onValueChange = { nameChild = it },
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
        OutlinedTextField(value = nameChild,
                    label = { Text(stringResource(R.string.enter_note)) },
                    onValueChange = { nameChild = it },
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
            //colors =
        )
        customButton(
            label = stringResource(id = R.string.btn_cancel),
            modifier = modifier,

            )


        }
    }
}

*/