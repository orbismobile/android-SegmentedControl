package com.orbismobile.segmentedcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/**
 * Created by carlosleonardocamilovargashuaman on 8/21/17.
 */

public class SegmentedControl extends RadioGroup {

    public SegmentedControl(Context context) {
        super(context);
    }

    public SegmentedControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes){
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.ActionBar, defStyleAttr, defStyleRes);

    }
}
