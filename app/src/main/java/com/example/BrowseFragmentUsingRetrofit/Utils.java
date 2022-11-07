
package com.example.BrowseFragmentUsingRetrofit;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Utils {
    private Utils() {
    }
    public static Point getDisplaySize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static int convertPixelToDp(Context ctx, int px) {
        float density = ctx.getResources().getDisplayMetrics().density;
        return Math.round(px / density);
        //round() is a built-in math function which returns the closest long to the argument
    }

}