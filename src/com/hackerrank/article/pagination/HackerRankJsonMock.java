package com.hackerrank.article.pagination;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HackerRankJsonMock {

    public static void main(String[] args) throws IOException {
        System.out.println(getUsernames(10));
    }

    public static List<String> getUsernames(int threshold) throws IOException {


        List<String> result = new ArrayList<>();
        // 1. JSON file to Java object
        try (InputStream is = new URL("https://jsonmock.hackerrank.com/api/article_users?page=1").openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            RootArticle root = gson.fromJson(reader, RootArticle.class);

            List<DataArticle> titles = new ArrayList<>();
            for(int i =1; i <= root.total_pages; i++){
                root = getArticleFromPage(i);

                titles.addAll(root.data);


            }

            for(DataArticle data : titles){
                if(data.submission_count > threshold){
                    result.add(data.username);
                }
            }

            // System.out.println(root);
        }

        return result;

    }

    public static RootArticle getArticleFromPage(int pageNum) throws IOException {
        try (InputStream is = new URL("https://jsonmock.hackerrank.com/api/article_users?page="+pageNum).openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            return gson.fromJson(reader, RootArticle.class);
        }

    }

}


 class DataArticle{
    public int id;
    public String username;
    public String about;
    public int submitted;
    public Date updated_at;
    public int submission_count;
    public int comment_count;
    public int created_at;
}

 class RootArticle{
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<DataArticle> data;
}