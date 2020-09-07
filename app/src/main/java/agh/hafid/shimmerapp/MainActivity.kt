package agh.hafid.shimmerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {
    lateinit var shimmer:ShimmerFrameLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shimmer = findViewById(R.id.shimmer)
    }

    override fun onResume() {
        super.onResume()
        shimmer.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        shimmer.stopShimmer()
    }
}