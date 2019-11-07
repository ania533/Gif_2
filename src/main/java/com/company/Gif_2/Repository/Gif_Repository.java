package com.company.Gif_2.Repository;

import com.company.Gif_2.Model.Gif;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@ToString
@Getter
@Repository
public class Gif_Repository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", false,0),
            new Gif("ben-and-mike", "mika", true,1),
            new Gif("book-dominos", "mem", false,2),
            new Gif("compiler-bot", "bot", true,2),
            new Gif("cowboy-coder", "code", false,1),
            new Gif("infinite-andrew", "andrew", true,2)
    );

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }
// Repository - warstwa odpowiedzialna za dane
    public  List<Gif> getFavoritesGifs() {
        List<Gif> allGifs = getAllGifs();
        List<Gif> favorites = new ArrayList<>();
        for (Gif x : allGifs) {
            if (x.getFavorite().equals(true)) {
                favorites.add(x);
            }
        }
        return favorites;
    }
    public Gif getGifsByName(String name){
    List<Gif> listGif = getAllGifs();
        for ( Gif y: listGif) {
            if (y.getName().equals(name)){
                return y;
            }
        }
        return null;
    }
    public static List<Gif> getGifsByCategoryId( Integer id){
        List<Gif> listGifs = getAllGifs();
        List<Gif> categoryList = new ArrayList<>();
        for( Gif x : listGifs){
            if (x.getCategoryId().equals(id)){
        categoryList.add(x);
            }
        }
        return categoryList;
    }
}


