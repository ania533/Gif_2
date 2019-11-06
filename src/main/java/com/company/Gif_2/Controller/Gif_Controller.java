package com.company.Gif_2.Controller;


import com.company.Gif_2.Model.Gif;
import com.company.Gif_2.Repository.Gif_Repository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.company.Gif_2.Repository.Gif_Repository.getAllGifs;

@Controller
@Getter
public class Gif_Controller {
    @Autowired
    Gif_Repository gif_Repository;

    @GetMapping("/")
    public String listGifsHome(ModelMap modelMap) {
 // 1. Wyciąganie gifów
        //   List<Gif> gifList = getAllGifs(); - rozwiązanie Javowe
        List<Gif> gifList = gif_Repository.getAllGifs();
    // Powyżej wstrzyknęliśmy zależność z Gif_Repository do Gif_Controller
 // 2. Przekazanie gifa do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
    modelMap.put("gifs",gifList);
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "home";
    }
    @GetMapping("/favorites")
    public String listGifsFavorites(ModelMap modelMap) {
     // 1. Wyciąganie gifów
        //   List<Gif> gifList = getAllGifs(); - rozwiązanie Javowe
        List<Gif> gifList = gif_Repository.getFavoritesGifs();
        // Powyżej wstrzyknęliśmy zależność z Gif_Repository do Gif_Controller
        // 2. Przekazanie gifa do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
        modelMap.put("gifs",gifList);
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "favorites";
    }
    // @PatVariable - służy by wyodrębnić dowolną wartość osadzoną w samym adresie URL
    // Pobieranie danych z url {} {nazwa zmiennej}
    @GetMapping("/gif/{name}")
    // Zamienienie zmiennej {name } na zmiennej Javową
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        // 1. Wyciąganie gifów
        //   List<Gif> gifList = getAllGifs(); - rozwiązanie Javowe
       Gif gif  = gif_Repository.getGifsByName(name);
        // Powyżej wstrzyknęliśmy zależność z Gif_Repository do Gif_Controller
        // 2. Przekazanie gifa do View
        // klucz - nazwa obiektu w thymeleaf, a wartość obiekt z  backendowy
        modelMap.put("gif", gif);
        // Do przekazania gifa do View służą Mapy ( ModelMap) ,które przetrzymują klucz i wartość
// 3. Zwracanie widoku
        return "gif-details";
    }



}












// Metoda do wypisywanie wszystkich Gifów w przeglądarce
    // Metody statyczne - nie potrzebują obiektu więc wystarczy nazwa klasy
//@ResponseBody
//    @GetMapping("/")
//    public String listGifs() {
//    String doPodania = Gif_Repository.getAllGifs().toString();
//    return doPodania;
//    }
// Metoda do wypisywania ulubionych Gifów
//@ResponseBody
//    @GetMapping("/test")
//    public String listGifsFavorite() {
//    List<Gif> allGifs = getAllGifs();
//    List<Gif> favorites = new ArrayList<>();
//    for (Gif x : allGifs) {
//        if (x.getFavorite().equals(true)) {
//            favorites.add(x);
//        }
//    }
//    return favorites.toString();
//}
//
//    @ResponseBody
//    @GetMapping("/test1")
//    public String listGifsMika() {
//        List<Gif> allGifs = getAllGifs();
////        for (int i = 0; i < allGifs.size(); i++) {
////            if (allGifs.get(i).getUserName().equals("Mika")) {
////                return allGifs.get(i).toString();
////            }
////
////        }
////        return null;
////    }
//        for (Gif g : allGifs) {
//            if (g.getUserName().equals("mika")){
//               return g.toString();
//            }
//        }
//        return "null";
//    }

