package com.carlostorres.promassblog.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.data.remote.FirebaseRepository
import com.carlostorres.promassblog.data.repository.PostDataRepository
import com.carlostorres.promassblog.domain.listener.AddPostListener
import com.carlostorres.promassblog.utils.constants.emptyString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: PostDataRepository,
    private val firebaseRepository: FirebaseRepository
): ViewModel() {

    var listener: AddPostListener?= null
    private var _title = emptyString()
    val title = MutableLiveData(emptyString())
    private var _author = emptyString()
    val author = MutableLiveData(emptyString())
    private var _overview = emptyString()
    val overview = MutableLiveData(emptyString())
    private val _status: MutableLiveData<Boolean> = MutableLiveData()

    fun onWatchTitle() {
        _title = if ( title.value.isNullOrEmpty() ) {
            emptyString()
        } else {
            title.value!!
        }
    }

    fun onWatchAuthor() {
        _author = if ( author.value.isNullOrEmpty() ) {
            emptyString()
        } else {
            author.value!!
        }
    }

    fun onWatchOverview() {
        _overview =  if (overview.value.isNullOrEmpty()) {
            emptyString()
        } else {
            overview.value!!
        }
    }

    fun saveData(position: Int) {
        if ( _title.isNotEmpty() && _author.isNotEmpty() && _overview.isNotEmpty() ) {
            onSavePost(PostEntity(0, _title, _author, _overview, System.currentTimeMillis()))
            savePostToFirestore(PostEntity(position, _title, _author, _overview, System.currentTimeMillis()))
            listener?.success()
        } else {
            listener?.onEmptyFields()
        }
    }

    private fun onSavePost(entity: PostEntity) = viewModelScope.launch {
        repository.insertpost(entity)
    }

    private fun savePostToFirestore(entity: PostEntity) {
        viewModelScope.launch {
            firebaseRepository.savePostToFirestore(entity)
                .onEach {
                    _status.value = it
                }.launchIn(viewModelScope)
        }
    }
}