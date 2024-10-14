package com.example.shoppingcarddemo.model.entity.rating;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum Rating {

    NO_RATING("NO_RATING", ""),
    ONE_STAR("ONE_STAR","*"),
    TWO_STAR("TWO_STAR","**"),
    THREE_STAR("THREE_STAR","***"),
    FOUR_STAR("FOUR_STAR","****"),
    FIVE_STAR("FIVE_STAR","*****");

    private String key;
    private String value;

    Rating(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
