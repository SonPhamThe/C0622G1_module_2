package demo_haitt.demo_exercise3.service.impl;

import demo_haitt.demo_exercise3.model.Oto;
import demo_haitt.demo_exercise3.model.PhuongTienGiaoThong;
import demo_haitt.demo_exercise3.model.XeMay;
import demo_haitt.demo_exercise3.model.XeTai;
import demo_haitt.demo_exercise3.service.IPhuongtien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhuongTienService implements IPhuongtien {
    Scanner scanner = new Scanner(System.in);

    public List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();
    public static List<Oto> otos = new ArrayList<>();
    public static List<XeMay> xeMays = new ArrayList<>();
    public static List<XeTai> xeTais = new ArrayList<>();

    @Override
    public void themMoiPhuongTien() {
        System.out.println("--------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng thêm mới phương tiện");
        System.out.println("Hãy thêm những thuộc tính chung của phương tiện");
        System.out.println("-------------------------------------------");
        PhuongTienGiaoThong phuongTienGiaoThong = this.thongTinPhuongTien();
        phuongTienGiaoThongs.add(phuongTienGiaoThong);
        if (phuongTienGiaoThong instanceof Oto) {
            otos.add((Oto) phuongTienGiaoThong);
        }
        if (phuongTienGiaoThong instanceof XeMay) {
            xeMays.add((XeMay) phuongTienGiaoThong);
        }
        if (phuongTienGiaoThong instanceof XeTai) {
            xeTais.add((XeTai) phuongTienGiaoThong);
        }
        System.out.println("Bạn đã thêm thành công");
    }

    @Override
    public void hienThiOto() {
        for (Oto oto : otos) {
            System.out.println(oto);
        }
    }

    @Override
    public void hienThiXeTai() {
        for (XeTai xeTai : xeTais) {
            System.out.println(xeTai);
        }
    }

    @Override
    public void hienThiXeMay() {
        for (XeMay xeMay : xeMays) {
            System.out.println(xeMay);
        }
    }

    @Override
    public void hienThiAll() {
        for (PhuongTienGiaoThong phuongTienGiaoThong : phuongTienGiaoThongs) {
            System.out.println(phuongTienGiaoThong);
        }
    }

    @Override
    public void xoaPhuongTien() {
        System.out.println("--------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng Xóa");
        System.out.println("Hãy nhập vào biển kiểm soát cần xóa");
        String bienKiemSoat = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < phuongTienGiaoThongs.size(); i++) {
            if (phuongTienGiaoThongs.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                if (phuongTienGiaoThongs.get(i) instanceof Oto) {
                    otos.remove(phuongTienGiaoThongs.get(i));
                }
                if (phuongTienGiaoThongs.get(i) instanceof XeMay) {
                    xeMays.remove(phuongTienGiaoThongs.get(i));
                }
                if (phuongTienGiaoThongs.get(i) instanceof XeTai) {
                    xeTais.remove(phuongTienGiaoThongs.get(i));
                }
                System.out.println("Bạn chắc chắn xóa biển kiếm soát " + phuongTienGiaoThongs.get(i).getBienKiemSoat() + " không?");
                System.out.println("1.  Có");
                System.out.println("2. Không");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    phuongTienGiaoThongs.remove(phuongTienGiaoThongs.get(i));
                    System.out.println("Đã xóa thành công");
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == 0) {
            System.out.println("Biển kiểm soát không tồn tại");
        }
    }

    @Override
    public void timKiemPhuongTien() {
        System.out.println("--------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng Tìm Kiếm");
        System.out.println("Hãy nhập vào biển kiểm soát cần tìm");
        String bienKiemSoat = scanner.nextLine();
        int count = 0;
        for (PhuongTienGiaoThong phuongTienGiaoThong : phuongTienGiaoThongs) {
            if (phuongTienGiaoThong.getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                System.out.println(phuongTienGiaoThong.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có phương tiện nào được tìm thấy");
        }
    }

    private PhuongTienGiaoThong thongTinPhuongTien() {
        System.out.println("Mời bạn nhập vào biển kiểm soát");
        String bienKiemSoat = scanner.nextLine();
        System.out.println(" Mời bạn nhập vào mã sản xuất");
        int maSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Mời bạn nhập vào hãng sản xuất");
        String tenHangSanXuat = scanner.nextLine();
        System.out.println(" Mời bạn nhập vào quốc gia sản xuất");
        String quocGiaSanXuat = scanner.nextLine();
        System.out.println("Mời bạn nhập vào năm sản xuất");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào chủ sở hữu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Bạn muốn chọn loại xe :");
        System.out.println("1. Oto");
        System.out.println("2. Xe Tải");
        System.out.println("3.Xe Máy");
        System.out.println("4.Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Mời bạn nhập kiểu xe của oto");
                String kieuXe = scanner.nextLine();
                System.out.println("Mời bạn nhập số chỗ ngồi cho xe oto");
                int soChoNgoi = Integer.parseInt(scanner.nextLine());
                return new Oto(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe);
            case 2:
                System.out.println("Mời bạn nhập tải trọng cho xe tải");
                double taiTrong = Double.parseDouble(scanner.nextLine());
                return new XeTai(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, taiTrong);
            case 3:
                System.out.println("Mời bạn nhập công suất cho xe máy");
                double congSuat = Double.parseDouble(scanner.nextLine());
                return new XeMay(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, congSuat);
            case 4:
                System.exit(0);
        }
        return null;
    }
}

