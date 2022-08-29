package case_study.service.utils.writefile;

import case_study.model.employee.Employee;
import case_study.model.furama_resort.VillaFurama;
import demo_haitt.demo_exercise1.service.util.write_readfile.WriteFIle;

import java.io.IOException;
import java.util.List;

public class WriteFileVilla {
    public static void writeVillaFile(String path, List<VillaFurama> villas) throws IOException {
        String data = "";
        for (VillaFurama villa : villas) {
            data += villa.toString() + "\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
