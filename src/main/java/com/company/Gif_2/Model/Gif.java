package com.company.Gif_2.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Gif  {
    private String name;
    private  String userName;
    private Boolean favorite;
    private Integer categoryId;

}
