create table if not exists Share(
    Id int primary key auto_increment,
    CompanyName varchar(255),
    CompanyUrlPart varchar(255),
    Qty int,
    PurchasePrice float,
    ExpectedPrice float
);

--insert into Share values (3, 'xxx', 'PEPCO', 1, 2, 3);