package org.h2.dynamic;

import java.sql.*;

/**
 * Created by Danila on 03.03.2017.
 */
public class Function {
    public static void setVal(String sequence, int value, boolean bool) {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:projects", "sa", "");
            Statement stat = conn.createStatement();
            String sql = "ALTER SEQUENCE " + sequence + " RESTART WITH " + value;
            stat.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}