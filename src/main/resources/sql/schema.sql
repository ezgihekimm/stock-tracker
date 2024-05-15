create table product(
    id identity primary key,
    pname varchar(50),
    count int,
    barcode int,
    purchasePrice double precision,
    salePrice double precision,
    dateOfBirth date
);
