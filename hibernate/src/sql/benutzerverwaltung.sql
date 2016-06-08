
-- Tabelle BENUTZER, um die Benutzerdaten zu speichern:
CREATE TABLE `hibernate_test`.`benutzer` (
  `ben_id` INT NOT NULL AUTO_INCREMENT 	COMMENT '',
  `benutzername` VARCHAR(50) NOT NULL 	COMMENT '',
  `passwort` VARCHAR(200) 				COMMENT '',
  `person_id` INT NULL 					COMMENT '',
  `gesperrt_ab` DATETIME NULL 			COMMENT '',
  PRIMARY KEY (`ben_id`)  				COMMENT '',
  UNIQUE INDEX `benutzername_UNIQUE` (`benutzername` ASC)  COMMENT ''
);

-- einen Foreign Key von benutzer.person_id zu person.id anlegen:
ALTER TABLE `hibernate_test`.`benutzer` 
ADD INDEX `ben_person_id_idx` (`person_id` ASC)  COMMENT '';
ALTER TABLE `hibernate_test`.`benutzer` 
ADD CONSTRAINT `ben_person_id`
  FOREIGN KEY (`person_id`)
  REFERENCES `hibernate_test`.`person` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
