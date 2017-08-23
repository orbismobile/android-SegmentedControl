package com.orbismobile.segmentedcontrol;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 5/20/17.
 *
 */

public class SegmentEntity {

    private int id;
    private String message = "default";
    private boolean pressed = false;

    protected SegmentEntity() {
    }

    protected SegmentEntity(String message){
        this.message = message;
    }

    public SegmentEntity(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public SegmentEntity(String message, boolean pressed) {
        this.id = id;
        this.message = message;
        this.pressed = pressed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}
