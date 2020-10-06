DROP TABLE ACCOUNTS;

CREATE TABLE ACCOUNTS (
                          id varchar auto_increment primary key,
                          name varchar2,
                          currency varchar2,
                          money double,
                          treasury boolean
);
