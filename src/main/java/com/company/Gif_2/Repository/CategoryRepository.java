package com.company.Gif_2.Repository;

import com.company.Gif_2.Model.Category;
import com.company.Gif_2.Model.Gif;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0,"funny"),
            new Category(1,"sport"),
            new Category(2,"it")
    );

    public static List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
    // Metoda szukająca kategory po id
    public Category getCategoryById(Integer id){
        for (Category c : ALL_CATEGORIES){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
}


