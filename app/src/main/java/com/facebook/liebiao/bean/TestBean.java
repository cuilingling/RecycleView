package com.facebook.liebiao.bean;

/**
 * 作者：zhaoyang on 2017/9/27 22:25
 */

public class TestBean{
    private String name;
    private boolean isSelected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public TestBean(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }


}
