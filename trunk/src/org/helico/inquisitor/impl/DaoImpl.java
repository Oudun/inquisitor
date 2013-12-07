package org.helico.inquisitor.impl;

import org.helico.inquisitor.Dao;
import org.helico.inquisitor.model.Property;
import org.helico.inquisitor.model.PropertyValue;
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
        } finally {
            return result;
        }
    }

    @Override
    public void saveTheme(String id, String name) {
        try {
            PreparedStatement ps;
            if (id==null||"null".equals(id)) {
                ps = conn.prepareStatement("INSERT INTO theme VALUES (NULL, ?)");
                ps.setString(1, name);
            } else {
                ps = conn.prepareStatement("UPDATE theme SET name=? WHERE id=?");
                ps.setInt(1, Integer.parseInt(id));
                ps.setString(2, name);
            }
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public void deleteTheme(String id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM theme WHERE id=?");
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    /// Properties methods goes here

    @Override
    public List<Property> getProperties(String themeId) {
        List<Property> result = new ArrayList<Property>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM property WHERE theme_id=?");
            ps.setString(1, themeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Property property = new Property (rs.getLong(1), rs.getLong(2), rs.getString(3));
                result.add(property);
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return result;
        }
    }

    @Override
    public void saveProperty(String id, String themeId, String name) {
        try {
            PreparedStatement ps;
            if (id==null||"null".equals(id)) {
                ps = conn.prepareStatement("INSERT INTO property VALUES (NULL, ?, ?)");
                ps.setInt(1, Integer.parseInt(themeId));
                ps.setString(2, name);
            } else {
                ps = conn.prepareStatement("UPDATE property SET name=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, id);
            }
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public void deleteProperty(String id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM property WHERE id=?");
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public Property getProperty(String id) {
        Property property = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM property WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                property = new Property (rs.getLong(1), rs.getLong(2), rs.getString(3));
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return property;
        }
    }

    @Override
    public List<PropertyValue> getPropertyValues(String themeId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void savePropertyValue(String id, String themeId, String name) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deletePropertyValue(String id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyValue getPropertyValue(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
