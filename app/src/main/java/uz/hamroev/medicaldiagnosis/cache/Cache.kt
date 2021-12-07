package uz.hamroev.medicaldiagnosis.cache

import android.content.Context
import android.content.SharedPreferences

object Cache {
    private const val NAME = "diagnostic"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var til:String?
        get() = sharedPreferences.getString("til","ru")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("til",value)
            }
        }

    var position:String?
        get() = sharedPreferences.getString("position","0")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("position",value)
            }
        }
}