package app.android.com.bionime2.presenter

import android.content.Intent

/**
 * Created by laiguanyu on 2019/4/22.
 */
interface IMainPresenter {

    abstract fun setAllAQIRestore()
    abstract fun setAQIDelete(id: Int)
    abstract fun getLocalSentence()
    abstract fun getLocalAQIDatas()
    abstract fun handleIntent(intent: Intent)

}