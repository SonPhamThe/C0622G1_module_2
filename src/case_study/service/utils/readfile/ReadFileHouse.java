package case_study.service.utils.readfile;

import case_study.model.furama_resort.HouseFurama;


import java.util.ArrayList;
import java.util.List;

public class ReadFileHouse {
    public static List<HouseFurama> readHouseFile(String path) {
        List<String> strings = ReadFile.readFile(path);
        List<HouseFurama> houses = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            houses.add(new HouseFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), info[4], info[5], Integer.parseInt(info[6])));
        }
        return houses;
    }
}
