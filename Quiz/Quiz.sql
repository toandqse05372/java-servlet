
CREATE DATABASE [Quiz]
GO
USE [Quiz]
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[users] ([username], [email], [password]) VALUES (N'abc', N'abc@xyz.com', N'123')
