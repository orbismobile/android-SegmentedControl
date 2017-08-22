package com.orbismobile.segmentedcontrol;


import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatRadioButton;

/**
 * Created by carlosleonardocamilovargashuaman on 8/22/17.
 */

public class SegmentedControlRadioButton extends AppCompatRadioButton {

    private int segmentTextColor;
    private int segmentCheckedTextColor;

    private int segmentBackground;

    public SegmentedControlRadioButton(Context context) {
        super(context);
    }

    public SegmentedControlRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    public SegmentedControlRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.Segment, defStyleAttr, defStyleRes);

        segmentTextColor = typedArray.getColor(
                R.styleable.Segment_segmentTextColor, ContextCompat.getColor(this.getContext(), R.color.md_red_500));

        segmentCheckedTextColor = typedArray.getColor(
                R.styleable.Segment_segmentCheckedTextColor, ContextCompat.getColor(this.getContext(), R.color.md_white_1000));


        ColorStateList colorStateList = new ColorStateList(new int[][]{
                {-android.R.attr.state_checked},
                {android.R.attr.state_checked}},
                new int[]{segmentTextColor, segmentCheckedTextColor});

        segmentBackground = typedArray.getResourceId(R.styleable.Segment_segmentBackground, R.drawable.selector_segmented_control_center);

        setBackgroundResource(segmentBackground);

        setTextColor(colorStateList);
    }
}
