package ru.catshome.studiojournal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
/*import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person*/
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.catshome.studiojournal.R

//@ExperimentalMaterial3Api
@Composable
//@Preview
fun addChild() {
    var nameChild by remember { mutableStateOf(TextFieldValue(""))}
    val modifier = Modifier
                      .padding(24.dp)
                      .fillMaxWidth()
                      .wrapContentHeight()
    Column(modifier = Modifier.safeDrawingPadding(),verticalArrangement = Arrangement.Top) {

        OutlinedTextField(value = nameChild,
            label = {Text(stringResource(R.string.enter_name))},
            onValueChange = {nameChild = it},
            modifier =modifier,
            leadingIcon ={Icon(imageVector = Icons.Default.Person,contentDescription = null)}
        )
        OutlinedTextField(value = nameChild,
            label = {Text(stringResource(R.string.enter_Fam))},
            onValueChange = {nameChild = it},
            modifier =modifier,
            leadingIcon ={Icon(imageVector = Icons.Default.Person,contentDescription = null)}
        )




            //---------------------------------------------
          /*  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // Pre-select a date for January 4, 2020
                val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
                DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

                Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
            }*/



            //-----------------------------------


           //customTextField(label = stringResource(R.string.enter_note), modifier)



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
@Composable
fun customButton(label: String,
                 modifier: Modifier,
                colors: ButtonColors =ButtonDefaults.buttonColors()
            )
{
    Button(onClick = { /*TODO*/ },
        colors = colors
    ) {
        Text(text = label)
        
    }
}