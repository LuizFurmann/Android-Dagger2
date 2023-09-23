package com.aplicativo.topikotlin

import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val actvivityMain = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showList(){

        try {
            Thread.sleep(5000) //timer
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(R.id.rvUsuarios)).perform(
            RecyclerViewActions
            .actionOnItemAtPosition<RecyclerView.ViewHolder>(2,click()))

        onView(withId(Resources.getSystem().getIdentifier("search",
                "id", "android"))).perform(typeText("teste"))

        try {
            Thread.sleep(5000) //timer
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(R.id.search)).perform(click())

    }
}