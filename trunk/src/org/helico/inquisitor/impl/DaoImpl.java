package org.helico.inquisitor.impl;

import org.helico.inquisitor.Dao;
import org.helico.inquisitor.model.Theme;
import org.helico.inquisitor.util.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ddreval
 * Date: 27.11.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class DaoImpl implements Dao {

    private Logger logger = Logger.getLogger(DaoImpl.class);

    private Connection conn;

    public DaoImpl () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/asker", "root", "admin");
        } catch (Exception e) {
            logger.error("Can not create connection", e);
        }
    }

    @Override
    public List<Theme> getThemes() {
        List<Theme> result = new ArrayList<Theme>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM theme");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Theme theme = new Theme(rs.getLong(1), rs.getString(2));
                result.add(theme);
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
        return result;
    }

}
