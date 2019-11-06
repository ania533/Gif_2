package com.company.Gif_2.Controller;

import com.company.Gif_2.Model.Category;
import com.company.Gif_2.Model.Gif;
import com.company.Gif_2.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.company.Gif_2.Repository.CategoryRepository.getAllCategories;

@Controller
public class Category_Controller {
@Autowired
CategoryRepository categoryRepository;
    @GetMapping("/categories")
    // Zwraca obiekty z kategorii i widok
    public String gifCategories(ModelMap modelMap){
        // 1. Wyciąganie kategori
        List<Category> categoryList = categoryRepository.getAllCategories();

        // Powyżej wstrzyknęliśmy zależność z Category_Repository do Category_Controller
        // 2. Przekazanie kategorii  do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
        modelMap.put("categories", categoryList );
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "categories";
    }
    //  Przypisanie konkretnych gifów do kategorii 

}
