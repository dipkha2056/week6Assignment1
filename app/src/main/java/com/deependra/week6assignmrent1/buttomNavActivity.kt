package com.deependra.week6assignmrent1

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.deependra.week6assignmrent1.model.studentDetails

class buttomNavActivity : AppCompatActivity() {
     val lstStudent = arrayListOf<studentDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttom_nav)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        loadStudent()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun loadStudent() {
        lstStudent.add(studentDetails(
                0, "Kiran Rana",
                "https://pbs.twimg.com/profile_images/596569727238967297/gIqrJae3_400x400.jpg",
                "Lalitpur", 30,"male"

        )
        )

        lstStudent.add(studentDetails(
                1, "Katrina kaif",
                "https://static.toiimg.com/photo/79142911.cms",
                "mumbai", 35,"female"

        )
        )

        lstStudent.add(studentDetails(
                2, "Salman Khan",
                "https://akm-img-a-in.tosshub.com/sites/dailyo/fb_feed_images/story_image/201606/salmankhan-sultan759_063016040138.jpg",
                "Delhi", 55,"male"

        )
        )
    }
}