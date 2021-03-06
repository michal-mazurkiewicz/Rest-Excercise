DROP TABLE ACCOUNTS;

CREATE TABLE ACCOUNTS (
            id varchar auto_increment primary key,
            name varchar2,
            currency enum('EURO', 'DOLAR'),
            balance double,
            treasury boolean
);
