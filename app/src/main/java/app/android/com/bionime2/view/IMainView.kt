package app.android.com.bionime2.view

import app.android.com.bionime2.bean.DataBean

/**
 * Created by laiguanyu on 2019/4/22.
 */
interface IMainView {
    fun setSentence(sentence: String)
    fun notifyRecyclerView(datas: List<DataBean>)
    fun setAQIDatas(datas: List<DataBean>)
}