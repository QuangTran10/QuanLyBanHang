/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.model;

/**
 *
 * @author MyPC
 */
public class Doc_Gia {
    private String ma_so;
    private String ho_ten;
    private String ngay_sinh;
    private boolean gioi_tinh;
    private String dia_chi;

    public Doc_Gia() {
    }
    
    public Doc_Gia(String ma_so, String ho_ten, String ngay_sinh, boolean gioi_tinh, String dia_chi) {
        this.ma_so = ma_so;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
    }
    

    public String getMa_so() {
        return ma_so;
    }

    public void setMa_so(String ma_so) {
        this.ma_so = ma_so;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }
}
