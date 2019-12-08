package io.github.itakahiro.architecturefootball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.itakahiro.architecturefootball.feature.football.FootballFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout,
                FootballFragment()
            )
            .commit()
    }
}
