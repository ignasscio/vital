package itson.edu.mx.vital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var splash = findViewById<TextView>(R.id.splash)

        splash.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent, null)
        }

    }
}