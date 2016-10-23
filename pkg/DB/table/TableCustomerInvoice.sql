/* This table will have the customer invoice data. */
CREATE TABLE CustomerInvoice(
  customerId VARCHAR(20),
  addressId VARCHAR(20),
  invoiceId VARCHAR(20),
  invoiceType VARCHAR(20),
  invoiceTypeLocalized VARCHAR(20),
  invoiceDate DATE,
  paymentDueDate DATE,
  invoiceNumber VARCHAR(20),
  startDate DATE,
  endDate DATE,
  periodDescription VARCHAR(20),
  amount DOUBLE,
  vatAmount DOUBLE,
  totalAmount DOUBLE
) ENGINE=INNODB;
