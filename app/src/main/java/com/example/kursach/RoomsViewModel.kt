package com.example.kursach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RoomsViewModel : ViewModel() {
    val roomsList = MutableLiveData<List<Room>>()
    private val roomsRepository = RoomsRepository
    init {
        roomsList.value = roomsRepository.getRooms()
    }
}