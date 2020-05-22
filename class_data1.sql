CREATE TABLE class_table (
  class_no CHAR(8) NOT NULL,
  syusseki_no CHAR(2) NOT NULL,
  gakuseki_no CHAR(5) PRIMARY KEY NOT NULL,
  simei_1 VARCHAR(20) NOT NULL,
  simei_2 VARCHAR(20) NOT NULL,
  kana_1 VARCHAR(20) NOT NULL,
  kana_2 VARCHAR(20) NOT NULL,
  umare CHAR(8) NOT NULL
);
