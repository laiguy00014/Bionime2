package app.android.com.bionime2.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by laiguanyu on 2019/4/22.
 */
class DataBean : Serializable {


    /**
     * SiteName : 二林
     * County : 彰化縣
     * AQI : 97
     * Pollutant : 細懸浮微粒
     * Status : 普通
     * SO2 :
     * CO :
     * CO_8hr : 0.4
     * O3 :
     * O3_8hr : 24
     * PM10 : 72
     * PM2.5 : 39
     * NO2 :
     * NOx :
     * NO :
     * WindSpeed : 2.1
     * WindDirec : 347
     * PublishTime : 2019-04-18 10:00
     * PM2.5_AVG : 34
     * PM10_AVG : 85
     * SO2_AVG : 5
     * Longitude : 120.409653
     * Latitude : 23.925175
     */

    private var SiteName: String? = null
    private var County: String? = null
    private var AQI: String? = null
    private var Pollutant: String? = null
    private var Status: String? = null
    private var SO2: String? = null
    private var CO: String? = null
    private var CO_8hr: String? = null
    private var O3: String? = null
    private var O3_8hr: String? = null
    private var PM10: String? = null
    @SerializedName("PM2.5")
    private var `_$PM25313`: String? = null // FIXME check this code
    private var NO2: String? = null
    private var NOx: String? = null
    private var NO: String? = null
    private var WindSpeed: String? = null
    private var WindDirec: String? = null
    private var PublishTime: String? = null
    @SerializedName("PM2.5_AVG")
    private var `_$PM25_AVG294`: String? = null // FIXME check this code
    private var PM10_AVG: String? = null
    private var SO2_AVG: String? = null
    private var Longitude: String? = null
    private var Latitude: String? = null
    private var id: Int = 0
    private var is_delete: Int = 0

    fun getSiteName(): String? {
        return SiteName
    }

    fun setSiteName(SiteName: String) {
        this.SiteName = SiteName
    }

    fun getCounty(): String? {
        return County
    }

    fun setCounty(County: String) {
        this.County = County
    }

    fun getAQI(): String? {
        return AQI
    }

    fun setAQI(AQI: String) {
        this.AQI = AQI
    }

    fun getPollutant(): String? {
        return Pollutant
    }

    fun setPollutant(Pollutant: String) {
        this.Pollutant = Pollutant
    }

    fun getStatus(): String? {
        return Status
    }

    fun setStatus(Status: String) {
        this.Status = Status
    }

    fun getSO2(): String? {
        return SO2
    }

    fun setSO2(SO2: String) {
        this.SO2 = SO2
    }

    fun getCO(): String? {
        return CO
    }

    fun setCO(CO: String) {
        this.CO = CO
    }

    fun getCO_8hr(): String? {
        return CO_8hr
    }

    fun setCO_8hr(CO_8hr: String) {
        this.CO_8hr = CO_8hr
    }

    fun getO3(): String? {
        return O3
    }

    fun setO3(O3: String) {
        this.O3 = O3
    }

    fun getO3_8hr(): String? {
        return O3_8hr
    }

    fun setO3_8hr(O3_8hr: String) {
        this.O3_8hr = O3_8hr
    }

    fun getPM10(): String? {
        return PM10
    }

    fun setPM10(PM10: String) {
        this.PM10 = PM10
    }

    fun `get_$PM25313`(): String? {
        return `_$PM25313`
    }

    fun `set_$PM25313`(`_$PM25313`: String) {
        this.`_$PM25313` = `_$PM25313`
    }

    fun getNO2(): String? {
        return NO2
    }

    fun setNO2(NO2: String) {
        this.NO2 = NO2
    }

    fun getNOx(): String? {
        return NOx
    }

    fun setNOx(NOx: String) {
        this.NOx = NOx
    }

    fun getNO(): String? {
        return NO
    }

    fun setNO(NO: String) {
        this.NO = NO
    }

    fun getWindSpeed(): String? {
        return WindSpeed
    }

    fun setWindSpeed(WindSpeed: String) {
        this.WindSpeed = WindSpeed
    }

    fun getWindDirec(): String? {
        return WindDirec
    }

    fun setWindDirec(WindDirec: String) {
        this.WindDirec = WindDirec
    }

    fun getPublishTime(): String? {
        return PublishTime
    }

    fun setPublishTime(PublishTime: String) {
        this.PublishTime = PublishTime
    }

    fun `get_$PM25_AVG294`(): String? {
        return `_$PM25_AVG294`
    }

    fun `set_$PM25_AVG294`(`_$PM25_AVG294`: String) {
        this.`_$PM25_AVG294` = `_$PM25_AVG294`
    }

    fun getPM10_AVG(): String? {
        return PM10_AVG
    }

    fun setPM10_AVG(PM10_AVG: String) {
        this.PM10_AVG = PM10_AVG
    }

    fun getSO2_AVG(): String? {
        return SO2_AVG
    }

    fun setSO2_AVG(SO2_AVG: String) {
        this.SO2_AVG = SO2_AVG
    }

    fun getLongitude(): String? {
        return Longitude
    }

    fun setLongitude(Longitude: String) {
        this.Longitude = Longitude
    }

    fun getLatitude(): String? {
        return Latitude
    }

    fun setLatitude(Latitude: String) {
        this.Latitude = Latitude
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getIs_delete(): Int {
        return is_delete
    }

    fun setIs_delete(is_delete: Int) {
        this.is_delete = is_delete
    }
}