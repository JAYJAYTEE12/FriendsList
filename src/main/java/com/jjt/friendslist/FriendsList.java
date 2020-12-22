package com.jjt.friendslist;

import com.jjt.friendslist.managers.FileManager;
import com.jjt.friendslist.utils.StringUtils;

import java.util.ArrayList;

public class FriendsList {
    public static void main(String[] args){
        System.out.println("Loading files...");
        FileManager.createFile("version.txt");
        FileManager.writeFile("version.txt", "BETA 0.0.1v");

        System.out.println(" ");
        System.out.println(StringUtils.seperator());
        System.out.println(StringUtils.center("Welcome to FriendsList"));

        ArrayList<String> vFile = FileManager.readFile("version.txt");
        for(String item : vFile){
            System.out.println(StringUtils.center(item));
        }

        System.out.println(StringUtils.seperator());
    }
}
