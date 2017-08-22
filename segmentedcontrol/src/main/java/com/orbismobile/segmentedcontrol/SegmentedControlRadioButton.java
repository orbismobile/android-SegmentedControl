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

    private static final int LAYOUT_TYPE_START = 0;
    private static final int LAYOUT_TYPE_CENTER = 1;
    private static final int LAYOUT_TYPE_END = 2;
    private int segmentTextColor;
    private int segmentCheckedTextColor;

    private int segmentBgDrawable;
    private int typeOfView = 0;

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
                R.styleable.Segment_segmentTextColor, ContextCompat.getColor(this.getContext(), R.color.md_teal_500));

        segmentCheckedTextColor = typedArray.getColor(
                R.styleable.Segment_segmentCheckedTextColor, ContextCompat.getColor(this.getContext(), R.color.md_white_1000));


        typeOfView = typedArray.getInteger(R.styleable.Segment_segmentLayoutType, LAYOUT_TYPE_CENTER);


        ColorStateList colorStateList = new ColorStateList(new int[][]{
                {-android.R.attr.state_checked},
                {android.R.attr.state_checked}},
                new int[]{segmentTextColor, segmentCheckedTextColor});

        switch (typeOfView) {
            case LAYOUT_TYPE_START:
                segmentBgDrawable = typedArray.getResourceId(R.styleable.Segment_segmentLayout, R.drawable.selector_segmented_control_start);
                break;
            case LAYOUT_TYPE_CENTER:
                segmentBgDrawable = typedArray.getResourceId(R.styleable.Segment_segmentLayout, R.drawable.selector_segmented_control_center);
                break;
            case LAYOUT_TYPE_END:
                segmentBgDrawable = typedArray.getResourceId(R.styleable.Segment_segmentLayout, R.drawable.selector_segmented_control_end);
                break;
        }

        setBackgroundResource(segmentBgDrawable);

        setTextColor(colorStateList);
    }
}
