package jp.techacademy.masaaki.kabe.threadamount3

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button1
import kotlinx.android.synthetic.main.activity_start.*
import java.lang.Double.sum


class MainActivity : AppCompatActivity() {


private val unit=mapOf("" to 0,"号数" to 1,"lb" to 2)

private val PEItems= mapOf(
        "" to 0.0,
        0.4 to 0.108,
        0.5 to 0.121,
        0.6 to 0.132,
        0.7 to 0.143,
        0.8 to 0.153,
        1.0 to 0.171,
        1.2 to 0.191,
        1.5 to 0.209,
        2.0 to 0.242,
        2.5 to 0.27,
        3.0 to 0.296,
        4.0 to 0.342,
        5.0 to 0.382,
        6.0 to 0.418,
        8.0  to 0.483,
        10 to 0.54
    )

private val Nylon_go_Items= mapOf(
        "" to 0.0,
        1 to 0.165,
        1.5 to 0.205,
        2 to 0.235,
        2.5 to 0.26,
        3 to 0.285,
        3.5 to 0.31,
        4 to 0.33,
        5 to 0.37,
        6 to 0.405,
        7 to 0.435,
        8 to 0.47,
        10 to 0.52
    )

    private val Nylon_lb_Items= mapOf(
        "" to 0.0,
       2 to 0.117,
        4 to 0.165,
        6 to 0.205,
        8 to 0.235,
        10 to 0.26,
        12 to 0.285,
        14 to 0.31,
        16 to 0.33,
        20 to 0.37,
        22 to 0.405,
        25 to 0.435,
        28 to 0.47,
        35 to 0.52
    )

    private val NylonItems= mapOf("" to null)


    var reel_PEdiameter1:Double=0.0
    var reel_PEdiameter2:Double=0.0
    var reel_Nylondiameter1:Double=0.0
    var reel_Nylondiameter2:Double=0.0
    var reel_PE_length=0
    var reel_Nylon_length=0
    var reel_handle=0.0
    var reel_PE_length2=0

    var kaitenNumber=0
    var shitamaki_Nylon_length2=0








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        title="条件設定"


        val unit_key=unit.keys.toList()
        val unit_value=unit.values.toList()

        val PEitems_key=PEItems.keys.toList()
        val PEitems_value=PEItems.values.toList()

        val Nylon_go_Items_key=Nylon_go_Items.keys.toList()
        val Nylon_go_Items_value=Nylon_go_Items.values.toList()

        val Nylon_lb_Items_key=Nylon_lb_Items.keys.toList()
        val Nylon_lb_Items_value=Nylon_lb_Items.values.toList()

        val NylonItems_key=NylonItems.keys.toList()



        //unitのspinner
        val unit_spinner=findViewById<Spinner>(R.id.spinnerUnit1)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unit_key)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        unit_spinner.adapter = adapter

        //PE1のspinner
        val PE1_spinner=findViewById<Spinner>(R.id.spinnerUnit2)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, PEitems_key)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        PE1_spinner.adapter = adapter2

        //PE2のspinner
        val PE2_spinner=findViewById<Spinner>(R.id.spinnerUnit4)
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_spinner_item, PEitems_key)
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        PE2_spinner.adapter = adapter4



        // unit選択/////////////////////////////
        unit_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if(position==0){
                    textView9.text="??"
                    textView21.text="??"

                    val Nylon_spinner=findViewById<Spinner>(R.id.spinnerUnit3)
                    val adapter5 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, NylonItems_key)
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_spinner.adapter = adapter5

                    val Nylon_spinner55=findViewById<Spinner>(R.id.spinnerUnit5)
                    val adapter55 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, NylonItems_key)
                    adapter55.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_spinner55.adapter = adapter55


                }else if(position==1){
                    textView9.text="号"
                    textView21.text="号"

                    //Nylon号のspinner
                    val Nylon_GO_spinner3=findViewById<Spinner>(R.id.spinnerUnit3)
                    val adapter3 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, Nylon_go_Items_key)
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_GO_spinner3.adapter = adapter3

                    val Nylon_GO_spinner5=findViewById<Spinner>(R.id.spinnerUnit5)
                    val adapter5 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, Nylon_go_Items_key)
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_GO_spinner5.adapter = adapter5

                    Nylon_GO_spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        // unit選択された時に呼ばれる
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            reel_Nylondiameter1=Nylon_go_Items_value[position]
                        }
                        // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }
                    }

                    Nylon_GO_spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        // unit選択された時に呼ばれる
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            reel_Nylondiameter2=Nylon_go_Items_value[position]
                        }
                        // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }
                    }

                }else if (position==2){
                    textView9.text="lb"
                    textView21.text="lb"

                    val Nylon_lb_spinner3_1=findViewById<Spinner>(R.id.spinnerUnit3)
                    val adapter3_1 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, Nylon_lb_Items_key)
                    adapter3_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_lb_spinner3_1.adapter = adapter3_1

                    val Nylon_lb_spinner5_1=findViewById<Spinner>(R.id.spinnerUnit5)
                    val adapter5_1 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, Nylon_lb_Items_key)
                    adapter5_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    Nylon_lb_spinner5_1.adapter = adapter5_1



                    Nylon_lb_spinner3_1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        // unit選択された時に呼ばれる
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            reel_Nylondiameter1=Nylon_lb_Items_value[position]
                        }
                        // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }
                    }

                    Nylon_lb_spinner5_1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        // unit選択された時に呼ばれる
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            reel_Nylondiameter2=Nylon_lb_Items_value[position]
                        }
                        // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }
                    }

                }
            }
            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        // PE1選択////////////////////////////////////////////////////////////
        PE1_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // unit選択された時に呼ばれる
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        reel_PEdiameter1=PEitems_value[position]

            }
            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        // PE2選択////////////////////////////////////////////////////////////
        PE2_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // unit選択された時に呼ばれる
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                reel_PEdiameter2=PEitems_value[position]

            }
            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        //キーボードを閉じる
        editText1.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                // キーボード閉じる処理

                inputMethodManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)

                true
            }
            false
        }

        editText2.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                // キーボード閉じる処理
                inputMethodManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)

                true
            }
            false
        }

        editText3.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                // キーボード閉じる処理
                inputMethodManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)

                true
            }
            false
        }

        editText4.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                // キーボード閉じる処理
                inputMethodManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)

                true
            }
            false
        }






        button1.setOnClickListener{v->

           var reel_Nylon_length_s=editText1.text.toString()
            if(reel_Nylon_length_s!=""){
                reel_Nylon_length=reel_Nylon_length_s.toInt()
            }

            var reel_PE_length_s=editText2.text.toString()
            if(reel_PE_length_s!=""){
                reel_PE_length=reel_PE_length_s.toInt()
            }

            var reel_PE_length_s2=editText4.text.toString()
            if(reel_PE_length_s2!=""){
                reel_PE_length2=reel_PE_length_s2.toInt()
            }

            var reel_handle_s=editText3.text.toString()
            if(reel_handle_s!=""){
                reel_handle=reel_handle_s.toDouble()/100
            }

            //Log.d("kotlintest",reel_Nylondiameter1.toString())
            //Log.d("kotlintest",reel_Nylondiameter2.toString())
           // Log.d("kotlintest",reel_PEdiameter1.toString())
           // Log.d("kotlintest",reel_PEdiameter2.toString())
            //Log.d("kotlintest",reel_Nylon_length.toString())
            //Log.d("kotlintest", reel_PE_length.toString())
           // Log.d("kotlintest",reel_handle.toString())
           //Log.d("kotlintest",reel_PE_length2.toString())








            if ( reel_Nylondiameter1==0.0) {
                Snackbar.make(v, "ナイロンの太さが選ばれていません", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if(reel_Nylon_length==0){
                Snackbar.make(v, "ナイロンの長さは0以外の値を入力して下さい", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (reel_PEdiameter1==0.0) {
                Snackbar.make(v, "PEの太さが選ばれていません", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if(reel_PE_length==0){
                Snackbar.make(v, "PEの長さは0以外の値を入力して下さい", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if(reel_handle==0.0) {
                Snackbar.make(v, "ハンドルの巻取り量は0以外の値を入力して下さい", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (reel_PEdiameter2==0.0){
            Snackbar.make(v, "PEの太さが選ばれていません", Snackbar.LENGTH_LONG).show()
            return@setOnClickListener
            }else if(reel_PE_length2==0){
                Snackbar.make(v, "PEの長さは0以外の値を入力して下さい", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (reel_Nylondiameter2==0.0){
                Snackbar.make(v, "ナイロンの太さが選ばれていません", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }


            //巻きたいPEのとき何メートル可能か
            //スペックのPE体積
            val PEvol1=(reel_PEdiameter1/2)*(reel_PEdiameter1/2)*3.14*reel_PE_length

            //巻きたいPEの体積
            val PEvol2=(reel_PEdiameter2/2)*(reel_PEdiameter2/2)*3.14*reel_PE_length2

            //巻きたいPEの号数のとき何メートル巻けるか
            val PElength=PEvol1/((reel_PEdiameter2/2)*(reel_PEdiameter2/2)*3.14)

            //PEが占める割合
            val PEratio=PEvol2/PEvol1

            //下巻が占める割合
            val Nylonratio=1-PEratio

            //スペックのナイロン体積
            val Nylonvo1=(reel_Nylondiameter1/2)*(reel_Nylondiameter1/2)*3.14*reel_Nylon_length

            //巻きたいナイロンの号数のとき何メートル巻けるか
            val Nylonlength=Nylonvo1/((reel_Nylondiameter2/2)*(reel_Nylondiameter2/2)*3.14)

            //ナイロンの体積基準で考えたときの下巻の長さ
            val shitamaki_Nylon_length_1=Nylonvo1*Nylonratio/((reel_Nylondiameter2/2)*(reel_Nylondiameter2/2)*3.14)

            //PE基準で考えたときの下巻の長さ
            val shitamaki_Nylon_length_2=PEvol1*Nylonratio/((reel_Nylondiameter2/2)*(reel_Nylondiameter2/2)*3.14)

            //平均の長さ
            val shitamaki_Nylon_length=(shitamaki_Nylon_length_1+shitamaki_Nylon_length_2)/2


            kaitenNumber=Math.round(shitamaki_Nylon_length/reel_handle).toInt()
            shitamaki_Nylon_length2=Math.round(shitamaki_Nylon_length).toInt()


            //Log.d("kotlintest",PEvol1.toString())
            //Log.d("kotlintest",PEvol2.toString())
            //Log.d("kotlintest",PElength.toString())
            //Log.d("kotlintest",PEratio.toString())
            //Log.d("kotlintest",Nylonvo1.toString())
            //Log.d("kotlintest",Nylonlength.toString())
           // Log.d("kotlintest",shitamaki_Nylon_length.toString())
            //Log.d("kotlintest",kaitenNumber.toString())
            //Log.d("kotlintest2",shitamaki_Nylon_length_1.toString())
            //Log.d("kotlintest2",shitamaki_Nylon_length_2.toString())

            if(PEratio>=1){
                Snackbar.make(v, "下巻は必要ありません", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }


                val intent = Intent(applicationContext, result::class.java)
                intent.putExtra("shitamakilenght",shitamaki_Nylon_length2)
                intent.putExtra("kaitensuu", kaitenNumber)
                startActivity(intent)
            }



        }












        //val a= mapOf("apple" to 2,"orange" to 3,"banana" to 2)
        //var b=a.keys.toList()

       // val newarraylist=ArrayList<String>()
       //// for(i in b){
            //newarraylist.add(i)
        //}


        //Log.d("kotlintest1",newarraylist.toString()







}
