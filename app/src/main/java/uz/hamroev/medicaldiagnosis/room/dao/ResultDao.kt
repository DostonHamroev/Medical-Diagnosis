package uz.hamroev.medicaldiagnosis.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.hamroev.medicaldiagnosis.room.entity.ResultEntity

@Dao
interface ResultDao {

    @Query("select * from resultentity")
    fun getAllResults(): List<ResultEntity>

    @Insert
    fun addResult(resultEntity: ResultEntity)

}