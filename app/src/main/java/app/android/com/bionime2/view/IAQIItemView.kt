package app.android.com.bionime2.view

import android.view.View
import app.android.com.bionime2.bean.DataBean

/**
 * Created by laiguanyu on 2019/4/22.
 */
interface IAQIItemView {

    abstract fun setAllData(dataBean: DataBean)

    abstract fun setSiteName(SiteName: String)

    abstract fun setCounty(County: String)

    abstract fun setAQI(AQI: String)

    abstract fun setPollutant(Pollutant: String)

    abstract fun setStatus(Status: String)

    abstract fun setSO2(SO2: String)

    abstract fun setCO(CO: String)

    abstract fun setCO_8hr(CO_8hr: String)

    abstract fun setO3(O3: String)

    abstract fun setO3_8hr(O3_8hr: String)

    abstract fun setPM10(PM10: String)

    abstract fun setPM25(PM25: String)

    abstract fun setNO2(NO2: String)

    abstract fun setNOx(NOx: String)

    abstract fun setNO(NO: String)

    abstract fun setWindSpeed(WindSpeed: String)

    abstract fun setWindDirec(WindDirec: String)

    abstract fun setPublishTime(PublishTime: String)

    abstract fun setPM25_AVG(PM25_AVG: String)

    abstract fun setPM10_AVG(PM10_AVG: String)

    abstract fun setSO2_AVG(SO2_AVG: String)

    abstract fun setLongitude(Longitude: String)

    abstract fun setLatitude(Latitude: String)

    abstract fun setOnDeleteClick(onDeleteClick: View.OnClickListener)

}