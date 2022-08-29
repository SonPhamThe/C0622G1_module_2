package case_study.service.utils.writefile;

import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.VillaFurama;
import demo_haitt.demo_exercise1.service.util.write_readfile.WriteFIle;

import java.io.IOException;
import java.util.List;

public class WriteFileHouse {
    public static void writeHouseFile(String path, List<HouseFurama> houses) throws IOException {
        String data = "";
        for (HouseFurama house : houses) {
            data += house.toString() + "\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
