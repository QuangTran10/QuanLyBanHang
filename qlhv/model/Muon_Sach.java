/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.model;

import java.sql.Date;


/**
 *
 * @author MyPC
 */
public class  Muon_Sach{
    private String ma_muon;
    private String ma_sach;
    private String ma_so;
    private Date ngay_muon;
    private Date ngay_tra_max;
    private Date ngay_tra;

    public Muon_Sach() {
    }

    public Muon_Sach(String ma_muon, String ma_sach, String ma_so, Date ngay_muon, Date ngay_tra_max, Date ngay_tra) {
        this.ma_muon = ma_muon;
        this.ma_sach = ma_sach;
        this.ma_so = ma_so;
        this.ngay_muon = ngay_muon;
        this.ngay_tra_max = ngay_tra_max;
        this.ngay_tra = ngay_tra;
    }

    public String getMa_muon() {
        return ma_muon;
    }

    public void setMa_muon(String ma_muon) {
        this.ma_muon = ma_muon;
    }

    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getMa_so() {
        return ma_so;
    }

    public void setMa_so(String ma_so) {
        this.ma_so = ma_so;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_tra_max() {
        return ngay_tra_max;
    }

    public void setNgay_tra_max(Date ngay_tra_max) {
        this.ngay_tra_max = ngay_tra_max;
    }

    public Date getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(Date ngay_tra) {
        this.ngay_tra = ngay_tra;
    }
    
}
