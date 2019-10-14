package omarbradley.com.activitylaunchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_b)
		Log.e(TAG, "onCreate - BActivity")
		button.setOnClickListener {
			startActivity(Intent(this@BActivity, CActivity::class.java))
		}
	}

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		Log.e(TAG, "onNewIntent - BActivity")
	}
}
