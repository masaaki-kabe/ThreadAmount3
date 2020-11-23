package jp.techacademy.masaaki.kabe.threadamount3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_start.*


class result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        title="下巻量計算結果（参考値）"


        val value1 = intent.getIntExtra("shitamakilenght", 0)
        val value2 = intent.getIntExtra("kaitensuu", 0)

        Log.d("kotlintest",value1.toString())

        textView100.text= "$value1"
        textView400.text= "$value2"

        button_return.setOnClickListener{View->
            finish()

        }


    }
}
