package ru.catshome.studiojournal.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.usecase.LoadChildUseCase
import ru.catshome.studiojournal.domain.usecase.SaveChildUseCase
import javax.inject.Inject

@HiltViewModel
class ChildViewModel @Inject constructor(val saveChild: SaveChildUseCase, private val loadChild: LoadChildUseCase) : ViewModel() {
private val _child = MutableStateFlow(listOf( Child()))
    val childState :StateFlow<List<Child>> =_child
    init{
        viewModelScope.launch {
            loadChild.loadAllChilds().collect{
                _child.value =it
            }
        }

    }

}