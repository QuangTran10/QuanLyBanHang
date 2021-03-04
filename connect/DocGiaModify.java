/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.model.Doc_Gia;
import java.sql.PreparedStatement;

/**
 *
 * @author MyPC
 */
public class DocGiaModify {

    //Hiá»ƒn thá»‹ táº¥t cáº£ cĂ¡c Ä‘á»™c giáº£
    public static List<Doc_Gia> findAll() {
        List<Doc_Gia> listDocgia = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from doc_gia";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Doc_Gia std = new Doc_Gia(resultSet.getString("ma_so"), resultSet.getNString("ho_ten"),
                        resultSet.getString("ngay_sinh"), resultSet.getBoolean("gioi_tinh"), resultSet.getNString("dia_chi"));
                listDocgia.add(std);
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

        return listDocgia;
    }

    public static void insert(Doc_Gia d) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "insert into doc_gia() values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, d.getMa_so());
            statement.setNString(2, d.getHo_ten());
            statement.setString(3, d.getNgay_sinh());
            statement.setBoolean(4, d.isGioi_tinh());
            statement.setNString(5, d.getDia_chi());

            statement.execute();
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
    }

    public static void update(Doc_Gia d) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "update doc_gia set ma_so=?, ho_ten=?, ngay_sinh=?, gioi_tinh=?, dia_chi=? where ma_so = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, d.getMa_so());
            statement.setNString(2, d.getHo_ten());
            statement.setString(3, d.getNgay_sinh());
            statement.setBoolean(4, d.isGioi_tinh());
            statement.setNString(5, d.getDia_chi());
            statement.setString(6, d.getMa_so());

            statement.execute();
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
    }

    public static void delete(String ms) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "delete from doc_gia where ma_so = ?";
            statement = connection.prepareCall(sql);

            statement.setNString(1, ms);

            statement.execute();
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
    }

    public static Doc_Gia findByMaSo(String ma_so) {
        Doc_Gia d = null ;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly", "root", "");

            //query
            String sql = "select * from doc_gia where ma_so =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ma_so);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                d = new Doc_Gia(resultSet.getString("ma_so"), resultSet.getNString("ho_ten"),
                        resultSet.getString("ngay_sinh"), resultSet.getBoolean("gioi_tinh"),
                        resultSet.getNString("dia_chi"));
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
        return d;
    }
}

