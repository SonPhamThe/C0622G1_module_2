package case_study.service.utils.readfile;

import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;

import java.util.ArrayList;
import java.util.List;

public class ReadFileRoom {
    public static List<RoomFurama> readRoomFile(String path) {
        List<String> strings = ReadFile.readFile(path);
        List<RoomFurama> rooms = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            rooms.add(new RoomFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), info[4], info[5]));
        }
        return rooms;
    }
}
