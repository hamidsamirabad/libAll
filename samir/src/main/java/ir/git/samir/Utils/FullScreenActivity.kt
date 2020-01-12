package ir.git.samir.Utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.WindowManager
import androidx.annotation.RequiresApi

class FullScreenActivity{

      @RequiresApi(Build.VERSION_CODES.KITKAT)
      fun  setWindowFlag(act:Activity) {

          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {




        var bits : Int = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION

         val win = act.window
         val winParams = win.attributes
         //if (on) {
        //    winParams.flags = winParams.flags or bits
       //  } else {
             winParams.flags = winParams.flags and bits.inv()
       //  }
         win.attributes = winParams


         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
             act.window.statusBarColor = Color.TRANSPARENT
         }
          }
     }

 }