package omarbradley.com.activitylaunchmode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_c)

		button.setOnClickListener {
			startActivity(Intent(this@CActivity, MainActivity::class.java))
		}
	}
}
