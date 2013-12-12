package org.helico.inquisitor;

import org.helico.inquisitor.model.Item;
import org.helico.inquisitor.model.Property;
import org.helico.inquisitor.model.PropertyValue;
import org.helico.inquisitor.model.Theme;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ddreval
 * Date: 27.11.13
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public interface Dao {

    public List<Theme> getThemes();
    public void saveTheme(String id, String name);
    public void deleteTheme(String id);

    public List<Property> getProperties(String themeId);
    public void saveProperty(String id, String themeId, String name);
    public void deleteProperty(String id);
    public Property getProperty(String id);

    public List<PropertyValue> getPropertyValues(String propertyId);
    public void savePropertyValue(String id, String propertyId, String name);
    public void deletePropertyValue(String id);
    public PropertyValue getPropertyValue(String id);

    public List<Item> getItems(String themeId);
    public String saveItem(String id, String themeId, String name);
    public void deleteItem(String id);
    public Item getItem(String id);
    public void deleteItemPropertyValues(String itemId);
    public void insertItemPropertyValue(String itemId, String propertyValueId);
    public Map<String, String> getItemPropertyValues(String itemId);
    public List<String> listItemPropertyValues(String itemId);

}
