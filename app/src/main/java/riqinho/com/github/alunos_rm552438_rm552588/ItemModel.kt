package riqinho.com.github.alunos_rm552438_rm552588

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val local: String,
    val evento: String,
    val impacto: String,
    val data: String,
    val qtd_pessoas : String
)