create table if not exists Share(
    Id int primary key ,
    CompanyName varchar(255),
    CompanyUrlPart varchar(255),
    Qty int,
    PurchasePrice float,
    ExpectedPrice float
);