package com.example.kursach

object RoomsRepository {
    fun getRooms() : List<Room> {
        return listOf(
            Room(0,R.drawable.a1, 3, "Практос"),
            Room(1,R.drawable.a2, 12, "Сёстры Надводнюк"),
            Room(2,R.drawable.a3, 3, "Название стрём"),
            Room(3,R.drawable.a4, 100, "Легущька")
        )
    }
}