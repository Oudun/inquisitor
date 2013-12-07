package org.helico.inquisitor.model;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 07.12.13
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 CREATE  TABLE IF NOT EXISTS `property_value` (
 `id` INT NOT NULL AUTO_INCREMENT ,
 `property_id` INT NOT NULL ,
 `name` VARCHAR(45) NULL ,
 PRIMARY KEY (`id`) ,
 INDEX `fk_property_value_property1_idx` (`property_id` ASC) ,
 CONSTRAINT `fk_property_value_property1`
 FOREIGN KEY (`property_id` )
 REFERENCES `property` (`id` )
 ON DELETE CASCADE
 ON UPDATE NO ACTION)
 ENGINE = InnoDB;

 */
public class PropertyValue {
}
