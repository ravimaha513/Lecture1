package com.hackerrank.article.pagination;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionHacker {

    /*
     * Complete the 'getArticleTitles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/articles?author=<authorName>&page=<num>
     *
     */

    public static void main(String[] args) throws IOException {
        System.out.println(getArticleTitles("coloneltcb"));
    }

    public static List<String> getArticleTitles(String author) throws IOException {

        List<String> result = new ArrayList<>();
        // 1. JSON file to Java object
        try (InputStream is = new URL("https://jsonmock.hackerrank.com/api/articles?author="+author).openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            Root root = gson.fromJson(reader, Root.class);

            List<Datum> titles = new ArrayList<>();
            for(int i =1; i <= root.total_pages; i++){
                root = getRootElement(author, i);

                titles.addAll(root.data);


            }

            for(Datum data : titles){
                if(data.title != null){
                    result.add(data.title);
                }else if(data.story_title != null){
                    result.add(data.story_title);
                }

            }

           // System.out.println(root);
        }

        return result;

    }

    public static Root getRootElement(String author, int pageNumber) throws IOException {
        InputStream is = new URL("https://jsonmock.hackerrank.com/api/articles?author="+author+"&page="+pageNumber).openStream();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);


        Gson gson = new Gson();
        Root root = gson.fromJson(reader, Root.class);

        return root;

    }
}

 class Datum{
    public String title;
    public String url;
    public String author;
    public int num_comments;
    public String story_id;
    public String story_title;
    public String story_url;
    public String parent_id;
    public int created_at;
}

 class Root{
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum> data;
}


