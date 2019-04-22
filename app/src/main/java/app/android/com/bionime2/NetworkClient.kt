package app.android.com.bionime2

import android.content.Context
import android.content.Intent
import android.util.Log
import app.android.com.bionime2.bean.DataBean
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

/**
 * Created by laiguanyu on 2019/4/22.
 */
class NetworkClient(context: Context) {
    private val TAG = "NetworkClient"
    private val BROADCAST_ACTION = "app.android.com.bionime.broadcast"
    var context: Context

    init {
        this.context = context
    }

    fun getAQIData(url: String) {
        var decodedString: String? = ""
        var urlData = ""
        try {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.connect()
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            decodedString = reader.readLine()
            while (decodedString != null) {
                urlData += decodedString
                decodedString = reader.readLine()
            }
            reader.close()
            Log.d(TAG, "getUrlData: urlData = " + urlData)
            formateData(urlData)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun formateData(dataStr: String) {
        try {
            val jsonArray = JSONArray(dataStr)
            val list = ArrayList<DataBean>()
            for (i in 0 until jsonArray.length()) {
                val jsonItem = jsonArray.getJSONObject(i)
                val bean = Gson().fromJson<DataBean>(jsonItem.toString(), DataBean::class.java!!)
                list.add(bean)
            }
            val intent = Intent(BROADCAST_ACTION)
            intent.putExtra("type", "aqi")
            intent.putExtra("datas", list)
            context.sendBroadcast(intent)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun getSentence(url: String) {
        try {
            val doc = Jsoup.connect(url).get()
            val elements = doc.select("meta[name=description]")
            val content = elements[0].attr("content")
            Log.d(TAG, "getWebData: content = " + content)
            val intent = Intent(BROADCAST_ACTION)
            intent.putExtra("type", "sentence")
            intent.putExtra("sentence", content)
            context.sendBroadcast(intent)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}