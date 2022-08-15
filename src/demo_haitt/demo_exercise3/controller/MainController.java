package demo_haitt.demo_exercise3.controller;

import demo_haitt.demo_exercise3.service.IPhuongtien;
import demo_haitt.demo_exercise3.service.impl.PhuongTienService;

import java.util.Scanner;

public class MainController {
    public void quanLyAll() {
        Scanner scanner = new Scanner(System.in);
        IPhuongtien phuongTien = new PhuongTienService();
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với phần mềm quản lý phương tiện giao thông");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5.Thoát");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    phuongTien.themMoiPhuongTien();
                    break;
                case 2:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Chào mừng bạn đến với chức năng Hiển thị");
                    System.out.println("1. Hiển thị Oto");
                    System.out.println("2. Hiển thị xe tải");
                    System.out.println("3. Hiển thị xe máy");
                    System.out.println("4. Hiển thị toàn bộ phương tiện");
                    System.out.println("5. Thoát");
                    System.out.println("-------------------------------------------");
                    System.out.println("Bạn muốn hiển thị phương tiện: ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            phuongTien.hienThiOto();
                            break;
                        case 2:
                            phuongTien.hienThiXeTai();
                            break;
                        case 3:
                            phuongTien.hienThiXeMay();
                            break;
                        case 4:
                            phuongTien.hienThiAll();
                            break;
                        case 5:
                            return;
                    }
                    break;
                case 3:
                    phuongTien.xoaPhuongTien();
                    break;
                case 4:
                    phuongTien.timKiemPhuongTien();
                    break;
                case 5:
                    System.out.println("Cám ơn bạn đã sử dụng phần mềm");
                    System.exit(0);
            }
        }
    }
}
