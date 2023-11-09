package com.carlostorres.promassblog.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.data.repository.PostDataRepository
import com.carlostorres.promassblog.domain.listener.PostClickListener
import com.carlostorres.promassblog.utils.Event
import com.carlostorres.promassblog.utils.constants.emptyString
import com.carlostorres.promassblog.utils.resources.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PostDataRepository
): ViewModel(), PostClickListener {

    private val _postsList = MutableLiveData<DataStatus<List<PostEntity>>>()
    val postsList: LiveData<DataStatus<List<PostEntity>>> = _postsList
    private val _posts = MutableLiveData<List<PostEntity>>()
    val posts: LiveData<List<PostEntity>> = _posts
    private val _postClicked = MutableLiveData<Event<PostEntity>>()
    val postClicked: LiveData<Event<PostEntity>> = _postClicked

    val postName = MutableLiveData(emptyString())

    fun getAllPosts() = viewModelScope.launch {
        repository.getAllPost()
            .catch { _postsList.postValue(DataStatus.error(it.message.toString())) }
            .collect {
                _postsList.postValue(DataStatus.success(it, it.isEmpty()))
                _posts.postValue(it)
            }
    }

    fun onSearchPost() {
        val listTmp = mutableListOf<PostEntity>()

        if ( postName.value.isNullOrEmpty() ) {
            getAllPosts()
        } else {
            _postsList.value?.data!!.forEach {
                if ( it.title.toLowerCase().contains(postName.value!!.toLowerCase(Locale.ROOT)) ||
                    it.author.toLowerCase().contains(postName.value!!.toLowerCase(Locale.ROOT)) ||
                    it.overview.toLowerCase().contains(postName.value!!.toLowerCase(Locale.ROOT)) ) {
                    //_postsList.postValue(it)
                    //listTmp.postValue(DataStatus.success(listOf(it),false))
                    listTmp.add(it)
                }
            }
            _posts.postValue(listTmp)
        }
    }
    override fun onClick(item: PostEntity) {
        _postClicked.value = Event(item)
    }
}