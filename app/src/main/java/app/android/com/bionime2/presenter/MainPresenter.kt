package app.android.com.bionime2.presenter

import android.content.Context
import android.content.Intent
import app.android.com.bionime2.bean.DataBean
import app.android.com.bionime2.model.IMainModel
import app.android.com.bionime2.model.MainModel
import app.android.com.bionime2.view.IMainView
import java.util.*

/**
 * Created by laiguanyu on 2019/4/22.
 */
class MainPresenter(private val iMainView: IMainView, context: Context) : IMainPresenter {
    private val iMainModel: IMainModel

    init {
        iMainModel = MainModel(context)
        startTimer()
    }

    override fun setAllAQIRestore() {
        iMainModel.setAllAQIRestore()
        iMainView.notifyRecyclerView(iMainModel.getLocalAQIDatas()!!)
    }

    override fun setAQIDelete(id: Int) {
        iMainModel.setAQIDelete(id, 1)
        iMainView.notifyRecyclerView(iMainModel.getLocalAQIDatas()!!)
    }

    override fun getLocalSentence() {
        iMainView.setSentence(iMainModel.getLocalSentence())
    }

    override fun getLocalAQIDatas() {
        val datas = iMainModel.getLocalAQIDatas()
        if (datas == null) {
            iMainView.setAQIDatas(ArrayList<DataBean>())
        } else {
            iMainView.setAQIDatas(datas)
        }

    }

    override fun handleIntent(intent: Intent) {
        if (intent.getStringExtra("type") == "aqi") {
            iMainModel.setAQIDatas(intent.getSerializableExtra("datas") as ArrayList<DataBean>)
            iMainView.setAQIDatas(iMainModel.getLocalAQIDatas()!!)
        } else if (intent.getStringExtra("type") == "sentence") {
            iMainModel.setSentence(intent.getStringExtra("sentence"))
            iMainView.setSentence(iMainModel.getLocalSentence()!!)
        }
    }

    private fun startTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                iMainModel.getNetworkAQIData("http://opendata.epa.gov.tw/webapi/Data/REWIQA/?\$orderby=SiteName&\$skip=0&\$top=1000&format=json")
            }
        }, 0, (30 * 60 * 1000).toLong())
        Timer().schedule(object : TimerTask() {
            override fun run() {
                iMainModel.getNetworkSentence("https://tw.appledaily.com/index/dailyquote/")
            }
        }, 0, (12 * 60 * 60 * 1000).toLong())
    }

}
