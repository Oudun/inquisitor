package org.helico.inquisitor.impl;

import org.helico.inquisitor.Dao;
import org.helico.inquisitor.model.Item;
import org.helico.inquisitor.model.Property;
import org.helico.inquisitor.model.PropertyValue;
import org.helico.inquisitor.model.Theme;
import org.helico.inquisitor.util.Logger;

import javax.sql.RowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /////////  Property Values methods ///////////////

    @Override
    public List<PropertyValue> getPropertyValues(String themeId) {
        List<PropertyValue> result = new ArrayList<PropertyValue>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM property_value WHERE property_id=?");
            ps.setString(1, themeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PropertyValue propertyValue = new PropertyValue (rs.getLong(1), rs.getLong(2), rs.getString(3));
                result.add(propertyValue);
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return result;
        }
    }

    @Override
    public void savePropertyValue(String id, String propertyId, String name) {
        try {
            PreparedStatement ps;
            if (id==null||"null".equals(id)) {
                ps = conn.prepareStatement("INSERT INTO property_value VALUES (NULL, ?, ?)");
                ps.setInt(1, Integer.parseInt(propertyId));
                ps.setString(2, name);
            } else {
                ps = conn.prepareStatement("UPDATE property_value SET name=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, id);
            }
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public void deletePropertyValue(String id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM property_value WHERE id=?");
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public PropertyValue getPropertyValue(String id) {
        PropertyValue propertyValue = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM property_value WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                propertyValue = new PropertyValue (rs.getLong(1), rs.getLong(2), rs.getString(3));
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return propertyValue;
        }
    }

    @Override
    public List<Item> getItems(String themeId) {
        List<Item> result = new ArrayList<Item>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM item WHERE theme_id=?");
            ps.setString(1, themeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item (rs.getLong(1), rs.getLong(2), rs.getString(3));
                result.add(item);
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return result;
        }
    }

    @Override
    public String saveItem(String id, String themeId, String name) {
        String itemId = id;
        try {
            PreparedStatement ps;
            if (id==null||"null".equals(id)) {
                ps = conn.prepareStatement("INSERT INTO item VALUES (NULL, ?, ?)");
                ps.setInt(1, Integer.parseInt(themeId));
                ps.setString(2, name);
                ps.execute();
                ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet rs = ps.executeQuery();
                rs.next();
                Object obj = rs.getObject(1);
                itemId = String.valueOf((Long) obj);
            } else {
                ps = conn.prepareStatement("UPDATE item SET name=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, id);
                ps.execute();
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return itemId;
        }
    }

    @Override
    public void deleteItem(String id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM item WHERE id=?");
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public Item getItem(String id) {
        Item item = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM item WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item (rs.getLong(1), rs.getLong(2), rs.getString(3));
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return item;
        }
    }

    @Override
    public void deleteItemPropertyValues(String itemId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM item_property_value WHERE item_id=?");
            ps.setString(1, itemId);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public void insertItemPropertyValue(String itemId, String propertyValueId) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO item_property_value values (?, ?)");
            ps.setString(1, itemId);
            ps.setString(2, propertyValueId);
            ps.execute();
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        }
    }

    @Override
    public Map<String, String> getItemPropertyValues(String itemId) {
        Map<String, String> result = new HashMap<String, String>();
        if (itemId==null) {
            return result;
        }
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT pv.property_id, ipv.property_value_id " +
                            "FROM item_property_value ipv " +
                            "INNER JOIN property_value pv on pv.id = ipv.property_value_id " +
                            "WHERE ipv.item_id=?");
            ps.setString(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.put(String.valueOf(rs.getLong(1)), String.valueOf(rs.getLong(2)));
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return result;
        }
    }

    @Override
    public List<String> listItemPropertyValues(String itemId) {
        List<String> result = new ArrayList<String>();
        if (itemId==null) {
            return result;
        }
        try {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT property_value_id FROM item_property_value WHERE item_id=?");
            ps.setString(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.add(String.valueOf(rs.getLong(1)));
            }
        } catch (Exception e) {
            logger.error("Can not prepare statement", e);
        } finally {
            return result;
        }
    }

}
