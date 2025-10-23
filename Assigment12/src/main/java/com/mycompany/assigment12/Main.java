/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    static ArrayList<NhanVien> ds = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n========= MENU QUAN LY NHAN VIEN =========");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Tim nhan vien theo ma");
            System.out.println("4. Xoa nhan vien theo ma");
            System.out.println("5. Cap nhat thong tin nhan vien");
            System.out.println("6. Tim nhan vien theo khoang thu nhap");
            System.out.println("7. Sap xep nhan vien theo ho ten");
            System.out.println("8. Sap xep nhan vien theo thu nhap");
            System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> nhapDS();
                case 2 -> xuatDS();
                case 3 -> timTheoMa();
                case 4 -> xoaTheoMa();
                case 5 -> capNhatTheoMa();
                case 6 -> timTheoKhoang();
                case 7 -> sapXepTheoTen();
                case 8 -> sapXepTheoThuNhap();
                case 9 -> top5ThuNhap();
                case 0 -> System.out.println("Ket thuc chuong trinh.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    static void nhapDS() {
        while (true) {
            System.out.println("1. Nhan vien hanh chinh | 2. Tiep thi | 3. Truong phong | 0. Thoat");
            System.out.print("Chon loai nhan vien: ");
            int loai = Integer.parseInt(sc.nextLine());
            if (loai == 0) break;

            NhanVien nv;
            switch (loai) {
                case 1 -> nv = new NhanVien();
                case 2 -> nv = new TiepThi();
                case 3 -> nv = new TruongPhong();
                default -> {
                    System.out.println("Loai khong hop le!");
                    continue;
                }
            }
            nv.nhap(sc);
            ds.add(nv);
        }
    }

    static void xuatDS() {
        System.out.println("\n===== DANH SACH NHAN VIEN =====");
        ds.forEach(NhanVien::xuat);
    }

    static void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (NhanVien nv : ds)
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                nv.xuat();
                return;
            }
        System.out.println("Khong tim thay nhan vien!");
    }

    static void xoaTheoMa() {
        System.out.print("Nhap ma can xoa: ");
        String ma = sc.nextLine();
        ds.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
    }

    static void capNhatTheoMa() {
        System.out.print("Nhap ma can cap nhat: ");
        String ma = sc.nextLine();
        for (NhanVien nv : ds)
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                nv.nhap(sc);
                return;
            }
        System.out.println("Khong tim thay nhan vien!");
    }

    static void timTheoKhoang() {
        System.out.print("Nhap thu nhap min: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap thu nhap max: ");
        double max = Double.parseDouble(sc.nextLine());
        for (NhanVien nv : ds)
            if (nv.getThuNhap() >= min && nv.getThuNhap() <= max)
                nv.xuat();
    }

    static void sapXepTheoTen() {
        ds.sort(Comparator.comparing(NhanVien::getHoTen));
        System.out.println("Da sap xep theo ten!");
    }

    static void sapXepTheoThuNhap() {
        ds.sort((a, b) -> Double.compare(b.getThuNhap(), a.getThuNhap()));
        System.out.println("Da sap xep theo thu nhap!");
    }

    static void top5ThuNhap() {
        ds.stream()
                .sorted((a, b) -> Double.compare(b.getThuNhap(), a.getThuNhap()))
                .limit(5)
                .forEach(NhanVien::xuat);
    }
}