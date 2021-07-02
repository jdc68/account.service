DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Currencies;

CREATE TABLE Currencies(
   id INT PRIMARY KEY IDENTITY,
   currency VARCHAR(50) NOT NULL UNIQUE,
);

CREATE TABLE Accounts (

    id INT PRIMARY KEY IDENTITY,
    accountName VARCHAR(50) NOT NULL UNIQUE,
    balance FLOAT NOT NULL,
    currencyId INT NOT NULL REFERENCES Currencies(id),
    time DATETIME NOT NULL
);

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE GET_ACCOUNTS
AS
BEGIN
    SET NOCOUNT ON;

    SELECT * FROM dbo.Accounts
END
GO
