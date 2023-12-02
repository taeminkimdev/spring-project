package com.project.demo.wishlist.dto;

public class ResponseIsExist {
    private boolean isExist;

    public ResponseIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean getIsExist() { return this.isExist; }
}
