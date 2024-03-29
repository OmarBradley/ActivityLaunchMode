package omarbradley.com.activitylaunchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val TAG = "lifecycle"

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		Log.e(TAG, "onCreate - MainActivity")

		button.setOnClickListener {
			startActivity(Intent(this@MainActivity, BActivity::class.java))
		}
	}

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		Log.e(TAG, "onNewIntent - MainActivity")
	}
}
