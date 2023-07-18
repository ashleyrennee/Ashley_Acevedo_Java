package com.company.chatterbook.model;
import com.company.chatterbook.model.ChatterPost;

import java.util.ArrayList;
import java.util.List;
public class User {
    public String name;
    public List<ChatterPost> chatterPosts = new ArrayList<>();

    //User constructor
    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<ChatterPost> getChatterPosts(){
        return chatterPosts;
    }
    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }



}
