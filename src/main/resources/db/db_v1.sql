CREATE TABLE USER
(
  ID           INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_CBB56811_1F1F_46BB_AB85_E46D328A35A8) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50),
  TOKEN        VARCHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT
);
CREATE USER IF NOT EXISTS admin
  { PASSWORD 'admin@123'  };
ALTER USER admin ADMIN { TRUE };