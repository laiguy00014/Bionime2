package app.android.com.bionime2.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.android.com.bionime2.R
import app.android.com.bionime2.bean.DataBean
import app.android.com.bionime2.presenter.IMainPresenter
import app.android.com.bionime2.view.IAQIItemView
import app.android.com.bionime2.viewHolder.MainViewHolder


/**
 * Created by laiguanyu on 2019/4/22.
 */
class MainAdapter(datas: List<DataBean>, mainPresenter: IMainPresenter) : RecyclerView.Adapter<MainViewHolder>(){

    private val mainPresenter: IMainPresenter
    private var datas: List<DataBean>

    init {
        this.mainPresenter = mainPresenter
        this.datas = datas
    }

    fun setData(datas: List<DataBean>) {
        this.datas = datas
    }


    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = datas[position]
        holder.setAllData(data)
        holder.setOnDeleteClick(View.OnClickListener { mainPresenter.setAQIDelete(data.getId()) })    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aqi, null))
    }
}