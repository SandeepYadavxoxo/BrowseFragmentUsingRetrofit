
package com.example.BrowseFragmentUsingRetrofit;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * A collection of utility methods, all static.
 */
public class Utils {
    private Utils() {
    }

    /**
     * Returns the screen/display size
//     */
//    public static Point getDisplaySize(Context context) {
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        return size;
//    }

    public static int convertPixelToDp(Context ctx, int px) {
        float density = ctx.getResources().getDisplayMetrics().density;
        return Math.round(px / density);
        //round() is a built-in math function which returns the closest long to the argument
    }

//    public static String formatMillis(int millis) {
//        String result = "";
//        int hr = millis / 3600000;
//        millis %= 3600000;
//        int min = millis / 60000;
//        millis %= 60000;
//        int sec = millis / 1000;
//        if (hr > 0) {
//            result += hr + ":";
//        }
//        if (min >= 0) {
//            if (min > 9) {
//                result += min + ":";
//            } else {
//                result += "0" + min + ":";
//            }
//        }
//        if (sec > 9) {
//            result += sec;
//        } else {
//            result += "0" + sec;
//        }
//        return result;
//    }
}