DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies(
    curr_id INT PRIMARY KEY IDENTITY,
    currency VARCHAR(50) NOT NULL UNIQUE,
);

CREATE TABLE accounts (

    id INT PRIMARY KEY IDENTITY,
    name VARCHAR(50) NOT NULL UNIQUE,
    balance FLOAT NOT NULL,
    currency_id INT NOT NULL REFERENCES currencies(curr_id),
    transaction_time DATETIME NOT NULL
);

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

USE [accountdb]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROCEDURE [dbo].[GET_ACCOUNTS]
AS
BEGIN
    SET NOCOUNT ON;
--     SELECT * FROM accounts;
    SELECT
        a.id, a.name, a.balance, a.currency_id, c.currency, a.transaction_time
    FROM
        accounts a LEFT JOIN currencies c
    ON a.currency_id = c.curr_id;
END

