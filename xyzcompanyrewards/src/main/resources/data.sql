DROP TABLE IF EXISTS user_info;
 
CREATE TABLE user_info (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  password VARCHAR(30) NOT NULL
);
 
INSERT INTO user_info (user_name, password) VALUES
  ('admin', 'admin');
  
  
DROP TABLE IF EXISTS customer_transactions;
 
CREATE TABLE customer_transactions (
  customer_transaction_id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  transactions_for_month VARCHAR(15) NOT NULL,
  transactions_for_year VARCHAR(6) NOT NULL,
  transaction_amt NUMBER(9,2) NOT NULL
);
 
INSERT INTO customer_transactions (customer_name, transactions_for_month, transactions_for_year, transaction_amt) VALUES
  ('CUSTOMERA', 'FEBRUARY', '2020', 120),
  ('CUSTOMERA', 'FEBRUARY', '2020', 80),
  ('CUSTOMERA', 'MARCH', '2020', 180),
  ('CUSTOMERA', 'APRIL', '2020', 42),
  ('CUSTOMERB', 'FEBRUARY', '2020', 120),
  ('CUSTOMERB', 'FEBRUARY', '2020', 101),
  ('CUSTOMERB', 'MARCH', '2020', 180),
  ('CUSTOMERB', 'APRIL', '2020', 99),
  ('CUSTOMERC', 'FEBRUARY', '2020', 120),
  ('CUSTOMERC', 'FEBRUARY', '2020', 91),
  ('CUSTOMERC', 'MARCH', '2020', 180),
  ('CUSTOMERC', 'APRIL', '2020', 51);
  