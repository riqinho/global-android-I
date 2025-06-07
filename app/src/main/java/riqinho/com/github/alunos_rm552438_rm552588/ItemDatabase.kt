package riqinho.com.github.alunos_rm552438_rm552588

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemModel::class], version = 2)
abstract class ItemDatabase : RoomDatabase(){
    abstract fun itemDao(): ItemDao
}