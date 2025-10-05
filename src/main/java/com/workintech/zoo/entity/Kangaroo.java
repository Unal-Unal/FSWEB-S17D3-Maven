package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {
    private int id;
    private String name;
    private double height;
    private double weight;
    private String gender;
    private boolean isAggressive;

    public void setIsAggressive(boolean b) {

    }

    public boolean getIsAggressive() {
        return true;
    }
}
