package com.company.Gif_2.Controller;

import com.company.Gif_2.Model.Category;
import com.company.Gif_2.Model.Gif;
import com.company.Gif_2.Repository.CategoryRepository;
import com.company.Gif_2.Repository.Gif_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.company.Gif_2.Repository.CategoryRepository.getAllCategories;

@Controller
public class Category_Controller {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
Gif_Repository gif_Repository;
    @GetMapping("/categories")
    // Zwraca obiekty z kategorii i widok
    public String gifCategories(ModelMap modelMap) {
        // 1. Wyciąganie kategori
        List<Category> categoriesList  = categoryRepository.getAllCategories();

        // Powyżej wstrzyknięto zależność z Category_Repository do Category_Controller
        // 2. Przekazanie kategorii  do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
        modelMap.put("categories", categoriesList);
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String idCategories(@PathVariable Integer id, ModelMap modelMap) {
        //  Przypisanie konkretnych gifów do kategorii
 // 1. Wyciąganie kategori
        // - pobieramy listę gifów należąca do danej kategorii
        List<Gif> listGif =gif_Repository.getGifsByCategoryId(id);
// 2. Przekazanie kategorii  do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
        modelMap.put("gifs", listGif);
       Category category = categoryRepository.getCategoryById(id);
        modelMap.put("category", category);
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "category";

    }
}
