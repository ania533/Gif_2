package com.company.Gif_2.Repository;

import com.company.Gif_2.Model.Category;
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
}

