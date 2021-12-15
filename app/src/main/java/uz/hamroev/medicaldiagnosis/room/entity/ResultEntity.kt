package uz.hamroev.medicaldiagnosis.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ResultEntity {

    @PrimaryKey(autoGenerate = true)  var id: Long? = null

    var date: String? = null
    var variant: String? = null
    var diagnos: String? = null
    var diagnos1: String? = null
    var diagnos2: String? = null
    var diagnos3: String? = null


}