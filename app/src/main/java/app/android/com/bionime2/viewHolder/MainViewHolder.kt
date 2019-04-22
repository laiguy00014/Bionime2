package app.android.com.bionime2.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import app.android.com.bionime2.R
import app.android.com.bionime2.bean.DataBean
import app.android.com.bionime2.view.IAQIItemView

/**
 * Created by laiguanyu on 2019/4/22.
 */
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), IAQIItemView{

    private val tv_site_name: TextView
    private val tv_country: TextView
    private var tv_aqi:TextView
    private var tv_pollutant:TextView
    private var tv_status:TextView
    private var tv_so2:TextView
    private var tv_co:TextView
    private var tv_co_8hr: TextView
    private var tv_o3:TextView
    private var tv_o3_8hr:TextView
    private var tv_pm10:TextView
    private var tv_pm25:TextView
    private var tv_no2:TextView
    private var tv_nox:TextView
    private var tv_no:TextView

    private var tv_wind_speed: TextView
    private var tv_wind_direc:TextView
    private var tv_publish_time:TextView
    private var tv_pm25_avg:TextView
    private var tv_pm10_avg:TextView

    private var tv_so2_avg: TextView
    private var tv_longitude:TextView
    private var tv_latitude:TextView

    private var btn_delete: Button

    init {
        tv_site_name = itemView.findViewById<TextView>(R.id.tv_site_name)
        tv_country = itemView.findViewById(R.id.tv_country)
        tv_aqi = itemView.findViewById(R.id.tv_aqi)
        tv_pollutant = itemView.findViewById(R.id.tv_pollutant)
        tv_status = itemView.findViewById(R.id.tv_status)
        tv_so2 = itemView.findViewById(R.id.tv_so2)
        tv_co = itemView.findViewById(R.id.tv_co)
        tv_co_8hr = itemView.findViewById(R.id.tv_co_8hr)
        tv_o3 = itemView.findViewById(R.id.tv_o3)
        tv_o3_8hr = itemView.findViewById(R.id.tv_o3_8hr)
        tv_pm10 = itemView.findViewById(R.id.tv_pm10)
        tv_pm25 = itemView.findViewById(R.id.tv_pm25)
        tv_no2 = itemView.findViewById(R.id.tv_no2)
        tv_nox = itemView.findViewById(R.id.tv_nox)
        tv_no = itemView.findViewById(R.id.tv_no)
        tv_wind_speed = itemView.findViewById(R.id.tv_wind_speed)
        tv_wind_direc = itemView.findViewById(R.id.tv_wind_direc)
        tv_publish_time = itemView.findViewById(R.id.tv_publish_time)
        tv_pm25_avg = itemView.findViewById(R.id.tv_pm25_avg)
        tv_pm10_avg = itemView.findViewById(R.id.tv_pm10_avg)
        tv_so2_avg = itemView.findViewById(R.id.tv_so2_avg)
        tv_longitude = itemView.findViewById(R.id.tv_longitude)
        tv_latitude = itemView.findViewById(R.id.tv_latitude)
        btn_delete = itemView.findViewById(R.id.btn_delete)
    }

    override fun setAllData(dataBean: DataBean) {
        setSiteName(dataBean.getSiteName()!!)
        setCounty(dataBean.getCounty()!!)
        setAQI(dataBean.getAQI()!!)
        setPollutant(dataBean.getPollutant()!!)
        setStatus(dataBean.getStatus()!!)
        setSO2(dataBean.getSO2()!!)
        setCO(dataBean.getCO()!!)
        setCO_8hr(dataBean.getCO_8hr()!!)
        setO3(dataBean.getO3()!!)
        setO3_8hr(dataBean.getO3_8hr()!!)
        setPM10(dataBean.getPM10()!!)
        setPM25(dataBean.`get_$PM25313`()!!)
        setNO2(dataBean.getNO2()!!)
        setNOx(dataBean.getNOx()!!)
        setNO(dataBean.getNO()!!)
        setWindSpeed(dataBean.getWindSpeed()!!)
        setWindDirec(dataBean.getWindDirec()!!)
        setPublishTime(dataBean.getPublishTime()!!)
        setPM25_AVG(dataBean.`get_$PM25_AVG294`()!!)
        setPM10_AVG(dataBean.getPM10_AVG()!!)
        setSO2_AVG(dataBean.getSO2_AVG()!!)
        setLongitude(dataBean.getLongitude()!!)
        setLatitude(dataBean.getLatitude()!!)
    }

    override fun setSiteName(SiteName: String) {
        tv_site_name.text = SiteName
    }

    override fun setCounty(County: String) {
        tv_country.setText(County)
    }

    override fun setAQI(AQI: String) {
        tv_aqi.setText(AQI)
    }

    override fun setPollutant(Pollutant: String) {
        tv_pollutant.setText(Pollutant)
    }

    override fun setStatus(Status: String) {
        tv_status.setText(Status)
    }

    override fun setSO2(SO2: String) {
        tv_so2.setText(SO2)
    }

    override fun setCO(CO: String) {
        tv_co.setText(CO)
    }

    override fun setCO_8hr(CO_8hr: String) {
        tv_co_8hr.text = CO_8hr
    }

    override fun setO3(O3: String) {
        tv_o3.setText(O3)
    }

    override fun setO3_8hr(O3_8hr: String) {
        tv_o3_8hr.setText(O3_8hr)
    }

    override fun setPM10(PM10: String) {
        tv_pm10.setText(PM10)
    }

    override fun setPM25(PM25: String) {
        tv_pm25.setText(PM25)
    }

    override fun setNO2(NO2: String) {
        tv_no2.setText(NO2)
    }

    override fun setNOx(NOx: String) {
        tv_nox.setText(NOx)
    }

    override fun setNO(NO: String) {
        tv_no.setText(NO)
    }

    override fun setWindSpeed(WindSpeed: String) {
        tv_wind_speed.text = WindSpeed
    }

    override fun setWindDirec(WindDirec: String) {
        tv_wind_direc.setText(WindDirec)
    }

    override fun setPublishTime(PublishTime: String) {
        tv_publish_time.setText(PublishTime)
    }

    override fun setPM25_AVG(PM25_AVG: String) {
        tv_pm25_avg.setText(PM25_AVG)
    }

    override fun setPM10_AVG(PM10_AVG: String) {
        tv_pm10_avg.setText(PM10_AVG)
    }

    override fun setSO2_AVG(SO2_AVG: String) {
        tv_so2_avg.text = SO2_AVG
    }

    override fun setLongitude(Longitude: String) {
        tv_longitude.setText(Longitude)
    }

    override fun setLatitude(Latitude: String) {
        tv_latitude.setText(Latitude)
    }

    override fun setOnDeleteClick(onDeleteClick: View.OnClickListener) {
        btn_delete.setOnClickListener(onDeleteClick)
    }

}