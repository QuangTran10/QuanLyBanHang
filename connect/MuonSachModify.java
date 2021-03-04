/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.model.Doc_Gia;
import qlhv.model.Muon_Sach;

/**
 *
 * @author MyPC
 */
public class MuonSachModify {
    
    public static List<Muon_Sach> findAll() {
        List<Muon_Sach> listMuonsach = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from muon_sach";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Muon_Sach std = new Muon_Sach(resultSet.getString("ma_muon"),resultSet.getString("ma_sach"), resultSet.getString("ma_so"),
                        resultSet.getDate("ngay_muon"),resultSet.getDate("ngay_tra_max") ,resultSet.getDate("ngay_tra"));
                listMuonsach.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   //ket thuc.

        return listMuonsach;
    }
    
    public static void insert(Muon_Sach m) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "insert into muon_sach() values(? ,?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, m.getMa_muon());
            statement.setString(2, m.getMa_sach());
            statement.setString(3, m.getMa_so());
            statement.setDate(4, m.getNgay_muon());
            statement.setDate(5, m.getNgay_tra_max());
            statement.setDate(6, m.getNgay_tra());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Muon_Sach m) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "update muon_sach set ma_muon =? ,ma_sach =?, ma_so=?, ngay_muon=?, ngay_tra_max=? ,ngay_tra=? where ma_muon=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, m.getMa_muon());
            statement.setString(2, m.getMa_sach());
            statement.setString(3, m.getMa_so());
            statement.setDate(4, m.getNgay_muon());
            statement.setDate(5, m.getNgay_tra_max());
            statement.setDate(6, m.getNgay_tra());
            statement.setString(7, m.getMa_muon());
            

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(String mmuon) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "delete from muon_sach where ma_muon=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, mmuon);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<Muon_Sach> findByMaSo(String mmuon) {
        List<Muon_Sach> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from doc_gia where ma_muon =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, mmuon);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Muon_Sach std = new Muon_Sach(resultSet.getString("ma_muon"),resultSet.getString("ma_sach"), resultSet.getString("ma_so"),
                        resultSet.getDate("ngay_muon"),resultSet.getDate("ngay_tra_max") ,resultSet.getDate("ngay_tra"));
                list.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return list;
    }
    
    //Tá»•ng sá»‘ ngÆ°á»i mÆ°á»£n
    public static int tongNguoiMuon() {
        int kq=0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select  count(distinct ma_so) sl from muon_sach;";
            statement = connection.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                kq=resultSet.getInt("sl");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return kq;
    }
    
    //Tá»•ng sá»‘ phiáº¿u mÆ°á»£n
    public static int tongPhieu() {
        int kq=0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select  count(*) sl from muon_sach";
            statement = connection.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                kq=resultSet.getInt("sl");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return kq;
    }
    
    //Tá»•ng phiáº¿u quĂ¡ háº¡n
    public static int tongPhieuQuaHan() {
        int kq=0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select count(*) sl from muon_sach where ngay_tra > ngay_tra_max";
            statement = connection.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                kq=resultSet.getInt("sl");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return kq;
    }
}

