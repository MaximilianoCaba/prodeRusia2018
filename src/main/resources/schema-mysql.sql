CREATE TABLE IF NOT EXISTS `user` (
  `ID`         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME`       VARCHAR(50) NOT NULL,
  `MAIL`       VARCHAR(50) NOT NULL,
  `AVATAR`     VARCHAR(255),
  `ROLE_ADMIN` BOOLEAN     NOT NULL DEFAULT FALSE
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `team` (
  `ID`   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME` VARCHAR(50) NOT NULL,
  `FIFA_CODE` VARCHAR(3) NOT NULL,
  `FLAG` VARCHAR(500) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `match` (
  `ID`    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `ROUND` INT NOT NULL,
  `ID_TEAM_HOME` INT NOT NULL,
  `ID_TEAM_AWAY` INT NOT NULL,
  `GOAL_HOME` INT DEFAULT NULL,
  `GOAL_AWAY` INT DEFAULT NULL,
  `PENALTY_GOAL_HOME` INT DEFAULT NULL,
  `PENALTY_GOAL_AWAY` INT DEFAULT NULL,
  `DATE` TIMESTAMP NOT NULL,
  `ID_STATE` INT NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `match_user` (
  `ID`    INT NOT NULL PRIMARY KEY,
  `ID_MATCH` INT NOT NULL,
  `ID_USER` INT DEFAULT NULL,
  `GOAL_HOME` INT DEFAULT NULL,
  `GOAL_AWAY` INT DEFAULT NULL,
  `PENALTY_GOAL_HOME` INT DEFAULT NULL,
  `PENALTY_GOAL_AWAY` INT DEFAULT NULL
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `match_state` (
  `ID`    INT NOT NULL PRIMARY KEY,
  `STATE`    VARCHAR(50) NOT NULL
)
  ENGINE = InnoDB;

ALTER TABLE `match`
  ADD CONSTRAINT `teamHome_fk` FOREIGN KEY (`ID_TEAM_HOME`) REFERENCES `team` (`ID`);

ALTER TABLE `match`
  ADD CONSTRAINT `teamAway_fk` FOREIGN KEY (`ID_TEAM_AWAY`) REFERENCES `team` (`ID`);

  ALTER TABLE `match`
  ADD CONSTRAINT `matchState_fk` FOREIGN KEY (`ID_STATE`) REFERENCES `match_state` (`ID`);

INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (1,'Russia', 'RUS', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/900px-Flag_of_Russia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (2,'Saudi Arabia', 'KSA', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/750px-Flag_of_Saudi_Arabia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (3,'Egypt', 'EGY', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/900px-Flag_of_Egypt.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (4,'Uruguay', 'URU', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/900px-Flag_of_Uruguay.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (5,'Portugal', 'POR', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/600px-Flag_of_Portugal.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (6,'Spain', 'ESP', 'https://upload.wikimedia.org/wikipedia/en/thumb/9/9a/Flag_of_Spain.svg/750px-Flag_of_Spain.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (7,'Morocco', 'MAR', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/900px-Flag_of_Morocco.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (8,'Iran', 'IRN', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/630px-Flag_of_Iran.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (9,'France', 'FRA', 'https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/900px-Flag_of_France.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (10,'Australia', 'AUS', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1280px-Flag_of_Australia_%28converted%29.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (11,'Peru', 'PER', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Flag_of_Peru_%28state%29.svg/900px-Flag_of_Peru_%28state%29.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (12,'Denmark', 'DEN', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/740px-Flag_of_Denmark.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (13,'Argentina', 'ARG', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/800px-Flag_of_Argentina.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (14,'Iceland', 'ISL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Iceland.svg/800px-Flag_of_Iceland.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (15,'Croatia', 'CRO', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/800px-Flag_of_Croatia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (16,'Nigeria', 'NGA', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/800px-Flag_of_Nigeria.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (17,'Brazil', 'BRA', 'https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/720px-Flag_of_Brazil.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (18,'Switzerland', 'SUI', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Flag_of_Switzerland_%28Pantone%29.svg/320px-Flag_of_Switzerland_%28Pantone%29.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (19,'Costa Rica', 'CRC', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Costa_Rica_%28state%29.svg/833px-Flag_of_Costa_Rica_%28state%29.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (20,'Serbia', 'SRB', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/1350px-Flag_of_Serbia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (21,'Germany', 'GER', 'https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/800px-Flag_of_Germany.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (22,'Mexico', 'MEX', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Mexico.svg/800px-Flag_of_Mexico.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (23,'Sweden', 'SWE', 'https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Flag_of_Sweden.svg/1600px-Flag_of_Sweden.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (24,'South Korea', 'KOR', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Flag_of_South_Korea.svg/900px-Flag_of_South_Korea.pn');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (25,'Belgium', 'BEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/450px-Flag_of_Belgium.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (26,'Panama', 'PAN', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Flag_of_Panama.svg/450px-Flag_of_Panama.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (27,'Tunisia', 'TUN', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Tunisia.svg/1200px-Flag_of_Tunisia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (28,'England', 'ENG', 'https://upload.wikimedia.org/wikipedia/en/thumb/b/be/Flag_of_England.svg/800px-Flag_of_England.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (29,'Poland', 'POL', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/1280px-Flag_of_Poland.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (30,'Senegal', 'SEN', 'https://upload.wikimedia.org/wikipedia/commons/f/fd/Flag_of_Senegal.svg');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (31,'Colombia', 'COL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Colombia.svg/450px-Flag_of_Colombia.png');
INSERT INTO team (ID, NAME, FIFA_CODE, FLAG) VALUES (32,'Japan', 'JPN', 'https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/900px-Flag_of_Japan.png');

INSERT INTO match_state (ID, STATE) VALUES (1, 'NOT_STARTED');
INSERT INTO match_state (ID, STATE) VALUES (2, 'IN_PROGRESS');
INSERT INTO match_state (ID, STATE) VALUES (3, 'FINISHED');

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 1, 2, '2018-06-14 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 3, 4, '2018-06-15 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 1, 3, '2018-06-19 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 2, 4, '2018-06-20 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 4, 1, '2018-06-25 11:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 2, 3, '2018-06-25 11:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 5, 6, '2018-06-15 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 7, 8, '2018-06-15 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 5, 7, '2018-06-20 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 8, 6, '2018-06-20 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 8, 5, '2018-06-25 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 6, 7, '2018-06-25 15:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 9, 10, '2018-06-16 07:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 11, 12, '2018-06-16 13:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 9, 11, '2018-06-21 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 12, 10, '2018-06-21 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 12, 9, '2018-06-26 11:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 10, 11, '2018-06-26 11:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 13, 14, '2018-06-16 10:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 15, 16, '2018-06-16 16:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 13, 15, '2018-06-21 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 16, 14, '2018-06-22 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 16, 13, '2018-06-26 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 14, 15, '2018-06-26 15:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 17, 18, '2018-06-17 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 19, 20, '2018-06-17 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 17, 19, '2018-06-22 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 20, 18, '2018-06-22 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 20, 17, '2018-06-27 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 18, 19, '2018-06-27 15:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 21, 22, '2018-06-17 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 23, 24, '2018-06-18 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 21, 23, '2018-06-23 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 24, 22, '2018-06-23 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 24, 21, '2018-06-27 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 22, 23, '2018-06-27 11:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 25, 26, '2018-06-18 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 27, 28, '2018-06-18 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 25, 27, '2018-06-23 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 28, 26, '2018-06-24 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 28, 25, '2018-06-28 14:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 26, 27, '2018-06-28 15:00:00', 1);

INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 29, 30, '2018-06-19 09:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (1, 31, 32, '2018-06-19 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 29, 31, '2018-06-24 12:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (2, 32, 30, '2018-06-24 15:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 32, 29, '2018-06-28 11:00:00', 1);
INSERT INTO `match` (ROUND, ID_TEAM_AWAY, ID_TEAM_HOME, `DATE`, ID_STATE) VALUES (3, 30, 31, '2018-06-28 11:00:00', 1);
