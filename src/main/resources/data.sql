DROP TABLE ACCOUNTS;

CREATE TABLE ACCOUNTS (
            id varchar auto_increment primary key,
            name varchar2,
            currency enum('EURO', 'DOLAR'),
            money double,
            treasury boolean
);
