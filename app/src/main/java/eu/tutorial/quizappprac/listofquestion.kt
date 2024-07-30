package eu.tutorial.quizappprac

object listofquestion {
   val User_Name:String = "username"
    val Correct_Answers:String ="correctanswers"
    val Total_Question:String ="totalquestion"

    fun getquestions():ArrayList<Question>
    {
        val questions = ArrayList<Question>()
        val question1 = Question(
            1,"Which country does this flag belongs ?","Australlia",
            "Bharat","Nepal","Germany",
            R.drawable.australlia,
            1
        )
        questions.add(0,question1)

        val question2 = Question(
            2,"Which country does this flag belongs ?","France",
            "Bharat","Nepal","Indonesia",
            R.drawable.ind,
            2
        )
        questions.add(1,question2)

        val question3 = Question(
            3,"Which country does this flag belongs ?","Pakistan",
            "Bharat","Germany","Indonesia",
            R.drawable.germany,
            3
        )
        questions.add(2,question3)

        val question4 = Question(
            4,"Which country does this flag belongs ?","France",
            "Bharat","Germany","Indonesia",
            R.drawable.france,
            1
        )
        questions.add(3,question4)

        val question5 = Question(
            5,"Which country does this flag belongs ?","America",
            "Bharat","Turkey","Indonesia",
            R.drawable.usa,
            1
        )
        questions.add(4,question5)

        val question6 = Question(
            6,"Which country does this flag belongs ?","France",
            "Brazil","England","Scotland",
            R.drawable.uk,
            3
        )
        questions.add(5,question6)

        val question7 = Question(
            7,"Which country does this flag belongs ?","Turkey",
            "China","Pakistan","Saudi Arabia",
            R.drawable.turkey,
            1
        )
        questions.add(6,question7)


        val question8 = Question(
            8,"Which country does this flag belongs ?","Italy",
            "China","Pakistan","UAE",
            R.drawable.china,
            2
        )
        questions.add(7,question8)

        val question9= Question(
            9,"Which country does this flag belongs ?","Germany",
            "Spain","Poland","Saudi Arabia",
            R.drawable.poland,
            3
        )
        questions.add(8,question9)

        val question10 = Question(
            10,"Which country does this flag belongs ?","Russia",
            "Bharat","Pakistan","Nepal",
            R.drawable.russia,
            1
        )
        questions.add(9,question10)
        return questions


    }
}