package eu.tutorial.quizappprac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        val ename = findViewById<TextView>(R.id.tv_ed)

         btn.setOnClickListener()
         {
            if (ename.text.isNotEmpty()) {
                val name = ename.text
                val intent = Intent(this, QuizQuestion::class.java)
                intent.putExtra(listofquestion.User_Name,ename.text.toString())
                startActivity(intent)
                finish()
            }
             else
            {

                Toast.makeText(this,"Hare Krishna  " +
                        "Please Enter Your Name",Toast.LENGTH_LONG).show()
            }
        }
       }
}
