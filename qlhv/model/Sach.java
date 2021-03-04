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
public class Sach {
    private String ma_sach;
    private String ten_sach;
    private long nam_xuat_ban;
    private String nha_xuat_ban;

    public Sach() {
    }

    public Sach(String ma_sach, String ten_sach, long nam_xuat_ban, String nha_xuat_ban) {
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.nam_xuat_ban = nam_xuat_ban;
        this.nha_xuat_ban = nha_xuat_ban;
    }
    
    public Sach(Sach s){
        this.ma_sach = s.ma_sach;
        this.ten_sach = s.ten_sach;
        this.nam_xuat_ban = s.nam_xuat_ban;
        this.nha_xuat_ban = s.nha_xuat_ban;
    }
    
    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public long getNam_xuat_ban() {
        return nam_xuat_ban;
    }

    public void setNam_xuat_ban(long nam_xuat_ban) {
        this.nam_xuat_ban = nam_xuat_ban;
    }

    public String getNha_xuat_ban() {
        return nha_xuat_ban;
    }

    public void setNha_xuat_ban(String nha_xuat_ban) {
        this.nha_xuat_ban = nha_xuat_ban;
    }

    
    
}
