package case_study.service.utils.readfile;

import case_study.model.furama_resort.VillaFurama;

import java.util.ArrayList;
import java.util.List;

public class ReadFileVilla {
    //    (String nameService, double usableArea, double rentalCost, int maxNumberOfPeople, String rentalType, String roomStandard, double swimmingOfArea, int numberOfFloors
    public static List<VillaFurama> readVillaFile(String path) {
        List<String> strings = ReadFile.readFile(path);
        List<VillaFurama> villas = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            villas.add(new VillaFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), info[4], info[5], Double.parseDouble(info[6]), Integer.parseInt(info[7])));
        }
        return villas;
    }
}
