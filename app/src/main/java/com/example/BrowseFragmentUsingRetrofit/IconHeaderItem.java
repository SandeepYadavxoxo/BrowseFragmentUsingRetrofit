package com.example.BrowseFragmentUsingRetrofit;

import androidx.leanback.widget.HeaderItem;

public class IconHeaderItem extends HeaderItem {

    private static final String TAG = IconHeaderItem.class.getSimpleName();
    public static final int ICON_NONE = -1;

    public IconHeaderItem(long id, String name) {
        super(id, name);
    }


}
