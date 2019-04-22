package app.android.com.bionime2.model

import android.content.Context
import app.android.com.bionime2.LocalClient
import app.android.com.bionime2.MySqlite
import app.android.com.bionime2.NetworkClient
import app.android.com.bionime2.bean.DataBean

/**
 * Created by laiguanyu on 2019/4/22.
 */
class MainModel(context: Context) : IMainModel {
    private val networkClient: NetworkClient
    private val localClient: LocalClient
    private var isLocalAQIDataNull = false
    private val context: Context


    init {
        networkClient = NetworkClient(context)
        localClient = LocalClient(context)
        isLocalAQIDataNull = (localClient.getAQIDatas() == null)
        this.context = context
    }

    override fun setAQIDatas(datas: List<DataBean>) {
        val mySqlite = MySqlite.getInstance(context)
        if (isLocalAQIDataNull) {
            mySqlite.insertAllAQIDatas(datas)
            isLocalAQIDataNull = false
        } else {
            mySqlite.updateAllAQIDatas(datas)
        }
    }

    override fun setSentence(sentence: String) {
        context.getSharedPreferences("sentence", Context.MODE_PRIVATE).edit().putString("sentence", sentence).commit()
    }

    override fun getNetworkAQIData(url: String) {
        networkClient.getAQIData(url)
    }

    override fun getNetworkSentence(url: String) {
        networkClient.getSentence(url)
    }

    override fun setAQIDelete(id: Int, is_delete: Int) {
        MySqlite.getInstance(context).updateIsDelete(id, 1)
    }

    override fun setAllAQIRestore() {
        MySqlite.getInstance(context).restoreIsDelete()
    }

    override fun getLocalSentence(): String{
        return localClient.getSentence()
    }

    override fun getLocalAQIDatas(): List<DataBean>?{
        return localClient.getAQIDatas()
    }

}
