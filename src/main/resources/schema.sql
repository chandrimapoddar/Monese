CREATE TABLE IF NOT EXISTS TRANSACTION_TABLE (
transaction_id INT NOT NULL AUTO_INCREMENT,
from_account_num VARCHAR (10) NOT NULL,
to_account_num VARCHAR(10) NOT NULL,
amount_transfered DECIMAL
);

CREATE TABLE IF NOT EXISTS ACCOUNT_TABLE (
account_id INT NOT NULL ,
account_holder_name VARCHAR (100) NOT NULL,
account_holder_phone VARCHAR(10) NOT NULL,
account_holder_postcode VARCHAR(10) NOT NULL,
account_balance DECIMAL
);