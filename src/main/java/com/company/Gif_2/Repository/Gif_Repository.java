package com.company.Gif_2.Repository;

import com.company.Gif_2.Model.Gif;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@ToString
@Getter
@Repository
public class Gif_Repository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
           new Gif("android-explosion", "mols", false),
           new Gif("ben-and-mike", "mika", true),
           new Gif("book-dominos", "mem", false),
           new Gif("compiler-bot", "bot", true),
           new Gif("cowboy-coder", "code", false),
           new Gif("infinite-andrew", "andrew", true)
    );

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }
}