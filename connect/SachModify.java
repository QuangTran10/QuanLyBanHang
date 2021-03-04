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
import qlhv.model.Sach;

/**
 *
 * @author MyPC
 */
public class SachModify {

    //Hiá»ƒn thá»‹ táº¥t cáº£ cĂ¡c sĂ¡ch
    public static List<Sach> findAll() {
        List<Sach> listSach = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from sach";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Sach std = new Sach(resultSet.getString("ma_sach"), resultSet.getNString("ten_sach"), resultSet.getLong("nam_xuat_ban"), resultSet.getNString("nha_xuat_ban"));
                listSach.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return listSach;
    }

    public static void insert(Sach s) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "insert into sach(ma_sach,ten_sach,nam_xuat_ban,nha_xuat_ban) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, s.getMa_sach());
            statement.setNString(2, s.getTen_sach());
            statement.setLong(3, s.getNam_xuat_ban());
            statement.setNString(4, s.getNha_xuat_ban());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Sach s) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "update sach set ma_sach=?,ten_sach=?,nam_xuat_ban=?,nha_xuat_ban=? where ma_sach = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, s.getMa_sach());
            statement.setNString(2, s.getTen_sach());
            statement.setLong(3, s.getNam_xuat_ban());
            statement.setNString(4, s.getNha_xuat_ban());
            statement.setString(5, s.getMa_sach());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(String masach) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "delete from sach where ma_sach = ?";
            statement = connection.prepareCall(sql);

            statement.setNString(1, masach);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<Sach> findByMaSach(String ma_sach) {
        List<Sach> sachList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from sach where ma_sach =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ma_sach);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Sach std = new Sach(resultSet.getString("ma_sach"), resultSet.getNString("ten_sach"), resultSet.getLong("nam_xuat_ban"), resultSet.getNString("nha_xuat_ban"));
                sachList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return sachList;
    }
    
    public static Sach findByTenSach(String ten) {
        Sach list = new Sach();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from sach where ten_sach =?";
            statement = connection.prepareCall(sql);
            statement.setNString(1, ten);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list = new Sach(resultSet.getString("ma_sach"), resultSet.getNString("ten_sach"), resultSet.getLong("nam_xuat_ban"), resultSet.getNString("nha_xuat_ban"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return list;
    }
    
    public static String find(String ma_sach) {
        String kq=null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select ten_sach from sach where ma_sach =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ma_sach);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                kq =resultSet.getNString("ten_sach");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return kq;
    }
    
    public static int tongSach() {
        int kq=0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select count(*) so_luong from sach ";
            statement = connection.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                kq =resultSet.getInt("so_luong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return kq;
    }
    
}

