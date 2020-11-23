package jp.techacademy.masaaki.kabe.threadamount3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button1
import kotlinx.android.synthetic.main.activity_start.*

class Start : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        title="Welcome"

        button1.setOnClickListener{View->
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{View->


            val intent = Intent(applicationContext, manual::class.java)
            startActivity(intent)
        }

    }
}
