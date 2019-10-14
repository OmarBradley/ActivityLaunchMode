package omarbradley.com.activitylaunchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_c)
		Log.e(TAG, "onCreate - CActivity")
		button.setOnClickListener {
			startActivity(Intent(this@CActivity, BActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
		}
	}

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		Log.e(TAG, "onNewIntent - CActivity")
	}
}
