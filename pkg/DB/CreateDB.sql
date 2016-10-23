/* This file should be executed first. It will create DB user and assign the permissioin so that it can be 
 * connected from any host.
 * */
CREATE USER 'ACME'@'localhost' IDENTIFIED BY 'ACME';
CREATE USER 'ACME'@'%' IDENTIFIED BY 'ACME';
CREATE DATABASE ACME_SERVICE_DB;
USE ACME_SERVICE_DB;
GRANT ALL ON ACME_SERVICE_DB.* TO 'ACME'@'localhost';
GRANT ALL ON ACME_SERVICE_DB.* TO 'ACME'@'%';

/*This script will create all the tables*/
use ACME_SERVICE_DB;

SELECT 'CREATING CustomerInvoice' AS ' ';
source table/TableCustomerInvoice.sql;

SELECT 'INSERTING THE STATIC DATA' AS '';
source staticData/CustomerInvoiceData.sql;