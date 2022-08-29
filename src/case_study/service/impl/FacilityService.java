package case_study.service.impl;

import case_study.model.employee.Employee;
import case_study.model.furama_resort.Facility;
import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;
import case_study.model.furama_resort.VillaFurama;
import case_study.service.IFacility;
import case_study.service.exception.CheckException;
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

    private static List<VillaFurama> villas = new ArrayList<>();

    private static List<RoomFurama> rooms = new ArrayList<>();

    private static List<HouseFurama> houses = new ArrayList<>();

    private static final Map<Facility, Integer> facility = new LinkedHashMap<>();

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
                    villas = ReadFileVilla.readVillaFile(PATH_VILLA);
                    VillaFurama villa = VillaService.getVilla();
                    villas.add(villa);
                    check = true;
                    facility.put(villa, 0);
                    System.out.println("Success add");
                    WriteFileVilla.writeVillaFile(PATH_VILLA, villas);
                    break;
                case 2:
                    houses = ReadFileHouse.readHouseFile(PATH_HOUSE);
                    HouseFurama house = HouseService.getHouse();
                    houses.add(house);
                    System.out.println("Success add");
                    facility.put(house, 0);
                    check = true;
                    WriteFileHouse.writeHouseFile(PATH_HOUSE, houses);
                    break;
                case 3:
                    rooms = ReadFileRoom.readRoomFile(PATH_ROOM);
                    RoomFurama room = RoomService.getRoom();
                    rooms.add(room);
                    System.out.println("Success add");
                    facility.put(room, 0);
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
        while (true) {
            System.out.println("Please choice to display" +
                    "\n 1. Display New Villa" +
                    "\n 2. Display New House" +
                    "\n 3. Display New Room" +
                    "\n 4. Back to menu");
            int choose = Integer.parseInt(scan.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    if (villas.size() == 0) {
                        System.out.println("List the villa is empty");
                    }
                    for (VillaFurama villa : villas) {
                        System.out.println(villa.toString());
                    }
                    check = true;
                    break;
                case 2:
                    if (houses.size() == 0) {
                        System.out.println("List the house is empty");
                    }
                    for (HouseFurama house : houses) {
                        System.out.println(house.toString());
                    }
                    check = true;
                    break;
                case 3:
                    if (rooms.size() == 0) {
                        System.out.println("List the room is empty");
                    }
                    for (RoomFurama room : rooms) {
                        System.out.println(room.toString());
                    }
                    check = true;
                    break;
                case 4:
                    displayFacility();
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 4");
                    check = true;
                    break;
            }
            if (check) {
                break;
            }
        }
    }

}
