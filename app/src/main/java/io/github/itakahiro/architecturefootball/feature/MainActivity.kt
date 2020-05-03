package io.github.itakahiro.architecturefootball.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.itakahiro.architecturefootball.R
import io.github.itakahiro.architecturefootball.feature.football.FootballFragment
import io.github.itakahiro.architecturefootball.util.Transition

class MainActivity : AppCompatActivity(), Transition {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val footballFragment = FootballFragment()
        replaceFragment(footballFragment)
    }

    override fun replaceFragment(nextFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, nextFragment)
            .addToBackStack(null)
            .commit()
    }
}
