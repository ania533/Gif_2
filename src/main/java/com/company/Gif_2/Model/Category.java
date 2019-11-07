package com.company.Gif_2.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Integer id;
    private String name;

    public Category( Integer id, String name){
        this.id = id;
        this.name = name;
    }


}
