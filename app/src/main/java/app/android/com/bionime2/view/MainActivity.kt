package app.android.com.bionime2.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import app.android.com.bionime2.R
import app.android.com.bionime2.adapter.MainAdapter
import app.android.com.bionime2.bean.DataBean
import app.android.com.bionime2.presenter.IMainPresenter
import app.android.com.bionime2.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView {

    private val TAG = "MainActivity"
    private var mainPresenter: IMainPresenter? = null
    private var mainAdapter: MainAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindData()
    }


    override fun onResume() {
        super.onResume()
        registerReceiver(mainReceiver, IntentFilter("app.android.com.bionime.broadcast"))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(mainReceiver)
    }

    var mainReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d(TAG, "onReceive: ")
            mainPresenter!!.handleIntent(intent)
        }
    }

    private fun bindData() {

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerView.setLayoutManager(llm)
        mainPresenter = MainPresenter(this, this)


        btn_restore.setOnClickListener(View.OnClickListener { mainPresenter!!.setAllAQIRestore() })

        mainPresenter!!.getLocalSentence()

        mainPresenter!!.getLocalAQIDatas()
    }

    override fun setSentence(sentence: String) {
        runOnUiThread { tv_sentence.setText(sentence) }
    }

    override fun setAQIDatas(datas: List<DataBean>) {
        mainAdapter = MainAdapter(datas, mainPresenter!!)
        recyclerView.setAdapter(mainAdapter)
    }

    override fun notifyRecyclerView(datas: List<DataBean>) {
        runOnUiThread {
            mainAdapter!!.setData(datas)
            mainAdapter!!.notifyDataSetChanged()
        }
    }
}
