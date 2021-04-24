package com.uysals.game.warofages.desktop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.objects.Floor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class CreateDefaultMap {

    public static int floorCount = 19;
    public static int rowCount = 11; // always odd number
    public static int columnCount = 11; // always odd number

    public static ArrayList<Floor> floors = new ArrayList<Floor>();
    public static Random random = new Random();

    public static void main(String[] args) {
        float xCoor;
        float yCoor;
        int disable;
        int region;
        // rowCount / 2 + 1 = HEIGHT / 2 = 540f;
        // columnCount / 2 + 1 = WIDTH / 2 = 960f;
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < rowCount; j++) {
                xCoor = ((j - (columnCount / 2 )) * 198f);
                if(i % 2 == 0)
                    xCoor -= 100f;
                yCoor = - ((i - (rowCount / 2)) * 180f);
                if(i == (rowCount / 2) && j == (columnCount / 2)) {
                    region = 0;
                } else {
                    region = random.nextInt(floorCount) + 1;
                }
                if(i >= rowCount / 2 - 2 && i <= rowCount / 2 + 2 && j >= columnCount / 2 - 2 && j < columnCount / 2 + 2) {
                    if(i >= rowCount / 2 - 1  && i <= rowCount / 2 + 1 && j >= columnCount / 2 - 1 && j < columnCount / 2 + 1) {
                        disable = 0;
                    } else {
                        disable = 1;
                    }
                } else {
                    disable = 2;
                }

                floors.add(new Floor(xCoor,yCoor,disable,region));
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("defaultMap.json")));
            writer.write(gson.toJson(floors));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
