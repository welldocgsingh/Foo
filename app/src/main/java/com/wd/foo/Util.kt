package com.wd.foo

import com.wd.calcandroid.Calc

class Util {

    companion object {
        fun log(s: String, i: Int): String {
            return s + " : " + Calc.doubleIt(i).toString()
        }
    }

}