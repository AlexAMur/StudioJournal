package ru.catshome.studiojournal.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.catshome.studiojournal.R

class GroupViewModal: ViewModel(){
    private val _nameGroup= MutableStateFlow("")
    val nameGroup: StateFlow<String> =_nameGroup.asStateFlow()
    fun onChange(nameGroup: String){
        _nameGroup.value = nameGroup
    }
    fun onSaveClick(){
        Log.e("AAA","Save",)

    }
    fun onCancelClick(){
        Log.e("AAA","Cancel")
    }

}

@Composable
fun newGroupScreen(groupViewModal: GroupViewModal = viewModel()) {
    val nameGroup by groupViewModal.nameGroup.collectAsState()

    addGroup(nameGroup =nameGroup ,
        onChange = {groupViewModal.onChange(it)},
        onSaveClick = {groupViewModal.onSaveClick()},
        onCancelClick = {groupViewModal.onCancelClick()}
    )

}

@Composable
fun listGroup(content: MutableList<String>){

    LazyColumn( modifier = Modifier
        .safeDrawingPadding()
        .padding(10.dp)
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .background(color = MaterialTheme.colorScheme.surface)){
            items(content){ model->
            listRow(model)
        }
    }
}
@Composable
fun listRow(model: String) {
    Text(text = model, modifier = Modifier.padding(10.dp), style = TextStyle())
}
@Composable
fun addGroup(nameGroup: String,
             onChange: (String)->Unit,
             onSaveClick:()->Unit,
             onCancelClick:()->Unit
    )
{
    val ls = mutableListOf<String>()
    repeat(40){
        ls.add("Items $it")
    }

    val  modifier = Modifier
        .safeDrawingPadding()
        .padding(24.dp)
        .fillMaxWidth()
    Card(modifier = Modifier
        .safeDrawingPadding()
        .fillMaxWidth(), colors = CardDefaults.cardColors()
    ) {
         Column(modifier = Modifier
             .padding(start = 24.dp, bottom = 24.dp)
             .fillMaxWidth()

         ) {
             listGroup(content = ls)
            OutlinedTextField(value = nameGroup,
                modifier =modifier,
                label = { Text(text  = stringResource(id = R.string.enter_group))},
                onValueChange = onChange)
            Row(modifier = Modifier
                .safeDrawingPadding()
                .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                customButton(label = stringResource(id = R.string.btn_save), modifier = modifier, onClick = onSaveClick)
                customButton(label = stringResource(id = R.string.btn_cancel), modifier = modifier, onClick = onCancelClick)

            }
        }


    }
}

