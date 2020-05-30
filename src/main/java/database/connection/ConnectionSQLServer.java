package database.connection;

import java.sql.*;
// This is new code
public class ConnectionSQLServer {
    public static Connection getConnection() {
        Connection conn = null;
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // tìm driver , phiên bản java cũ thì cần mới thì 0
        String dbURL = "jdbc:sqlserver://DLAP-0064:1433;databaseName=QUAN_LY_HOC_VIEN";
        // DESKTOP-U3GVQTN:1433 (Tên Host : port )
        String USER_NAME = "toantran";
        String PASSWORD = "1234567";
        try {
            conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("connect successfully!");
        return conn;
    }

    public static void retriewData(){
        try {
            Statement stmt = getConnection().createStatement();

            String sql = "SELECT * FROM HOC_VIEN";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                String maHv = rs.getString("MA_HOCVIEN");
                String tenHv = rs.getString("TEN_HOCVIEN");
                java.util.Date ngaySinh = rs.getDate("NGAY_SINH"); // return Date Java
                String lopHoc = rs.getString("LOP");

                //Display values
                System.out.print("Ma Hoc Vien: " + maHv);
                System.out.print("Ten Hoc Vien: " + tenHv);
                System.out.print("Ngay Sinh" + ngaySinh);
                System.out.println("Lop Hoc" + lopHoc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertData(){
        try {
            String sql_update = "INSERT INTO HOC_VIEN VALUES (?,?,?,?)";
            PreparedStatement stmt = getConnection().prepareStatement(sql_update);
            stmt.setString(1,"HV010");
            stmt.setString(2,"TOANTRAN");
            stmt.setString(3,"2020-01-01");
            stmt.setString(4,"PYTHON CORE");

            //String sql_update = "INSERT INTO HOC_VIEN VALUES ('" + maHV + "','" + tenHv + "','" + ngaySinh + "','" + lopHoc + "')";

            stmt.executeUpdate();
            //getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] agrs) {
        insertData();
        //deleteHocVien("HV01");
    }
}
