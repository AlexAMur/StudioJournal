package ru.catshome.studiojournal.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import ru.catshome.studiojournal.R
import ru.catshome.studiojournal.domain.models.Group
import ru.catshome.studiojournal.domain.usecase.LoadGroupUseCase
import ru.catshome.studiojournal.domain.usecase.SaveGroupUseCase
import javax.inject.Inject

@HiltViewModel
class GroupViewModal @Inject constructor(val  saveGroupUseCase: SaveGroupUseCase,
                                         val loadGroupUseCase: LoadGroupUseCase): ViewModel(){
    private var _listGroup = MutableStateFlow(listOf<Group>())
     var listGroup: StateFlow<List<Group>> =_listGroup

    private val _nameGroup= MutableStateFlow(Group(groupName = ""))
    val nameGroup: StateFlow<Group> =_nameGroup.asStateFlow()
    var uiState = mutableStateOf(false)
    init {
        loadList()
    }
    fun loadList(){
        viewModelScope.launch {
            loadGroupUseCase.loadAllGroup().collect{
                _listGroup.value = it
                Log.e("AAA","load list $it",)
            }
        }
    }
    fun onChange(nameGroup: String){
        _nameGroup.value= Group(_nameGroup.value.uid,nameGroup)
    }
    fun onSaveClick(){
        viewModelScope.launch { saveGroupUseCase.save(_nameGroup.value) }

        Log.e("AAA","Save",)

    }
    fun onCancelClick(){
        Log.e("AAA","Cancel")
    }

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun newGroupScreen(groupViewModal: GroupViewModal = viewModel()) {
    val group by groupViewModal.nameGroup.collectAsStateWithLifecycle()
    val listGroup by groupViewModal.listGroup.collectAsStateWithLifecycle()

    val modifier = Modifier
        //.safeDrawingPadding()
        .padding(24.dp)
        .fillMaxWidth()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                Text(text = "Add")
            }
        },
         floatingActionButtonPosition = FabPosition.End
    ) {
        Card(
            modifier = Modifier
                .safeDrawingPadding()
                .fillMaxWidth(), colors = CardDefaults.cardColors()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, bottom = 24.dp)
                    .fillMaxWidth()

            ) {


                if (groupViewModal.uiState.value) {
                    listGroup(
                        content = listGroup,
                        modifier = Modifier.fillMaxHeight(0.5f)
                            .safeDrawingPadding()
                            //.padding(24.dp)
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.surface),
                    )
                    addGroup(nameGroup = group.groupName ?: "",
                        modifier = modifier,
                        onChange = { groupViewModal.onChange(it) },
                        onSaveClick = { groupViewModal.onSaveClick() },
                        onCancelClick = { groupViewModal.onCancelClick() }
                    )
                } else {
                    listGroup(
                        content = listGroup, modifier = Modifier.fillMaxHeight(1f)
                            .safeDrawingPadding()
                            //.padding(24.dp)
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.surface)
                    )

                }

            }

        }
    }
}


@Composable
fun listGroup(content: List<Group>,  modifier: Modifier){

    LazyColumn( modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ){
            items(content){ model->
            listRow(model.groupName)
        }
    }
}
@Composable
fun listRow(model: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id =  R.drawable.ic_group_foreground),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(50.dp),
            contentDescription = "")
        Text(text = model, modifier = Modifier.padding(10.dp),
            fontSize =24.sp  //MaterialTheme.typography.bodyLarge
        )
    }
    
}
@Composable
fun addGroup(nameGroup: String,
             modifier: Modifier,
             onChange: (String)->Unit,
             onSaveClick:()->Unit,
             onCancelClick:()->Unit
    )
{
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

