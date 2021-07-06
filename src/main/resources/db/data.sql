DELETE FROM accounts WHERE id > -1;
DELETE FROM currencies WHERE curr_id > -1;

DBCC CHECKIDENT (accounts, RESEED, 0)
DBCC CHECKIDENT (currencies, RESEED, 0)

INSERT INTO dbo.currencies
VALUES ('EUR'), ('USD'), ('MDL');

INSERT INTO dbo.accounts
VALUES ('0001', 479.1, 3, '20210612 10:41:14 AM'),
       ('0002', 1472.54, 3, '20210410 03:12:12 PM'),
       ('0003', 144.31, 1, '20210524 12:00:53 PM'),
       ('0004', 588.01, 2, '20210301 05:15:01 PM')