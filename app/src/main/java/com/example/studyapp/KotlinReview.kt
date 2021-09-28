package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KotlinReview : AppCompatActivity() {

    lateinit var rvKotlinReview: RecyclerView
    private val titleList = arrayListOf("Overview", "val and var", "User Input", "String", "Data Types",
        "If Statements", "Try/Catch", "For Loops & While Loops", "When")

    private val infoList = arrayListOf("What is Kotlin", "How declare variables?", "Read From User",
    "Concatenation and Interpolation (Templates)", "Integers, Floats, Strings, and Booleans", "Control Your App",
    "make sure that your program does not crash ", "Repeat You Code", "When blocks are similar to a series of if statements")

    private val explainings = arrayListOf(
        "Kotlin is an open-source statically typed programming language developed by JetBrains.\n" +
            "Kotlin runs on the Java Virtual Machine and requires a Java Development Kit.\n" +
            "Kotlin code can easily call Java code, and vice versa\n" +
            "The use cases of Kotlin:\n" +
            "•\tAndroid\n" +
            "•\tweb development\n" +
            "•\tserver-side development\n" +
            "•\tdesktop development\n",
        "val keyword are immutable\n" +
            "var keyword are mutable and can be changed anytime.\n" +
            "val limit = 3\n" +
            "var i = 0\n",
        "Create a variable that holds the input, then get the user input with readLine()\n" +
            "var country = readLine()\n",
    "String concatenation refers to combining strings (or other data types) with the use of a + sign\n" +
            "println(key + \", its capital is \" + value)\n" +
            "String Interpolation, allows us to inject variables into a string\n" +
            "println(\"\$key, its capital is \$value\")\n",
    "Converting Floats to Integers can lead to data loss.\n" +
            "We have to use two exclamation marks after readLine() to tell Kotlin that the user will definitely enter something. This can be dangerous and cause a crash if the user does not enter a number,\n" +
            "var country = readLine()!!\n",
    "val num = readLine()!!.toInt()\n" +
            "if(num > 5){\n" +
            "    println(\"The number is larger than 5\")\n" +
            "}\n" +
            "\n" +
            "We can use multipul if statements\n" +
            "val num = readLine()!!.toInt()\n" +
            "if(num < 5){\n" +
            "    println(\"The number is smaller than 5\")\n" +
            "}\n" +
            "if(num == 5){\n" +
            "    println(\"The number is 5\")\n" +
            "}\n" +
            "if(num > 5){\n" +
            "    println(\"The number is larger than 5\")\n" +
            "}\n" +
            "\n" +
            "Here if else \n" +
            "val num = readLine()!!.toInt()\n" +
            "if(num < 5){\n" +
            "    println(\"The number is smaller than 5\")\n" +
            "}else if(num == 5){\n" +
            "    println(\"The number is 5\")\n" +
            "}else{\n" +
            "    println(\"The number is larger than 5\")\n" +
            "}   \n",
    "Let's see how we can make sure that our program does not crash even if the user does not follow our directions.\n" +
            "val num = 10\n" +
            "print(\"Enter a number: \")\n" +
            "try {\n" +
            "    val userNum = readLine()!!.toInt()\n" +
            "    val sum = num + userNum\n" +
            "    println(sum)\n" +
            "} catch (e: Exception) {\n" +
            "    println(\"Please enter numbers only\")\n" +
            "}                \n",
    "Very often we need something to happen multiple times. Instead of typing the same thing over and over again, we can use loops.\n" +
            "for(number in 1..5){\n" +
            "    println(number)\n" +
            "}  \n" +
            "While loops are very similar to For Loops. They can perform the same actions.\n" +
            "var count = 0\n" +
            "while (count < 5){\n" +
            "    count ++\n" +
            "    println(count)\n" +
            "}  \n",
    "When blocks are similar to a series of if statements. They allow us to perform a check in a more concise way and handle each condition appropriately.\n" +
            "val grade = readLine()!!.toInt()\n" +
            "when {\n" +
            "    grade < 60 -> println(\"F\")\n" +
            "    grade < 70 -> println(\"D\")\n" +
            "    grade < 80 -> println(\"C\")\n" +
            "    grade < 90 -> println(\"B\")\n" +
            "    else -> println(\"A\")\n" +
            "}    \n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_review)
        this.title = "Kotlin Review"

        rvKotlinReview = findViewById(R.id.rvKotlinReview)

        rvKotlinReview.adapter = KotlinRecyclerViewAdapter(titleList, infoList, explainings)
        rvKotlinReview.layoutManager =LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.android_review -> {
                val androidIntent = Intent(this, AndroidReview::class.java)
                startActivity(androidIntent)
            }
            R.id.main_page -> {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}