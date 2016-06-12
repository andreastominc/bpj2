-- tabelle fuer afdb_eintrag anlegen:
CREATE TABLE `hibernate_test`.`afdb_eintrag` (
  `afdb_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `titel` VARCHAR(200) NULL COMMENT '',
  `art_id` INT NULL COMMENT '',
  `erfasser_id` INT NULL COMMENT '',
  `erfassungsdatum` DATETIME NULL COMMENT '',
  `beschreibung` VARCHAR(4000) NULL COMMENT '',
  PRIMARY KEY (`afdb_id`)  COMMENT ''
 );

-- tabelle fuer afdb_art anlegen: 
CREATE TABLE `hibernate_test`.`afdb_art` (
  `art_id` INT NOT NULL COMMENT '',
  `art_benennung` VARCHAR(200) NULL COMMENT '',
  PRIMARY KEY (`art_id`)  COMMENT '',
  UNIQUE INDEX `art_id_UNIQUE` (`art_id` ASC)  COMMENT ''
);

-- fremdschluessel von afdb_eintrag.art_id auf afdb_art.art_id anlegen:
ALTER TABLE `hibernate_test`.`afdb_eintrag` 
ADD INDEX `fk_art_id_idx` (`art_id` ASC)  COMMENT '';
ALTER TABLE `hibernate_test`.`afdb_eintrag` 
ADD CONSTRAINT `fk_art_id`
  FOREIGN KEY (`art_id`)
  REFERENCES `hibernate_test`.`afdb_art` (`art_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
;


 