package com.jjt.friendslist.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public static void createFile(String name){
        try{
            File file = new File(name);
            if(file.createNewFile()){
                System.out.println("Successfully created file '"+name+"'");
            }else{
                System.out.println("This file already exists! Ignoring...");
            }
        }catch(IOException e){
            System.out.println("An error occurred whilst creating file '"+name+"'");
            e.printStackTrace();
        }
    }
    public static void writeFile(String name, String text){
        try{
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Successfully wrote to file '"+name+"'");
        }catch(IOException e){
            System.out.println("An error occurred whilst writing to file '"+name+"'");
            e.printStackTrace();
        }
    }
    public static void deleteFile(String name){
        File file = new File(name);
        if(file.delete()){
            System.out.println("Successfully deleted file '"+name+"'");
        }else{
            System.out.println("An error occurred whilst deleting file '"+name+"' : This file doesn't exist!");
        }
    }
    public static ArrayList<String> readFile(String name){
        ArrayList<String> list = new ArrayList<>();
        try{
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                list.add(data);
            }
            scanner.close();
            return list;
        }catch(FileNotFoundException e){
            System.out.println("An error occurred whilst reading file '"+name+"' : This file doesn't exist!");
            e.printStackTrace();
        }
        list.add("An error occurred!");
        return list;
    }
}
