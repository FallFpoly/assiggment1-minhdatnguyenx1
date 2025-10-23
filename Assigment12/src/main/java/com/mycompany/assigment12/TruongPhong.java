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
public class TruongPhong extends NhanVien {
    private double trachNhiem;

    public TruongPhong() {}

    public TruongPhong(String maNV, String hoTen, double luong, double trachNhiem) {
        super(maNV, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap luong trach nhiem: ");
        trachNhiem = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double getThuNhap() {
        return luong + trachNhiem;
    }
}
