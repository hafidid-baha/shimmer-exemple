package agh.hafid.shimmerapp

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var shimmer:ShimmerFrameLayout;
    lateinit var dataContainer:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shimmer = findViewById(R.id.shimmer)
        dataContainer = findViewById(R.id.dataContainer)
        dataContainer.setHasFixedSize(true)
        dataContainer.layoutManager = LinearLayoutManager(this)

    }

    fun getData() {
        val url = "https://jsonplaceholder.typicode.com/photos"
        val photos = mutableListOf<JSONObject>()
        val stringRequest: StringRequest = object : StringRequest(
            Method.GET,
            url,
            Response.Listener { response ->
                Log.d("response","response is ${response}")

                try {
                    val json = JSONArray(response)

                    for (i in 0 until json.length()) {
                        photos.add(json.getJSONObject(i))
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {
                Log.d("response",it.toString())

            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                return super.getParams()
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    override fun onResume() {
        super.onResume()
        shimmer.startShimmer()
        getData()
    }

    override fun onPause() {
        super.onPause()
        shimmer.stopShimmer()
    }
}