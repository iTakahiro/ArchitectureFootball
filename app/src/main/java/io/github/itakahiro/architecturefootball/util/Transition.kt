package io.github.itakahiro.architecturefootball.util

import androidx.fragment.app.Fragment

interface Transition {
    fun replaceFragment(nextFragment: Fragment)
}