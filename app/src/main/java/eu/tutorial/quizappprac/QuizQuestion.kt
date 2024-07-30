package eu.tutorial.quizappprac

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {
     var btnsubmit:Button? = null
    var  question:TextView? = null
    var option1:TextView? = null
    var option2:TextView? = null
    var option3:TextView? = null
    var option4:TextView? = null
    var image :ImageView?= null
    var mslectedoption:Int= 0
    var mcurrentposition:Int =1
    var clickable :Int =0
    var listofquestions:ArrayList<Question> ?=  null
    var progressbar:ProgressBar? =null
    var progview:TextView? =null
    var correctanswers:Int = 0
    var mname :String? =null
       var mcorrectoption:Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
      btnsubmit = findViewById(R.id.btn2)
        question = findViewById(R.id.tv)
        option1  = findViewById(R.id.option1)
        option2  = findViewById(R.id.option2)
        option3  = findViewById(R.id.option3)
        option4  = findViewById(R.id.option4)
        image = findViewById(R.id.image)
        progressbar = findViewById(R.id.prog)
        progview = findViewById(R.id.progtv)
        listofquestions =  listofquestion.getquestions()
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

       setquestion()

    }
   fun defaultoptionview()
   {
       var options=ArrayList<TextView>()
       option1?.let{
           options.add(0,it)
       }
       option2?.let{
           options.add(1,it)}
       option3?.let{
           options.add(2,it)
       }
       option4?.let{
           options.add(3,it)
       }
        for (option in options)
        {
            option.setTextColor(Color.parseColor("#595858"))
            option.typeface = Typeface.DEFAULT
            //option.setTypeface(option.typeface,Typeface.DEFAULT) no use for default font
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defaultoptionview
            )
        }
   }

    fun setquestion()
    {
        defaultoptionview()
       var questionset = listofquestions!![mcurrentposition - 1]
        question?.text = questionset.question
        image?.setImageResource(questionset.image)
        option1?.text = questionset.option1
        option2?.text = questionset.option2
        option3?.text = questionset.option3
        option4?.text = questionset.option4
        mcorrectoption = questionset.coreectoption
        btnsubmit?.text = "SUBMIT"
        progressbar?.progress = mcurrentposition
        progview?.text ="$mcurrentposition/${listofquestions?.size}"

    }
    fun selectedoptionview(view: TextView, selectedoption:Int)
    {
        defaultoptionview()

      mslectedoption =  selectedoption
          view.setTypeface(view.typeface,Typeface.BOLD)

        view.setTextColor(Color.parseColor( "#212121"))
        view.background = ContextCompat.getDrawable(
           this,
            R.drawable.selectedoption

        )
    }

    override fun onClick(view: View?) {

            when (view?.id) {

                    R.id.option1 -> {
                        if (clickable ==0) {
                            option1?.let {
                                selectedoptionview(it, 1)
                            }
                        }
                    }
                    R.id.option2 -> {
                        if (clickable ==0) {
                            option2?.let {
                                selectedoptionview(it, 2)
                            }
                        }
                    }
                    R.id.option3 -> {
                        if (clickable ==0) {
                            option3?.let {
                                selectedoptionview(it, 3)
                            }
                        }
                    }
                    R.id.option4 -> {
                        if (clickable ==0) {
                            option4?.let {
                                selectedoptionview(it, 4)
                            }
                        }
                    }

                R.id.btn2 -> {
                    btnsubmit?.let {
                        if (mslectedoption == 0) {
                            clickable =0
                            mcurrentposition++
                            if (mcurrentposition <= listofquestions!!.size) {

                                setquestion()
                            } else {
                                mname = intent.getStringExtra(listofquestion.User_Name)
                                val intent = Intent(this, result::class.java)
                                intent.putExtra(listofquestion.Correct_Answers, correctanswers)
                                intent.putExtra(listofquestion.User_Name, mname)
                                intent.putExtra(
                                    listofquestion.Total_Question,
                                    listofquestions?.size
                                )
                                startActivity(intent)
                                finish()

                            }
                        } else {
                            //var questionl = listofquestions!![mcurrentposition - 1]
                            if (mslectedoption == mcorrectoption) {
                                answerview(mslectedoption, R.drawable.correct_option_bg)
                                correctanswers++
                            } else {
                                answerview(mcorrectoption, R.drawable.correct_option_bg)
                                answerview(mslectedoption, R.drawable.wrong_option_bg)
                            }
                            btnsubmit?.text = "Go To Next Question"
                            mslectedoption = 0
                            clickable =1
                        }
                    }
                }
            }
        }


    fun answerview(s:Int,bg:Int)
    {
     when(s)
     {
         1-> {
             option1?.background = ContextCompat.getDrawable(
                 this,
                 bg
             )
         }
         2-> {
             option2?.background = ContextCompat.getDrawable(
                 this,
                 bg
             )
         }
            3->{ option3?.background = ContextCompat.getDrawable(
                 this,
                 bg
             )}
             4->
             {
                 option4?.background = ContextCompat.getDrawable(
                 this,
                 bg
             )


         }
     }
    }

     }
