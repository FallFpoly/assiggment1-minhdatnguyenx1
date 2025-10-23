/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class  TiepThi extends NhanVien{
    private double doanhSo;
    private double hueHong;

    public TiepThi() {}

    public TiepThi(String maNV, String hoTen, double luong, double doanhSo, double hueHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap doanh so ban hang: ");
        doanhSo = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap ti le hoa hong (%): ");
        hueHong = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double getThuNhap() {
        return luong + doanhSo * hueHong / 100;
    }
}
