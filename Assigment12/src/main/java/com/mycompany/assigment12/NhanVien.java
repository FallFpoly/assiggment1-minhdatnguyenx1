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
public class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected double luong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        luong = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("Ma NV: %s - Ho ten: %s - Luong: %.2f - Thu nhap: %.2f - Thue TN: %.2f\n",
                maNV, hoTen, luong, getThuNhap(), getThueTN());
    }

    public double getThuNhap() {
        return luong;
    }

    public double getThueTN() {
        double tn = getThuNhap();
        if (tn < 9000000)
            return 0;
        else if (tn <= 15000000)
            return tn * 0.1;
        else
            return tn * 0.12;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public String getMaNV() {
        return maNV;
    }
}
