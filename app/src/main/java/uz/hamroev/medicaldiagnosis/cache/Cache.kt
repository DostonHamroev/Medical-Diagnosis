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
        get() = sharedPreferences.getString("til1","ru")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("til1",value)
            }
        }



    var variant:String?
        get() = sharedPreferences.getString("variant1","0")
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putString("variant1",value)
            }
        }







    var a1:Int?
        get() = sharedPreferences.getInt("a11",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("a11",value)
            }
        }

    var a2:Int?
        get() = sharedPreferences.getInt("a22",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("a22",value)
            }
        }

    var b1:Int?
        get() = sharedPreferences.getInt("b11",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("b11",value)
            }
        }

    var b2:Int?
        get() = sharedPreferences.getInt("b22",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("b22",value)
            }
        }

    var b3:Int?
        get() = sharedPreferences.getInt("b33",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("b33",value)
            }
        }

    var c1:Int?
        get() = sharedPreferences.getInt("c11",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("c11",value)
            }
        }

    var c2:Int?
        get() = sharedPreferences.getInt("c22",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("c22",value)
            }
        }

    var d1:Int?
        get() = sharedPreferences.getInt("d11",0)
        set(value) = Cache.sharedPreferences.edit() {
            if (value != null){
                it.putInt("d11",value)
            }
        }
}