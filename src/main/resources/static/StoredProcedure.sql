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