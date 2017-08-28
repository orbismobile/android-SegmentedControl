package com.orbismobile.segmentedcontrol;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/23/17.
 */

public class SegmentedControl extends LinearLayout implements View.OnClickListener {

    private int parentWidth;

    private boolean onlyFirstTime = true;
    private int sizeItem;


    private static final String TAG = SegmentedControl.class.getPackage().getName();
    private List<Object> objectList = new ArrayList<>();

    private int maxPills;
    private int segmentCheckedBackgroundStart;
    private int segmentCheckedBackgroundCenter;
    private int segmentCheckedBackgroundEnd;
    private int segmentTextColor;
    private int segmentSelectedTextColor;


    private int segmentSelectorCenter;
    private int segmentSelectorStart;
    private int segmentSelectorEnd;

    private int selectionMode;


    private static final int DEFAULT_MODE_MULTI_SELECTION = 1;
    private static final int DEFAULT_MAX_PILLS = 20;
    public OnSegmentClickListener onSegmentClickListener;

    public void setOnSegmentClickListener(OnSegmentClickListener onSegmentClickListener) {
        this.onSegmentClickListener = onSegmentClickListener;
    }

    public SegmentedControl(Context context) {
        super(context);
    }

    public SegmentedControl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    public SegmentedControl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SegmentedControl(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr, defStyleRes);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.SegmentedControl, defStyleAttr, defStyleRes);

        maxPills = a.getInt(
                R.styleable.SegmentedControl_maxPills, DEFAULT_MAX_PILLS);

        segmentSelectorStart = a.getResourceId(R.styleable.SegmentedControl_segmentSelectorStartBackground, R.drawable.selector_segment_start);
        segmentCheckedBackgroundStart = a.getResourceId(R.styleable.SegmentedControl_segmentStartFillBackground, R.drawable.shape_segment_start_checked);
        segmentSelectorCenter = a.getResourceId(R.styleable.SegmentedControl_segmentSelectorCenterBackground, R.drawable.selector_segment_center);
        segmentCheckedBackgroundCenter = a.getResourceId(R.styleable.SegmentedControl_segmentCenterFillBackground, R.drawable.shape_segment_center_checked);
        segmentSelectorEnd = a.getResourceId(R.styleable.SegmentedControl_segmentSelectorEndBackground, R.drawable.selector_segment_end);
        segmentCheckedBackgroundEnd = a.getResourceId(R.styleable.SegmentedControl_segmentEndFillBackground, R.drawable.shape_segment_end_checked);


//        pillMarginTop = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillMarginTop, getResources().getDimensionPixelOffset(R.dimen.default_pill_margin));
//        pillMarginBottom = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillMarginBottom, getResources().getDimensionPixelOffset(R.dimen.default_pill_margin));
//        pillMarginLeft = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillMarginLeft, getResources().getDimensionPixelOffset(R.dimen.default_pill_margin));
//        pillMarginRight = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillMarginRight, getResources().getDimensionPixelOffset(R.dimen.default_pill_margin));
//        hideCloseIcon =
//                a.getBoolean(R.styleable.SegmentedControl_showCloseIcon, false);
        segmentTextColor = a.getColor(
                R.styleable.SegmentedControl_segmentTextColor, ContextCompat.getColor(this.getContext(), R.color.md_blue_500));
        segmentSelectedTextColor = a.getColor(
                R.styleable.SegmentedControl_segmentSelectedTextColor, ContextCompat.getColor(this.getContext(), R.color.md_white_1000));

//        pillPaddingTop = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillPaddingTop, getResources().getDimensionPixelOffset(R.dimen.default_pill_padding_top));
//        pillPaddingBottom = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillPaddingBottom, getResources().getDimensionPixelOffset(R.dimen.default_pill_padding_bottom));
//        pillPaddingLeft = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillPaddingLeft, getResources().getDimensionPixelOffset(R.dimen.default_pill_padding_left));
//        pillPaddingRight = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillPaddingRight, getResources().getDimensionPixelOffset(R.dimen.default_pill_padding_right));
//        closeIconMarginLeft = a.getDimensionPixelSize(
//                R.styleable.SegmentedControl_pillCloseIconMarginLeft, getResources().getDimensionPixelOffset(R.dimen.default_close_icon_margin_left));

        selectionMode = a.getInteger(R.styleable.SegmentedControl_segmentSelectionMode, DEFAULT_MODE_MULTI_SELECTION);

        a.recycle();
    }

    public int getSegmentSelectedIndex() {
        for (int i = 0; i < objectList.size(); i++) {
            if (((SegmentEntity) objectList.get(i)).isPressed()) {
                return i;
            }
        }
        return -1;
    }

    public void addList(List<Object> objectList) {
        this.objectList = objectList;
    }

    public void notifyDataSetChanged() {
        if (parentWidth != 0) {
            if (objectList.size() == 1) {
                Log.e("Error SegmentControl", "You need at least one or more segments");
            } else {
                removeAllViews();
                for (int i = 0; i < objectList.size(); i++) {
                    sizeItem = parentWidth / objectList.size();
                    if (i < maxPills) {
                        Button button = setupSegmentChildView(i,
                                ((SegmentEntity) objectList.get(i)).getMessage(),
                                ((SegmentEntity) objectList.get(i)).isPressed());
                        addView(button);
                        button.setTag(i);
                    }
                }
            }
        }
    }

    private Button setupSegmentChildView(int position, String message, boolean isSelected) {
        final Button button = (Button) LayoutInflater.from(getContext()).inflate(R.layout.segment, this, false);
        button.setText(message);
        button.setWidth(sizeItem);

        if (isSelected) {
            button.setTextColor(segmentSelectedTextColor);
        } else {
            button.setTextColor(segmentTextColor);
        }

        if (position == 0) {
            if (isSelected) {
                button.setBackgroundResource(segmentCheckedBackgroundStart);
            } else {
                button.setBackgroundResource(segmentSelectorStart);
            }
        } else if (position == (objectList.size() - 1)) {
            if (isSelected) {
                button.setBackgroundResource(segmentCheckedBackgroundEnd);
            } else {
                button.setBackgroundResource(segmentSelectorEnd);
            }
        } else {
            if (isSelected) {
                button.setBackgroundResource(segmentCheckedBackgroundCenter);
            } else {
                button.setBackgroundResource(segmentSelectorCenter);
            }
        }
        button.setOnClickListener(this);
        return button;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        if (onlyFirstTime) {
            notifyDataSetChanged();
            onlyFirstTime = false;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {//onClick button child
            //view.getTag() returns the button child position
            int pillPosition = (int) (view.getTag());
            for (int i = 0; i < objectList.size(); i++) {
                ((SegmentEntity) objectList.get(i)).setPressed(false);
            }

            SegmentEntity segmentEntity = (SegmentEntity) objectList.get(pillPosition);
            segmentEntity.setPressed(true);

            notifyDataSetChanged();

            if (onSegmentClickListener != null) {
                onSegmentClickListener.onSegmentClick(this, pillPosition);
            }
        }
    }

    public interface OnSegmentClickListener {
        void onSegmentClick(View view, int position);
    }

}
