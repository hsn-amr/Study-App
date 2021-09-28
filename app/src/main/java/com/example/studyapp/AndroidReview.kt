package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AndroidReview : AppCompatActivity() {

    lateinit var rvAndroidReview: RecyclerView
    private val titleList = arrayListOf("New Project", "onCreate", "activity_main.xml", "console", "lateinit","Resource Files")
    private val infoList = arrayListOf("How To Create New Project", "What is onCreate Method?",
        "Design Our App", "print information on console", "Initializing UI Elements", "Here, we have the colors.xml and themes.xml files")
    private val explainings = arrayListOf(
        "After installation android studio and open it, click “new project” then select “empty activity” then type name of app and leave package name it is like unique ID for the project, then select programming language here we select Kotlin, then click finish\n" +
                "\n" +
                "It will open window has two sections:\n" +
                "1-\tLeft side = project structure\n" +
                "2-\tRight side = MainActivity, this is kotlin file serves as an entry point to our application.\n",
        "\"onCreate\" method, which is the starting point of our application.  When our application starts, the code between the two curly brackets executes. \n" +
                "override fun onCreate(savedInstanceState: Bundle?) {\n" +
                "    super.onCreate(savedInstanceState)\n" +
                "    setContentView(R.layout.activity_main)\n" +
                "}\n",
    "activity_main.xml reveals a visual representation of our application.\n" +
            "We can use the tools provided to drag and drop various UI elements and control their functionality.\n" +
            "The two views we see are the \"Design View\" and the \"Blueprint View\"\n" +
            "The main difference between the two views is that the \"Blueprint View\" keeps track of invisible items that do not appear on the \"Design View\"  \n" +
            "XML is a markup language similar to HTML.  Android Studio uses it to create and modify UI elements.\n" +
            "\n" +
            "<TextView\n" +
            "android:layout_width=\"wrap_content\"\n" +
            "android:layout_height=\"wrap_content\"\n" +
            "android:text=\"Hello World!\"\n" +
            "app:layout_constraintbottom_tobottomof=\"parent\"\n" +
            "app:layout_constraintleft_toleftof=\"parent\"\n" +
            "app:layout_constraintright_torightof=\"parent\"\n" +
            "app:layout_constrainttop_totopof=\"parent\"/>\n",
    "we can use the console to print information while we develop our app. Anything that prints to the console will be invisible to the end-user.\n" +
            "We can go to Logcat to see what we print on console\n" +
            "print(\"see console\")\n" +
            "Log.d(\"[file name] MainActivity\", \"[message] see\")\n",
    "lateinit var btnNumberGame: Button\n" +
            "we use “latainit” to tell Kotlin we will initialize that variable and for able use that variable out onCreate method\n",
    "Here, we have the colors.xml and themes.xml files. Making changes to these files allows us to set a base color for every UI Element (more on those later) we create. These UI Elements can then be changed individually\n" +
            "Each color uses a Hex Color Code.\n" +
            "It is important to keep in mind that the color names in the base file are used across the app. If you choose to make changes to the names of these colors, you should use the 'refractor' tool.\n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_review)
        this.title = "Android Review"

        rvAndroidReview = findViewById(R.id.rvAndroidReview)

        rvAndroidReview.adapter = AndroidRecyclerViewAdapter(titleList, infoList, explainings)
        rvAndroidReview.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item : MenuItem = menu!!.getItem(0)
        item.title = "Kotlin Review"
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.android_review -> {
                val kotlinIntent = Intent(this, KotlinReview::class.java)
                startActivity(kotlinIntent)
            }
            R.id.main_page -> {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}