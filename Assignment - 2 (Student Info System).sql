CREATE DATABASE Student_Info_System;
USE Student_Info_System;

CREATE TABLE Students(
	StudentId INT PRIMARY KEY,
    FisrtName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PhoneNumber VARCHAR(100) NOT NULL
);

INSERT INTO Students (StudentId, FisrtName, LastName, DateOfBirth, Email, PhoneNumber) 
VALUES
(1, 'John', 'Doe', '1995-05-15', 'john.doe@gmail.com', '6789451230'),
(2, 'Jane', 'Smith', '1998-08-20', 'jane.smith@gmail.com', '7894561230'),
(3, 'Michael', 'Johnson', '1997-04-10', 'michael.johnson@gmail.com', '8912345670'),
(4, 'Emily', 'Brown', '1996-11-25', 'emily.brown@gmail.com', '9123456780'),
(5, 'David', 'Lee', '1999-02-18', 'david.lee@gmail.com', '6789012345'),
(6, 'Sarah', 'Wilson', '1994-09-30', 'sarah.wilson@gmail.com', '7890123456'),
(7, 'Matthew', 'Taylor', '1993-07-05', 'matthew.taylor@gmail.com', '8901234567'),
(8, 'Jessica', 'Anderson', '2000-01-08', 'jessica.anderson@gmail.com', '9012345678'),
(9, 'Christopher', 'Martinez', '1992-12-12', 'christopher.martinez@gmail.com', '6789012345'),
(10, 'Amanda', 'Garcia', '1991-06-22', 'amanda.garcia@gmail.com', '7890123456');

CREATE TABLE Teacher(
	TeacherID varchar(255) PRIMARY KEY,
    FirstName varchar(255),
    LastName varchar(255),
    Email varchar(255)
);

INSERT INTO Teacher (TeacherID, FirstName, LastName, Email) 
VALUES
('T001', 'Robert', 'Johnson', 'robert.johnson@gmail.com'),
('T002', 'Emily', 'Williams', 'emily.williams@gmail.com'),
('T003', 'Daniel', 'Brown', 'daniel.brown@gmail.com'),
('T004', 'Jennifer', 'Jones', 'jennifer.jones@gmail.com'),
('T005', 'William', 'Miller', 'william.miller@gmail.com'),
('T006', 'Elizabeth', 'Davis', 'elizabeth.davis@gmail.com'),
('T007', 'Michael', 'Garcia', 'michael.garcia@gmail.com'),
('T008', 'Mary', 'Rodriguez', 'mary.rodriguez@gmail.com'),
('T009', 'James', 'Martinez', 'james.martinez@gmail.com'),
('T010', 'Patricia', 'Hernandez', 'patricia.hernandez@gmail.com');

CREATE TABLE Courses(
	CourseID varchar(255) PRIMARY KEY,
    CourseName varchar(255),
    Credits INT,
    TeacherId varchar(255),
    FOREIGN KEY (TeacherId) REFERENCES Teacher(TeacherID)
);

INSERT INTO Courses (CourseID, CourseName, Credits, TeacherId) 
VALUES
('C001', 'Introduction to Programming', 3, 'T001'),
('C002', 'Database Management', 4, 'T002'),
('C003', 'Web Development', 4, 'T003'),
('C004', 'Data Structures and Algorithms', 3, 'T004'),
('C005', 'Software Engineering', 4, 'T005'),
('C006', 'Computer Networks', 3, 'T006'),
('C007', 'Artificial Intelligence', 4, 'T007'),
('C008', 'Operating Systems', 3, 'T008'),
('C009', 'Cybersecurity', 4, 'T009'),
('C010', 'Mobile App Development', 3, 'T010');

CREATE TABLE Enrollments(
	EnrollmentID VARCHAR(255) PRIMARY KEY,    
    StudentId INT,
    CourseID varchar(255),
    FOREIGN KEY (StudentId) REFERENCES Students(StudentId),
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
    EnrollmentDate DATE 
);

INSERT INTO Enrollments (EnrollmentID, StudentId, CourseID, EnrollmentDate) 
VALUES
('E001', 1, 'C001', '2024-04-01'),
('E002', 2, 'C002', '2024-04-02'),
('E003', 3, 'C003', '2024-04-03'),
('E004', 4, 'C004', '2024-04-04'),
('E005', 5, 'C005', '2024-04-05'),
('E006', 6, 'C006', '2024-04-06'),
('E007', 7, 'C007', '2024-04-07'),
('E008', 8, 'C008', '2024-04-08'),
('E009', 9, 'C009', '2024-04-09'),
('E010', 10, 'C010', '2024-04-10');

CREATE TABLE Payments(
	Payment varchar(255) PRIMARY KEY,
    Amount INT,
    Payment_Date DATE,
    StudentId INT,
    FOREIGN KEY(StudentId) REFERENCES Students(StudentId)
);

INSERT INTO Payments (Payment, Amount, Payment_Date, StudentId) 
VALUES
('P001', 100, '2024-04-01', 1),
('P002', 150, '2024-04-02', 2),
('P003', 200, '2024-04-03', 3),
('P004', 120, '2024-04-04', 4),
('P005', 180, '2024-04-05', 5),
('P006', 250, '2024-04-06', 6),
('P007', 300, '2024-04-07', 7),
('P008', 170, '2024-04-08', 8),
('P009', 220, '2024-04-09', 9),
('P010', 270, '2024-04-10', 10);   

-- TASK - 2 :

-- 1. WRITE AN SQL QUERY TO INSERT A NEW STUDENT INTO THE "STUDENTS" TABLE WITH THE FOLLOWING DETAILS: A. FIRST NAME: JOHN B. LAST NAME: DOE 
-- C. DATE OF BIRTH: 1995-08-15 D. EMAIL: JOHN.DOE@EXAMPLE.COM E. PHONE NUMBER: 1234567890
INSERT INTO Students
VALUES(11,'JOHN','DOE','1995-08-15' ,'JOHN.DOE@EXAMPLE.COM' ,1234567890);

-- 2. WRITE AN SQL QUERY TO ENROLL A STUDENT IN A COURSE. CHOOSE AN EXISTING STUDENT AND COURSE AND 
-- INSERT A RECORD INTO THE "ENROLLMENTS" TABLE WITH THE ENROLLMENT DATE.
INSERT INTO Enrollments
VALUES('E011',11,'C007','2024-07-10');

-- 3. UPDATE THE EMAIL ADDRESS OF A SPECIFIC TEACHER IN THE 
-- "TEACHER" TABLE. CHOOSE ANY TEACHER AND MODIFY THEIR EMAIL ADDRESS.
UPDATE Teacher SET email = 'daniel.b@gmail.com' WHERE TeacherId = 'T003';

-- 4. WRITE AN SQL QUERY TO DELETE A SPECIFIC ENROLLMENT RECORD FROM THE "ENROLLMENTS" 
-- TABLE. SELECT AN ENROLLMENT RECORD BASED ON THE STUDENT AND COURSE.
DELETE FROM Enrollments WHERE CourseId = 'C006' AND StudentId = 6;

-- 5. UPDATE THE "COURSES" TABLE TO ASSIGN A SPECIFIC TEACHER TO A 
-- COURSE. CHOOSE ANY COURSE AND TEACHER FROM THE RESPECTIVE TABLES.
UPDATE Courses SET TeacherId='T005' WHERE CourseId='C004';

-- 6. DELETE A SPECIFIC STUDENT FROM THE "STUDENTS" TABLE AND REMOVE ALL THEIR ENROLLMENT RECORDS 
-- FROM THE "ENROLLMENTS" TABLE. BE SURE TO MAINTAIN REFERENTIAL INTEGRITY.

DELETE FROM Enrollments WHERE StudentId = (SELECT StudentId FROM Students WHERE LastName = 'Wilson');
DELETE FROM Payments WHERE StudentId = (SELECT StudentId FROM Students WHERE LastName = 'Wilson');
DELETE FROM Students WHERE LastName = 'Wilson';

-- 7. UPDATE THE PAYMENT AMOUNT FOR A SPECIFIC PAYMENT RECORD IN 
-- THE "PAYMENTS" TABLE. CHOOSE ANY PAYMENT RECORD AND MODIFY THE PAYMENT AMOUNT.
ALTER TABLE Payments
CHANGE Payment PaymentId VARCHAR(225);

UPDATE Payments SET Amount = 200 WHERE PaymentId = 'P008';

-- TASK - 3 :

-- 1. WRITE AN SQL QUERY TO CALCULATE THE TOTAL PAYMENTS MADE BY A SPECIFIC STUDENT. YOU WILL NEED TO 
-- JOIN THE "PAYMENTS" TABLE WITH THE "STUDENTS" TABLE BASED ON THE STUDENT'S ID.

SELECT p.StudentId, SUM(p.Amount) AS TotalAmount from Payments p
INNER JOIN Students s ON
p.StudentId = s.StudentId
GROUP BY StudentId;


-- 2. WRITE AN SQL QUERY TO RETRIEVE A LIST OF COURSES ALONG WITH THE COUNT OF STUDENTS 
-- ENROLLED IN EACH COURSE. 
-- USE A JOIN OPERATION BETWEEN THE "COURSES" TABLE AND THE "ENROLLMENTS" TABLE.
SELECT c.CourseId, c.CourseName, COUNT(DISTINCT e.StudentId) AS TotalCount from Courses c
INNER JOIN Enrollments e ON
c.CourseId = e.CourseId
GROUP BY CourseId;

-- 3. Write an SQL query to find the names of students who have not enrolled in any course. 
-- Use a LEFT JOIN between the "Students" table and the "Enrollments" table to 
-- identify students without enrollments.
SELECT CONCAT(Students.FisrtName," ",Students.LastName) AS Name
FROM Students
LEFT JOIN Enrollments ON Students.StudentID = Enrollments.StudentID
WHERE Enrollments.StudentID IS NULL;

-- 4. WRITE AN SQL QUERY TO RETRIEVE THE FIRST NAME, LAST NAME OF STUDENTS, AND THE NAMES OF THE COURSES THEY ARE ENROLLED IN. 
-- USE JOIN OPERATIONS BETWEEN THE "STUDENTS" TABLE AND THE "ENROLLMENTS" AND "COURSES" TABLES.

SELECT e.EnrollmentId,s.FisrtName,s.LastName,c.CourseName
FROM Students s
JOIN Enrollments e ON e.StudentId = s.StudentId
JOIN Courses c ON c.courseId = e.CourseId;

-- 5. CREATE A QUERY TO LIST THE NAMES OF TEACHERS AND THE 
-- COURSES THEY ARE ASSIGNED TO. JOIN THE "TEACHER" TABLE WITH THE "COURSES" TABLE.
SELECT t.FirstName AS Teacher_Name , c.CourseName FROM Teacher t
JOIN Courses c
ON c.TeacherId = t.TeacherId;

-- 6. Retrieve a list of students and their enrollment dates for a specific course. You'll need to 
-- join the "Students" table with the "Enrollments" and "Courses" tables.
SELECT e.EnrollmentDate,CONCAT(s.FisrtName," ",s.LastName)AS StudentName,c.CourseName
FROM Students s
JOIN Enrollments e ON e.StudentId = s.StudentId
JOIN Courses c ON c.courseId = e.CourseId;

-- 7. FIND THE NAMES OF STUDENTS WHO HAVE NOT MADE ANY PAYMENTS. USE A LEFT JOIN BETWEEN THE 
-- "STUDENTS" TABLE AND THE "PAYMENTS" TABLE AND FILTER FOR STUDENTS WITH NULL PAYMENT RECORDS.

SELECT CONCAT(Students.FisrtName," ",Students.LastName) AS Name
FROM Students
LEFT JOIN Payments ON Students.StudentID = Payments.StudentID
WHERE Payments.Amount IS NULL;

-- 8. WRITE A QUERY TO IDENTIFY COURSES THAT HAVE NO ENROLLMENTS. YOU'LL NEED TO USE A 
-- LEFT JOIN BETWEEN THE "COURSES" TABLE AND THE "ENROLLMENTS" TABLE AND FILTER FOR COURSES 
-- WITH NULL ENROLLMENT RECORDS.

SELECT c.CourseName 
FROM Courses c 
LEFT JOIN Enrollments e ON e.CourseId = c.CourseId
WHERE e.enrollmentId IS NULL;

-- 9. IDENTIFY STUDENTS WHO ARE ENROLLED IN MORE THAN ONE COURSE. USE A SELF-JOIN 
-- ON THE "ENROLLMENTS" TABLE TO FIND STUDENTS WITH MULTIPLE ENROLLMENT RECORDS.
SELECT e1.StudentID, COUNT(*) AS EnrollmentCount
FROM Enrollments e1
JOIN Enrollments e2 ON e1.StudentID = e2.StudentID
GROUP BY e1.StudentID
HAVING COUNT(*) > 1;

-- 10. FIND TEACHERS WHO ARE NOT ASSIGNED TO ANY COURSES. USE A LEFT JOIN BETWEEN THE "TEACHER" TABLE 
-- AND THE "COURSES" TABLE AND FILTER FOR TEACHERS WITH NULL COURSE ASSIGNMENTS.
SELECT  CONCAT(t.FirstName," ",t.LastName) AS TeacherName
FROM Teacher t
LEFT JOIN Courses c ON c.TeacherId = t.TeacherId
WHERE c.CourseId IS NULL;
