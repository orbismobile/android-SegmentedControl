<h1 align="center">SegmentedControlRadioButton Widget</h1>

<p align="center">
    <a target="_blank" href="https://jitpack.io/#orbismobile/android-MaterialPills"><img src="https://jitpack.io/v/orbismobile/android-MaterialPills.svg"></a>
</p>

<p align="center">
    <img src="Screenshots/ic_launcher_radiobutton-web.png" alt="icon" width="25%"/>
</p>

<p align="center">
    <img src="Screenshots/Screenshot1.png" alt="icon" width="22%"/>
   
</p>

MaterialPillsBox is a widget that allows you to implement a list of any objects
and show them like a pills with a little material style.

# Gradle
#### Step 1

```
android {
 ...
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
}
```
#### Step 2

```
    dependencies {
        ...
        compile 'com.github.orbismobile:android-MaterialPills:1.0.1'
    }
```

# Usage

```xml
<RadioGroup
        android:id="@+id/rgSelection"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <com.orbismobile.segmentedcontrol.SegmentedControlRadioButton
            android:id="@+id/opt_1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checked="true"
            android:text="@string/first"
            app:segmentTextColor="@color/md_blue_500"
            app:segmentCheckedTextColor="@color/md_white_1000"
            app:segmentBackground="@drawable/selector_segmented_control_start"
            style="@style/SegmentedControlButton"/>

        <com.orbismobile.segmentedcontrol.SegmentedControlRadioButton
            android:id="@+id/opt_2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/second"
            app:segmentTextColor="@color/md_blue_500"
            app:segmentCheckedTextColor="@color/md_white_1000"
            app:segmentBackground="@drawable/selector_segmented_control_center"
            style="@style/SegmentedControlButton"/>

        <com.orbismobile.segmentedcontrol.SegmentedControlRadioButton
            android:id="@+id/opt_3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/third"
            app:segmentTextColor="@color/md_blue_500"
            app:segmentCheckedTextColor="@color/md_white_1000"
            app:segmentBackground="@drawable/selector_segmented_control_end"
            style="@style/SegmentedControlButton"/>
    </RadioGroup>
```



# Setup
For using the SegmentedControlRadioButon widget in your Activity, just implement it inside a RadioGroup widget xml layout

# Main Properties

##### segmentTextColor
    The unchecked text color for the radio button
##### segmentCheckedTextColor
    The checked text color for the radio button
##### segmentBackground
    The shape drawable for the radio button

License
=======

    MIT License
    
    Copyright (c) 2017 Orbis Mobile
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

















