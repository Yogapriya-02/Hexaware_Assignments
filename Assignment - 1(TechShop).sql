-- TASK - 1 :
CREATE DATABASE TechShop;

USE TechShop;

CREATE TABLE Customers(
	CustomerID INT,
    FirstName varchar(40),
    LastName varchar(40),
    Email varchar(50),
    Phone varchar(50),
    Address varchar(200),
    primary key(CustomerID)
);

INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Phone, Address) 
VALUES 
(1, 'John', 'Doe', 'john.doe@example.com', '1234567890', '123 Main St'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '0987654321', '456 Elm St'),
(3, 'Alice', 'Johnson', 'alice.johnson@example.com', '1112223333', '789 Oak St'),
(4, 'Bob', 'Brown', 'bob.brown@example.com', '4445556666', '101 Pine St'),
(5, 'Emma', 'Garcia', 'emma.garcia@example.com', '7778889999', '202 Maple St'),
(6, 'Michael', 'Martinez', 'michael.martinez@example.com', '3336669999', '303 Cedar St'),
(7, 'Olivia', 'Hernandez', 'olivia.hernandez@example.com', '2227773333', '404 Birch St'),
(8, 'William', 'Lopez', 'william.lopez@example.com', '8884442222', '505 Spruce St'),
(9, 'Sophia', 'Gonzalez', 'sophia.gonzalez@example.com', '5553331111', '606 Walnut St'),
(10, 'James', 'Rodriguez', 'james.rodriguez@example.com', '9991114444', '707 Ash St');

DROP TABLE Products;
CREATE TABLE Products(
	ProductID varchar(3),
    ProductName varchar(40),
    Description varchar(200),
    Price INT,
    primary key(ProductID)
);

INSERT INTO Products (ProductID, ProductName, Description, Price) 
VALUES 
('P1', 'T-shirt', 'Cotton t-shirt', 20),
('P2', 'Jeans', 'Blue denim jeans', 40),
('P3', 'Sneakers', 'White canvas sneakers', 30),
('P4', 'Backpack', 'Black nylon backpack', 50),
('P5', 'Watch', 'Stainless steel wristwatch', 100),
('P6', 'Hat', 'Baseball cap', 15),
('P7', 'Jacket', 'Leather jacket', 80),
('P8', 'Sunglasses', 'Polarized sunglasses', 25),
('P9', 'Dress', 'Floral print dress', 45),
('P10', 'Boots', 'Brown leather boots', 60);


CREATE TABLE Orders(
	OrderID varchar(5),
    Customer_ID INT,
    OrderDate date,
    TotalAmount INT,
    primary key(OrderID),
    FOREIGN KEY(Customer_ID) REFERENCES Customers(CustomerID)
);
INSERT INTO Orders (OrderID, Customer_ID, OrderDate, TotalAmount) 
VALUES 
('O1', 1, '2024-04-25', 90),
('O2', 2, '2024-04-25', 140),
('O3', 3, '2024-04-24', 70),
('O4', 4, '2024-04-24', 115),
('O5', 5, '2024-04-23', 170),
('O6', 6, '2024-04-23', 55),
('O7', 7, '2024-04-22', 200),
('O8', 8, '2024-04-22', 35),
('O9', 9, '2024-04-21', 120),
('O10', 10, '2024-04-21', 95);

drop table orderdetails;
CREATE TABLE OrderDetails(
	OrderDetailID varchar(5),
    Order_ID varchar(5),
    Product_ID varchar(3),
    Quantity INT,
    primary key(OrderDetailID),
    foreign key(Order_ID) REFERENCES Orders(OrderID),
    foreign key(Product_ID) REFERENCES Products(ProductID)
);
INSERT INTO OrderDetails (OrderDetailID, Order_ID, Product_ID, Quantity) 
VALUES 
('OD1', 'O1', 'P1', 2),
('OD2', 'O2', 'P2', 10),
('OD3', 'O3', 'P3', 11),
('OD4', 'O4', 'P4', 7),
('OD5', 'O5', 'P5', 9),
('OD6', 'O6', 'P6', 2),
('OD7', 'O7', 'P7', 1),
('OD8', 'O8', 'P8', 7),
('OD9', 'O9', 'P9', 11),
('OD10', 'O10', 'P10', 19);

DROP TABLE Inventory;
CREATE TABLE Inventory(
	InventoryID varchar(5),
    Product_ID_ varchar(3),
    QuantityInStock INT,
    LastStockUpdate date,
    PRIMARY KEY(InventoryID),
    FOREIGN KEY(Product_ID_) REFERENCES Products(ProductID)
);

INSERT INTO Inventory (InventoryID, Product_ID_, QuantityInStock, LastStockUpdate) 
VALUES 
('I1', 'P1', 50, '2024-04-20'),
('I2', 'P2', 30, '2024-04-05'),
('I3', 'P3', 40, '2024-04-15'),
('I4', 'P4', 20, '2024-04-04'),
('I5', 'P5', 15, '2024-04-02'),
('I6', 'P6', 25, '2024-04-21'),
('I7', 'P7', 10, '2024-04-18'),
('I8', 'P8', 35, '2024-04-16'),
('I9', 'P9', 5, '2024-04-07'),
('I10', 'P10', 8, '2024-04-03');



 -- TASK - 2 :
 
 
-- 1) Write an SQL query to retrieve the names and emails of all customers. 
SELECT concat(FirstName,' ',LastName)as name,email from Customers;

-- 2) Write an SQL query to list all orders with their order dates and corresponding customer names.
SELECT OrderID, OrderDate, 
    (SELECT CONCAT(FirstName, ' ', LastName) FROM Customers WHERE CustomerID = Orders.Customer_ID) AS CustomerName
FROM Orders;
-- 3)Write an SQL query to insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
INSERT INTO Customers Values(11, 'Jo', 'Deni', 'jo.deni@example.com', '1294567090', '89 Main St');

select * from products;
-- 4)Write an SQL query to update the prices of all electronic gadgets in the "Products" table by increasing them by 10%

UPDATE Products 
SET price = price + (price*0.1) 
WHERE ProductName='T-shirt'; 

 -- 5) Write an SQL query to delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter.

SET @OrderId_Input = 'O3';
DELETE FROM OrderDetails where Order_ID = @OrderID_Input;
DELETE FROM Orders where OrderID = @OrderId_Input;

-- 6)Write an SQL query to insert a new order into the "Orders" table. Include the customer ID, order date, and any other necessary information.
INSERT INTO Orders (OrderID, Customer_ID, OrderDate, TotalAmount) 
VALUES ('O11', 9, '2024-04-02', 97);

-- 7)Write an SQL query to update the contact information (e.g., email and address) of a specific customer in the "Customers" table. Allow users to input the customer ID and new contact information
SET @Customer_ID_Input = 2;
SET @Address_Input = 'madipakkam,chennai';
SET @Phone_Input = '6383904567';
UPDATE Customers SET Address=@Address_Input,Phone=@Phone_Input WHERE CustomerID = @Customer_ID_Input;

-- 8) Write an SQL query to recalculate and update the total cost of each order in the 
-- "Orders" table based on the prices and quantities in the "OrderDetails" table.

Update Orders SET TotalAMOUNT = (SELECT (Price*OrderDetails.Quantity)AS Total
from Products INNER JOIN OrderDetails On
Products.ProductID = OrderDetails.Product_ID
WHERE OrderDetails.Order_ID = Orders.OrderID);


-- 9) Write an SQL query to delete all orders and their associated order details for a specific 
-- customer from the "Orders" and "OrderDetails" tables. Allow users to input the customer ID 
-- as a parameter.
SET @Customer_ID_input = 3;
DELETE OrderDetails,Orders FROM  OrderDetails INNER JOIN Orders ON 
OrderDetails.Order_Id = Orders.OrderId
WHERE Orders.Customer_Id = @Customer_ID_input;

SELECT * FROM OrderDetails;

-- 10)Insert a new electronic gadget product into the "Products" table:
INSERT INTO Products (ProductID,ProductName, Description, Price)
VALUES ('P12','New Electronic Gadget', 'Description of the new gadget', 499.99);

-- 11)Update the status of a specific order in the "Orders" table:
ALTER TABLE Orders ADD Status varchar(30);

Update Orders SET Status='Shipped' WHERE OrderId = 'O7';


Update Orders o inner join OrderDetails od
ON o.OrderId = od.Order_Id
SET o.Status = 'Pending';

Update Orders SET Status='Shipped' WHERE Status IS NULL;
SELECT * FROM Orders;

-- 12)Calculate and update 
-- the number of orders placed by each customer in the "Customers" table:
ALTER TABLE Customers ADD TotalOrders INT;

UPDATE Customers 
SET TotalOrders = (
    SELECT COUNT(OrderID) 
    FROM Orders 
    WHERE Customers.CustomerID = Orders.Customer_ID
);

select * from Customers;
select * from Orders;

-- TASK 3:


-- 1)Retrieve a list of all orders along with customer information:
SELECT o.OrderID, o.OrderDate, o.TotalAmount, c.FirstName, c.LastName, c.Email, c.Phone, c.Address
FROM Orders AS o
INNER JOIN Customers AS c ON o.Customer_ID = c.CustomerID;

-- 2)Find the total revenue generated by each electronic gadget product:
SELECT * FROM Products;

SELECT p.ProductID, p.ProductName, SUM(od.Quantity * p.Price) AS TotalRevenue
FROM OrderDetails AS od
JOIN Products AS p ON od.Product_ID = p.ProductID
GROUP BY p.ProductID, p.ProductName;

-- 3)List all customers who have made at least one purchase:
SELECT DISTINCT c.FirstName, c.LastName, c.Email, c.Phone, c.Address
FROM Customers AS c
INNER JOIN Orders AS o ON c.CustomerID = o.Customer_ID;

-- 4)Find the most popular electronic gadget:
SELECT p.ProductName, SUM(od.Quantity) AS TotalQuantityOrdered
FROM OrderDetails AS od
INNER JOIN Products AS p ON od.Product_ID = p.ProductID
GROUP BY p.ProductName
ORDER BY TotalQuantityOrdered DESC
LIMIT 1;

-- 5)Retrieve a list of electronic gadgets along with their corresponding categories:
SELECT ProductID,ProductName FROM Products WHERE ProductName='New Electronic Gadget';
 
 -- 6) Calculate the average order value for each customer:
 SELECT * FROM Orders;
SELECT c.FirstName, c.LastName, AVG(o.TotalAmount) AS AverageOrderValue
FROM Customers AS c
JOIN Orders AS o ON c.CustomerID = o.Customer_ID
GROUP BY c.FirstName, c.LastName;

-- 7)Find the order with the highest total revenue:
SELECT o.OrderID, o.OrderDate, o.TotalAmount, c.FirstName, c.LastName, c.Email, c.Phone, c.Address
FROM Orders AS o
JOIN Customers AS c ON o.Customer_ID = c.CustomerID
ORDER BY o.TotalAmount DESC
LIMIT 1;

SELECT OrderID,Customer_ID,OrderDate,TotalAmount FROM Orders
ORDER BY TotalAmount DESC
LIMIT 1;

-- 8)List electronic gadgets and the number of times each product has been ordered:
SELECT P.ProductID,P.ProductName,COUNT(P.ProductID) AS ProductsOrderedCount FROM Products as P
INNER JOIN OrderDetails as od
ON od.Product_Id = P.ProductID
GROUP BY ProductID;

-- 9)Find customers who have purchased a specific electronic gadget product:
SELECT DISTINCT c.FirstName, c.LastName, c.Email, c.Phone, c.Address
FROM Customers AS c
JOIN Orders AS o ON c.CustomerID = o.Customer_ID
JOIN OrderDetails AS od ON o.OrderID = od.Order_ID
JOIN Products AS p ON od.Product_ID = p.ProductID
WHERE p.ProductName = 'Boots';

-- 10)Calculate the total revenue generated by all orders placed within a specific time period:
SELECT COUNT(*),SUM(TotalAmount) AS TotalRevenue
FROM Orders
WHERE OrderDate BETWEEN '2024-04-21' AND '2024-04-25';

SELECT * FROM Orders;


-- TASK - 4:

-- 1)Customers who have not placed any orders:
SELECT FirstName, LastName
FROM Customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM Orders);

-- 2)Total number of products available for sale:
SELECT COUNT(DISTINCT ProductID) from Products;

-- 3)Total revenue generated by TechShop:
SELECT SUM(TotalAmount) AS TotalRevenue
FROM Orders;

-- 4)Average quantity ordered for products in a specific category:
SELECT avg(od.Quantity) AS AverageQuantityOrdered
FROM OrderDetails AS od
JOIN Products AS p ON od.Product_ID = p.ProductID
WHERE p.ProductName = 'Boots';

-- 5)Total revenue generated by a specific customer:
SELECT SUM(TotalAmount) from Orders WHERE Customer_Id = 2;

-- 6)Customers who have placed the most orders:
SELECT c.FirstName, c.LastName, 
    (SELECT COUNT(*) FROM Orders o WHERE o.Customer_ID = c.CustomerID) AS OrderCount
FROM Customers c
ORDER BY OrderCount DESC
LIMIT 1;

-- 7)Most popular product category:
SELECT ProductName
FROM Products
GROUP BY ProductName
ORDER BY SUM((SELECT SUM(Quantity) FROM OrderDetails WHERE OrderDetails.Product_ID = Products.ProductID)) DESC
LIMIT 1;

-- 8)Customer who spent the most money on electronic gadgets:
SELECT c.FirstName, c.LastName, SUM(o.TotalAmount) AS TotalSpending
FROM Customers AS c
JOIN Orders AS o ON c.CustomerID = o.Customer_ID
JOIN OrderDetails AS od ON o.OrderID = od.Order_ID
JOIN Products AS p ON od.Product_ID = p.ProductID
WHERE p.ProductName = 'Jeans'
GROUP BY c.FirstName, c.LastName
ORDER BY TotalSpending DESC
LIMIT 1;

-- 9)Average order value for all customers:
SELECT AVG(TotalAmount) AS AverageOrderValue
FROM Orders;

-- 10)Total number of orders placed by each customer:
SELECT c.FirstName, c.LastName, COUNT(*) AS OrderCount
FROM Customers AS c
JOIN Orders AS o ON c.CustomerID = o.Customer_ID
GROUP BY c.FirstName, c.LastName;
