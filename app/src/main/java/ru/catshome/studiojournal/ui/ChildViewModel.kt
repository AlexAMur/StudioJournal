package ru.catshome.studiojournal.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.catshome.studiojournal.domain.models.Child

//@HiltViewModel
class ChildViewModel(child: Child): ViewModel() {
private val _child: MutableLiveData<Child> = MutableLiveData(child)
    val child:LiveData<Child> =_child
}