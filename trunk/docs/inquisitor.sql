SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `theme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `theme` ;

CREATE TABLE IF NOT EXISTS `theme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `property` ;

CREATE TABLE IF NOT EXISTS `property` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `theme_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_theme_idx` (`theme_id` ASC),
  CONSTRAINT `fk_property_theme`
    FOREIGN KEY (`theme_id`)
    REFERENCES `theme` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `property_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `property_value` ;

CREATE TABLE IF NOT EXISTS `property_value` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_value_property1_idx` (`property_id` ASC),
  CONSTRAINT `fk_property_value_property1`
    FOREIGN KEY (`property_id`)
    REFERENCES `property` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `theme_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_theme1_idx` (`theme_id` ASC),
  CONSTRAINT `fk_item_theme1`
    FOREIGN KEY (`theme_id`)
    REFERENCES `theme` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_property_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_property_value` ;

CREATE TABLE IF NOT EXISTS `item_property_value` (
  `item_id` INT NOT NULL,
  `property_value_id` INT NOT NULL,
  PRIMARY KEY (`item_id`, `property_value_id`),
  INDEX `fk_item_has_property_value_property_value1_idx` (`property_value_id` ASC),
  INDEX `fk_item_has_property_value_item1_idx` (`item_id` ASC),
  CONSTRAINT `fk_item_has_property_value_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_property_value_property_value1`
    FOREIGN KEY (`property_value_id`)
    REFERENCES `property_value` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_answer` ;

CREATE TABLE IF NOT EXISTS `user_answer` (
  `item_property_value_item_id` INT NOT NULL,
  `item_property_value_property_value_id` INT NOT NULL,
  `user_login` VARCHAR(45) NOT NULL,
  `error_rate` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`item_property_value_item_id`, `item_property_value_property_value_id`, `user_login`),
  INDEX `fk_item_property_value_has_user_user1_idx` (`user_login` ASC),
  INDEX `fk_item_property_value_has_user_item_property_value1_idx` (`item_property_value_item_id` ASC, `item_property_value_property_value_id` ASC),
  CONSTRAINT `fk_item_property_value_has_user_item_property_value1`
    FOREIGN KEY (`item_property_value_item_id` , `item_property_value_property_value_id`)
    REFERENCES `item_property_value` (`item_id` , `property_value_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_property_value_has_user_user1`
    FOREIGN KEY (`user_login`)
    REFERENCES `user` (`login`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
