package org.helico.inquisitor.model;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 07.12.13
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 CREATE  TABLE IF NOT EXISTS `property` (
 `id` INT NOT NULL AUTO_INCREMENT ,
 `theme_id` INT NOT NULL ,
 `name` VARCHAR(45) NULL ,
 PRIMARY KEY (`id`) ,
 INDEX `fk_property_theme_idx` (`theme_id` ASC) ,
 CONSTRAINT `fk_property_theme`
 FOREIGN KEY (`theme_id` )
 REFERENCES `theme` (`id` )
 ON DELETE CASCADE
 ON UPDATE NO ACTION)
 ENGINE = InnoDB;


 */
public class Property {

    long id;

    long themeId;

    String name;

    public Property() {

    }

    public Property(long id, long themeId, String name) {
        this.id = id;
        this.themeId = themeId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
