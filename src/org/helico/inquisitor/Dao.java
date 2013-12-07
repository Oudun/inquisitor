package org.helico.inquisitor;

import org.helico.inquisitor.model.Property;
import org.helico.inquisitor.model.PropertyValue;
import org.helico.inquisitor.model.Theme;

import java.util.List;

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

    public List<PropertyValue> getPropertyValues(String themeId);
    public void savePropertyValue(String id, String themeId, String name);
    public void deletePropertyValue(String id);
    public PropertyValue getPropertyValue(String id);

}
