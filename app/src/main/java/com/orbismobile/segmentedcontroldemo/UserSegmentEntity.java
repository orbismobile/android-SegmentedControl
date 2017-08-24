package com.orbismobile.segmentedcontroldemo;

import com.orbismobile.segmentedcontrol.SegmentEntity;

/**
 * Created by carlosleonardocamilovargashuaman on 8/24/17.
 */

public class UserSegmentEntity extends SegmentEntity{

    private int id;
    private String name;
    private String slug;

    public UserSegmentEntity(int id, String name, boolean pressed, String slug) {
        super(name, pressed);
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
