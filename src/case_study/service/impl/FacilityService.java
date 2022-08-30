package case_study.service.impl;

import case_study.model.furama_resort.Facility;
import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;
import case_study.model.furama_resort.VillaFurama;
import case_study.service.IFacility;
import case_study.service.utils.readfile.ReadFileHouse;
import case_study.service.utils.readfile.ReadFileRoom;
import case_study.service.utils.readfile.ReadFileVilla;
import case_study.service.utils.writefile.WriteFileHouse;
import case_study.service.utils.writefile.WriteFileRoom;
import case_study.service.utils.writefile.WriteFileVilla;

import java.io.IOException;
import java.util.*;

public class FacilityService implements IFacility {
    private static final Scanner scan = new Scanner(System.in);

    private static final String PATH_VILLA = "src/case_study/data/villa.csv";

    private static final String PATH_HOUSE = "src/case_study/data/house.csv";

    private static final String PATH_ROOM = "src/case_study/data/room.csv";

    public static final Map<Facility, Integer> facilities = new LinkedHashMap<>();
    private static final Map<Facility, Integer> facilityMaintenance = new LinkedHashMap<>();

    @Override
    public void addFacility() throws IOException {
        while (true) {
            System.out.println("Please choice to add" +
                    "\n 1. Add New Villa" +
                    "\n 2. Add New House" +
                    "\n 3. Add New Room" +
                    "\n 4. Back to menu");
            int choose = Integer.parseInt(scan.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    List<VillaFurama> villas = ReadFileVilla.readVillaFile(PATH_VILLA);
                    VillaFurama villa = VillaService.getVilla();
                    villas.add(villa);
                    check = true;
                    facilities.put(villa, 0);
                    System.out.println("Success add");
                    WriteFileVilla.writeVillaFile(PATH_VILLA, villas);
                    break;
                case 2:
                    List<HouseFurama> houses = ReadFileHouse.readHouseFile(PATH_HOUSE);
                    HouseFurama house = HouseService.getHouse();
                    houses.add(house);
                    System.out.println("Success add");
                    facilities.put(house, 0);
                    check = true;
                    WriteFileHouse.writeHouseFile(PATH_HOUSE, houses);
                    break;
                case 3:
                    List<RoomFurama> rooms = ReadFileRoom.readRoomFile(PATH_ROOM);
                    RoomFurama room = RoomService.getRoom();
                    rooms.add(room);
                    System.out.println("Success add");
                    facilities.put(room, 0);
                    check = true;
                    WriteFileRoom.writeRoomFile(PATH_ROOM, rooms);
                    break;
                case 4:
                    addFacility();
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 4");
                    break;
            }
            if (check) {
                break;
            }
        }
    }

    @Override
    public void displayFacility() {
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            System.out.println(facility.toString() + "," + facilities.get(facility));
        }
    }

    @Override
    public void displayFacilityMaintenance() {
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) >= 5) {
                facilityMaintenance.put(facility, facilities.get(facility));
            }
        }
        for (Facility facility : facilityMaintenance.keySet()) {
            System.out.println(facility + "has been used: " + facilityMaintenance.get(facility) + "times");
        }
    }

    public Facility findFacilityId(String id) {
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            if (facility.getNameService().contains(id)) {
                return facility;
            }
        }
        return null;
    }
}
