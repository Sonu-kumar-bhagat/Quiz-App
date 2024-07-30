package eu.tutorial.quizappprac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class result : AppCompatActivity() {
    var name1 :TextView? = null
    var tscore: TextView? = null
    var tquestion:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        name1 = findViewById(R.id.name)
        tscore = findViewById(R.id.mname)
        var button :Button = findViewById(R.id.finish)
        tquestion = intent.getIntExtra(listofquestion.Total_Question,0)
        val tscore1:Int = intent.getIntExtra(listofquestion.Correct_Answers,0)
        val mname1:String?= intent.getStringExtra(listofquestion.User_Name)

        name1!!.text =  mname1
        tscore?.text = "your score in ${tscore1} out of ${tquestion}"
        button.setOnClickListener()
        {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }





    }
}