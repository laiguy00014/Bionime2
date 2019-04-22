package app.android.com.bionime2

import android.content.Context
import app.android.com.bionime2.bean.DataBean

/**
 * Created by laiguanyu on 2019/4/22.
 */
class LocalClient(private val context: Context) {

    fun getSentence(): String{
        return context.getSharedPreferences("sentence", Context.MODE_PRIVATE).getString("sentence", "")
    }


    fun getAQIDatas(): List<DataBean>?{
        return MySqlite.getInstance(context).getAllAQIDatasWithoutDelete(true)
    }

}