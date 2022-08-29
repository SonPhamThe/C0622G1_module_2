package case_study.service.utils.writefile;

import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;
import demo_haitt.demo_exercise1.service.util.write_readfile.WriteFIle;

import java.io.IOException;
import java.util.List;

public class WriteFileRoom {
    public static void writeRoomFile(String path, List<RoomFurama> rooms) throws IOException {
        String data = "";
        for (RoomFurama room : rooms) {
            data += room.toString() + "\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
