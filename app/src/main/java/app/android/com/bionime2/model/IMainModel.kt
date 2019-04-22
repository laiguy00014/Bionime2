package app.android.com.bionime2.model

import app.android.com.bionime2.bean.DataBean

/**
 * Created by laiguanyu on 2019/4/22.
 */
interface IMainModel {


    fun setAQIDatas(AQIData: List<DataBean>)

    fun setSentence(sentence: String)

    fun setAQIDelete(id: Int, is_delete: Int)

    fun setAllAQIRestore()

    fun getNetworkAQIData(url: String)

    fun getNetworkSentence(url: String)

    fun getLocalSentence(): String

    fun getLocalAQIDatas(): List<DataBean>?

}