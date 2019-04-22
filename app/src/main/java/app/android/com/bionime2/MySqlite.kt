package app.android.com.bionime2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import app.android.com.bionime2.bean.DataBean
import java.util.ArrayList

/**
 * Created by laiguanyu on 2019/4/22.
 */
class MySqlite private constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    private val DB_NAME = "MainDB.db"
    private val DB_VERSION = 1
    private val DB_TABLE_MAIN = "MainTable"
    private var instance: MySqlite? = null
    private val ID = "_id"
    private val SITE_NAME = "site_name"
    private val COUNTRY = "country"
    private val AQI = "aqi"
    private val POLLUTANT = "pollutant"
    private val STATUS = "status"
    private val SO2 = "so2"
    private val CO = "co"
    private val CO_8HR = "co_8hr"
    private val O3 = "o3"
    private val O3_8HR = "o3_8hr"
    private val PM10 = "pm10"
    private val PM25 = "pm25"
    private val NO2 = "no2"
    private val NOX = "nox"
    private val NO = "no"
    private val WIND_SPEED = "wind_speed"
    private val WIND_DIREC = "wind_direc"
    private val PUBLISH_TIME = "publish_time"
    private val PM25_AVG = "pm25_avg"
    private val PM10_AVG = "pm10_avg"
    private val SO2_AVG = "so2_avg"
    private val LONGITUDE = "longitude"
    private val LATITUDE = "latitude"
    private val IS_DELETE = "is_delete"

    private var cursor: Cursor? = null
    companion object {
        private var instance: MySqlite? = null
        private val DB_NAME = "UserDB.db"
        @Synchronized
        fun getInstance(ctx: Context): MySqlite {
            if (instance == null) {
                instance = MySqlite(ctx, DB_NAME, null, 5)
            }
            return instance!!
        }
    }

    override fun onCreate(p0: SQLiteDatabase) {

        val sqlStr = ("CREATE TABLE IF NOT EXISTS " + DB_TABLE_MAIN
                + " (  " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SITE_NAME + " TEXT NOT NULL, "
                + COUNTRY + " TEXT NOT NULL, "
                + AQI + " TEXT NOT NULL, "
                + POLLUTANT + " TEXT NOT NULL, "
                + STATUS + " TEXT NOT NULL, "
                + SO2 + " TEXT NOT NULL, "
                + CO + " TEXT NOT NULL, "
                + CO_8HR + " TEXT NOT NULL, "
                + O3 + " TEXT NOT NULL, "
                + O3_8HR + " TEXT NOT NULL, "
                + PM10 + " TEXT NOT NULL, "
                + PM25 + " TEXT NOT NULL, "
                + NO2 + " TEXT NOT NULL, "
                + NOX + " TEXT NOT NULL, "
                + NO + " TEXT NOT NULL, "
                + WIND_SPEED + " TEXT NOT NULL, "
                + WIND_DIREC + " TEXT NOT NULL, "
                + PUBLISH_TIME + " TEXT NOT NULL, "
                + PM25_AVG + " TEXT NOT NULL, "
                + PM10_AVG + " TEXT NOT NULL, "
                + SO2_AVG + " TEXT NOT NULL, "
                + LONGITUDE + " TEXT NOT NULL, "
                + LATITUDE + " TEXT NOT NULL, "
                + IS_DELETE + " INTEGER NOT NULL "
                + ");")

        p0.execSQL(sqlStr)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


    fun getAllAQIDatasWithoutDelete(isWithoutDelete: Boolean): List<DataBean>? {
        val list = ArrayList<DataBean>()
        val db = this.readableDatabase
        cursor = db.query(DB_TABLE_MAIN, null, null, null, null, null, null)
        cursor!!.moveToFirst()
        if (cursor!!.getCount() == 0) {
            return null
        }
        do {
            val dataBean = formateDataBean(cursor!!)
            if (isWithoutDelete) {
                if (dataBean.getIs_delete() === 0) {
                    list.add(formateDataBean(cursor!!))
                }
            } else {
                list.add(formateDataBean(cursor!!))
            }
        } while (cursor!!.moveToNext())

        return list
    }

    fun formateDataBean(cursor: Cursor): DataBean {
        val dataBean = DataBean()
        dataBean.setId(cursor.getInt(cursor.getColumnIndex(ID)))
        dataBean.setSiteName(cursor.getString(cursor.getColumnIndex(SITE_NAME)))
        dataBean.setCounty(cursor.getString(cursor.getColumnIndex(COUNTRY)))
        dataBean.setAQI(cursor.getString(cursor.getColumnIndex(AQI)))
        dataBean.setPollutant(cursor.getString(cursor.getColumnIndex(POLLUTANT)))
        dataBean.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)))
        dataBean.setSO2(cursor.getString(cursor.getColumnIndex(SO2)))
        dataBean.setCO(cursor.getString(cursor.getColumnIndex(CO)))
        dataBean.setCO_8hr(cursor.getString(cursor.getColumnIndex(CO_8HR)))
        dataBean.setO3(cursor.getString(cursor.getColumnIndex(O3)))
        dataBean.setO3_8hr(cursor.getString(cursor.getColumnIndex(O3_8HR)))
        dataBean.setPM10(cursor.getString(cursor.getColumnIndex(PM10)))
        dataBean.`set_$PM25313`(cursor.getString(cursor.getColumnIndex(PM25)))
        dataBean.setNO2(cursor.getString(cursor.getColumnIndex(NO2)))
        dataBean.setNOx(cursor.getString(cursor.getColumnIndex(NOX)))
        dataBean.setNO(cursor.getString(cursor.getColumnIndex(NO)))
        dataBean.setWindSpeed(cursor.getString(cursor.getColumnIndex(WIND_SPEED)))
        dataBean.setWindDirec(cursor.getString(cursor.getColumnIndex(WIND_DIREC)))
        dataBean.setPublishTime(cursor.getString(cursor.getColumnIndex(PUBLISH_TIME)))
        dataBean.`set_$PM25_AVG294`(cursor.getString(cursor.getColumnIndex(PM25_AVG)))
        dataBean.setPM10_AVG(cursor.getString(cursor.getColumnIndex(PM10_AVG)))
        dataBean.setSO2_AVG(cursor.getString(cursor.getColumnIndex(SO2_AVG)))
        dataBean.setLongitude(cursor.getString(cursor.getColumnIndex(LONGITUDE)))
        dataBean.setLatitude(cursor.getString(cursor.getColumnIndex(LATITUDE)))
        dataBean.setIs_delete(cursor.getInt(cursor.getColumnIndex(IS_DELETE)))
        return dataBean
    }

    fun insertAllAQIDatas(datas: List<DataBean>) {

        val db = this.writableDatabase

        db.delete(DB_TABLE_MAIN, null, null)

        for (i in datas.indices) {
            val cv = ContentValues()
            cv.put(ID, i)
            cv.put(SITE_NAME, datas[i].getSiteName())
            cv.put(COUNTRY, datas[i].getCounty())
            cv.put(AQI, datas[i].getAQI())
            cv.put(POLLUTANT, datas[i].getPollutant())
            cv.put(STATUS, datas[i].getStatus())
            cv.put(SO2, datas[i].getSO2())
            cv.put(CO, datas[i].getCO())
            cv.put(CO_8HR, datas[i].getCO_8hr())
            cv.put(O3, datas[i].getO3())
            cv.put(O3_8HR, datas[i].getO3_8hr())
            cv.put(PM10, datas[i].getPM10())
            cv.put(PM25, datas[i].`get_$PM25313`())
            cv.put(NO2, datas[i].getNO2())
            cv.put(NOX, datas[i].getNOx())
            cv.put(NO, datas[i].getNO())
            cv.put(WIND_SPEED, datas[i].getWindSpeed())
            cv.put(WIND_DIREC, datas[i].getWindDirec())
            cv.put(PUBLISH_TIME, datas[i].getPublishTime())
            cv.put(PM25_AVG, datas[i].`get_$PM25_AVG294`())
            cv.put(PM10_AVG, datas[i].getPM10_AVG())
            cv.put(SO2_AVG, datas[i].getSO2_AVG())
            cv.put(LONGITUDE, datas[i].getLongitude())
            cv.put(LATITUDE, datas[i].getLatitude())
            cv.put(IS_DELETE, 0)//預設false 沒被刪除
            db.insert(DB_TABLE_MAIN, null, cv)

        }
    }

    fun updateAllAQIDatas(datas: List<DataBean>) {
        val db = this.writableDatabase

        for (dataBean in datas) {
            val values = ContentValues()
            values.put(AQI, dataBean.getAQI())
            values.put(POLLUTANT, dataBean.getPollutant())
            values.put(STATUS, dataBean.getStatus())
            values.put(SO2, dataBean.getSO2())
            values.put(CO, dataBean.getCO())
            values.put(CO_8HR, dataBean.getCO_8hr())
            values.put(O3, dataBean.getO3())
            values.put(O3_8HR, dataBean.getO3_8hr())
            values.put(PM10, dataBean.getPM10())
            values.put(PM25, dataBean.`get_$PM25313`())
            values.put(NO2, dataBean.getNO2())
            values.put(NOX, dataBean.getNOx())
            values.put(NO, dataBean.getNO())
            values.put(WIND_SPEED, dataBean.getWindSpeed())
            values.put(WIND_DIREC, dataBean.getWindDirec())
            values.put(PUBLISH_TIME, dataBean.getPublishTime())
            values.put(PM25_AVG, dataBean.`get_$PM25_AVG294`())
            values.put(PM10_AVG, dataBean.getPM10_AVG())
            values.put(SO2_AVG, dataBean.getSO2_AVG())
            values.put(LONGITUDE, dataBean.getLongitude())
            values.put(LATITUDE, dataBean.getLatitude())
            db.update(DB_TABLE_MAIN, values, SITE_NAME + " = '" + dataBean.getSiteName() + "' and " + COUNTRY + " = '" + dataBean.getCounty() + "'", null)
        }

    }

    fun updateIsDelete(id: Int, is_delete: Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(IS_DELETE, is_delete)
        db.update(DB_TABLE_MAIN, values, ID + " = " + id, null)
    }

    fun restoreIsDelete() {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(IS_DELETE, 0)
        db.update(DB_TABLE_MAIN, values, IS_DELETE + " = 1", null)
    }


    @Synchronized override fun close() {
        super.close()
        instance = null
    }

}