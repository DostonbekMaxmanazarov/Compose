package com.example.paging3project.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.example.paging3project.datasource.local.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: IRepository
) : ViewModel() {
    val getAllImages = repository.getAllImages()
}