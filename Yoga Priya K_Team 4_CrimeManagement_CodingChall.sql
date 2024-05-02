-- If database already exists, drop it
DROP DATABASE IF EXISTS CrimeManagement;

-- Creating Database and using the same
CREATE DATABASE CrimeManagement;

USE CrimeManagement;  

-- Creating Tables Crime, Suspect, Victim
CREATE TABLE Crime( 
	CrimeID INT PRIMARY KEY, 
    IncidentType VARCHAR (255),
    IncidentDate DATE, 
    Location VARCHAR (255), 
    Description TEXT, 
    Status VARCHAR (20) 
); 

CREATE TABLE Victim (
 VictimID INT PRIMARY KEY,
 CrimeID INT,
 Name VARCHAR(255),
 Age INT,
 ContactInfo VARCHAR(255),
 Injuries VARCHAR(255),
 FOREIGN KEY (CrimeID) REFERENCES Crime(CrimeID)
);

CREATE TABLE Suspect (
 SuspectID INT PRIMARY KEY,
 CrimeID INT,
 Name VARCHAR(255),
 Age INT,
 Description TEXT,
 CriminalHistory TEXT,
 FOREIGN KEY (CrimeID) REFERENCES Crime(CrimeID)    
 );

-- Inserting values into the tables Crime, Suspect, Victim
INSERT INTO Crime ( CrimeID, IncidentType, IncidentDate, Location, Description,Status) 
VALUES
    (1, 'Robbery', '2023-09-15', '123 Main St, Cityville', 'Armed robbery at a convenience store', 'Open'),
    (2, 'Homicide', '2023-09-20', '456 Elm St, Townsville', 'Investigation into a murder case', 'Under Investigation'),
    (3, 'Theft', '2023-09-10', '789 Oak St, Villagetown', 'Shoplifting incident at a mall', 'Closed'),
    (4, 'Kidnapping', '2023-09-18', '567 Pine St, Countryside', 'Kidnapping of a prominent businessperson', 'Open'),
    (5, 'Drug Offense', '2023-09-22', '890 Maple St, Lakeside', 'Drug trafficking operation at a local park', 'Under Investigation'),
    (6, 'Theft', '2023-09-02', '345 Cedar St, Mountainside', 'Shoplifting incident at a department store', 'Closed'),
    (7, 'Murder', '2023-09-17', '901 Birch St, Riverside', 'Murder during a bank robbery', 'Open'),
    (8, 'Homicide', '2023-09-23', '234 Walnut St, Hilltop', 'Investigation into a homicide case at a residential area', 'Under Investigation'),
    (9, 'Theft', '2023-09-01', '678 Spruce St, Valleyview', 'Shoplifting incident at a supermarket', 'Closed'),
    (10, 'Robbery', '2023-09-19', '123 Pine St, Countryside', 'Armed robbery at a convenience store', 'Under Investigation'),
    (11, 'Homicide', '2023-09-04', '456 Oak St, Villagetown', 'Investigation into a homicide at a residence', 'Under Investigation'),
    (12, 'Forgery', '2023-09-13', '789 Cedar St, Mountainside', 'Forgery-related crime at a mall', 'Closed'),
    (13, 'Robbery', '2023-09-16', '567 Maple St, Lakeside', 'Armed robbery at a convenience store', 'Open'),
    (14, 'Embezzlement', '2023-09-07', '890 Elm St, Townsville', 'Theft of money through a business', 'Open'),
    (15, 'Drug Offense', '2023-09-05', '901 Oak St, Villagetown', 'Drug possession incident at a department store', 'Closed');

INSERT INTO Victim (VictimID, CrimeID, Name, Age,ContactInfo, Injuries)
VALUES
    (101, 1,'John Doe', 36, 'johndoe@gmail.com', 'Bruises'),
    (102, 2,'Jane Smith', 29, 'janesmith@gmail.com', 'Fatal wounds'),
    (103, 3,'Alice Johnson', 45, 'alicejohnson@gmail.com', 'No injuries'),
    (104, 4,'Michael Brown', 60, 'michaelbrown@gmail.com', 'Stab wounds'),
    (105, 5, 'Emily Doe', 21, 'emilydoe@gmail.com', 'Head injury'),
    (106, 6,'David Garcia', 56,'davidgarcia@gmail.com', 'Broken arm'),
    (107, 7,'Sarah Martinez', 42, 'sarahmartinez@gmail.com', 'Gunshot wound'),
    (108, 8,'Daniel Robinson', 35, 'danielrobinson@gmail.com', 'Minor injuries'),
    (109, 9,'Olivia Doe', 28, 'oliviadoe@gmail.com', 'None'),
    (110, 10,'James', 56, 'james@gmail.com', 'Severe trauma'),
    (111, 11,'Sophia', 40, 'sophia@examplgmail.com', 'No injuries'),
    (112, 12,'Ethan Lopez',69, 'ethanlopez@gmail.com', 'Sprained ankle'),
    (113, 13,'Tara Joseph', 55, 'tarajoseph@gmail.com', 'Facial injuries'),
    (114, 14,'Alexander', 62, 'alexander@gmail.com', 'Multiple injuries'),
    (115, 15,'Leena', 28,'leena@gmail.com', 'Minor injuries');

INSERT INTO Suspect (SuspectID, CrimeID, Name,Age, Description, CriminalHistory)
VALUES
    (201, 1, 'Rahul Sharma', 40, 'Armed robbery suspect', 'Previous robbery charges'),
    (202, 2, 'Alex Johnson', 38, 'Investigation into a murder case','No criminal history'),
    (203, 3, 'Suresh Kumar',29, 'Shoplifting suspect', 'Prior theft convictions'),
    (204, 4, 'Priya Patel', 45, 'Kidnapping suspect', 'No criminal history'),
    (205, 5, 'Emily', 54, 'Drug trafficking suspect', 'Previous drug offenses'),
    (206, 6, 'Ankit Singh',60, 'Forgery suspect', 'Prior forgery charges'),
    (207, 7, 'Zara Fernandez', 55,'Murder suspect', 'No criminal history'),
    (208, 8, 'Ahmed Khan',43,  'Investigation into a homicide case', 'Previous burglary convictions'),
    (209, 9, 'Shreya Desai',50, 'Shoplifting suspect', 'No criminal history'),
    (210, 10, 'William Smith', 40,'Armed robbery suspect', 'Prior robbery convictions'),
    (211, 11, 'Lakshmi Patel', 61,'Investigation into a homicide case', 'Previous fraud charges'),
    (212, 12, 'Muthvel Pandian', 58, 'Forgery suspect', 'No criminal history'),
    (213, 13, 'Priyanka Sharma', 32, 'Armed robbery suspect', 'Under investigation'),
    (214, 14, 'Vijay John',27, 'Embezzlement suspect', 'Previous embezzlement charges'),
    (215, 15, 'Durai Samy', 36,'Extortion suspect', 'Prior extortion convictions');

-- Executing the queries for Crime Management

-- 1) SELECT ALL OPEN INCIDENTS
SELECT CrimeID,IncidentType,IncidentDate FROM Crime WHERE Status = 'Open';

-- 2)FIND THE TOTAL NUMBER OF INCIDENTS
SELECT COUNT(*) AS TotalIncidents FROM Crime;

-- 3)SELECT ALL UNIQUE INCIDENT TYPES
SELECT DISTINCT IncidentType FROM Crime;

-- 4) RETRIEVE INCIDENTS THAT OCCURRED BETWEEN '2023-09-01' AND '2023-09-10'.
SELECT CrimeID,IncidentType,Location,Description,Status FROM CRIME WHERE incidentDate BETWEEN
'2023-09-01' AND '2023-09-10';

--  5) LIST PERSONS INVOLVED IN INCIDENTS IN DESCENDING ORDER OF AGE. 
SELECT VictimID,Name,Age FROM Victim ORDER BY Age DESC;

SELECT SuspectID,Name,Age FROM Suspect ORDER BY AGE DESC;

-- 6) FIND THE AVERAGE AGE OF PERSONS INVOLVED IN INCIDENTS.
SELECT (SELECT AVG(Age) FROM Victim) AS AvgVictimAge , (SELECT AVG(Age) FROM Suspect)AS AvgSuspectAge;

-- 7) LIST INCIDENT TYPES AND THEIR COUNTS, ONLY FOR OPEN CASES. 
SELECT IncidentType,COUNT(IncidentType) AS IncidentCount FROM Crime 
WHERE Status = 'Open' 
GROUP BY IncidentType;

-- 8) FIND PERSONS WITH NAMES CONTAINING 'DOE'. 
SELECT CrimeID,Name FROM Victim
WHERE Name LIKE "%Doe";

-- 9) RETRIEVE THE NAMES OF PERSONS INVOLVED IN OPEN CASES AND CLOSED CASES
Select Victim.Name AS Victims,Suspect.Name AS Suspects FROM Victim
JOIN Crime ON Victim.CrimeID = Crime.CrimeID
JOIN Suspect ON Suspect.CrimeID = Crime.CrimeID
WHERE Status IN('Open','Closed');

-- 10) LIST INCIDENT TYPES WHERE THERE ARE PERSONS AGED 30 OR 35 INVOLVED. 
-- As persons in incidents can be victims and suspects, I used separate queries to retreive data from both tables
SELECT IncidentType FROM Suspect
JOIN Crime ON Crime.CrimeID = Suspect.CrimeID
WHERE Age IN(30,35);

SELECT IncidentType FROM Victim
JOIN Crime ON Crime.CrimeID = Victim.CrimeID
WHERE Age IN(30,35);


-- 11) FIND PERSONS INVOLVED IN INCIDENTS OF THE SAME TYPE AS 'ROBBERY'. 
Select Crime.CrimeID,Victim.Name AS Victims_Robbery, Suspect.Name AS Suspects_Robbery FROM Victim
JOIN Crime ON Victim.CrimeID = Crime.CrimeID
Join Suspect ON Crime.CrimeID = Suspect.CrimeID
WHERE IncidentType = 'Robbery'; 


-- 12) LIST INCIDENT TYPES WITH MORE THAN ONE OPEN CASE. 
Select IncidentType, Count(IncidentType) AS Count, Status FROM Crime
WHERE Status='Open'
GROUP BY IncidentType 
HAVING Count(IncidentType) > 1;


-- 13) LIST ALL INCIDENTS WITH SUSPECTS WHOSE NAMES ALSO APPEAR AS VICTIMS IN OTHER INCIDENTS. 
SELECT C.CrimeID, C.IncidentType 
FROM Crime C
JOIN Suspect S ON C.CrimeID = S.CrimeID
WHERE S.Name IN (SELECT DISTINCT Name FROM Victim);


-- 14) RETRIEVE ALL INCIDENTS ALONG WITH VICTIM AND SUSPECT DETAILS. 
SELECT C.CrimeID,C.IncidentType,S.SuspectID,S.Name AS Suspects,
V.VictimID,V.Name AS Victims
FROM Victim V
JOIN Crime C ON V.CrimeID = C.CrimeID
JOIN Suspect S ON C.CrimeID = S.CrimeID;


-- 15) FIND INCIDENTS WHERE THE SUSPECT IS OLDER THAN ANY VICTIM.
SELECT C.CrimeID,C.IncidentType,C.IncidentDate,S.Name AS Suspects
FROM Victim V
JOIN Crime C ON V.CrimeID = C.CrimeID
JOIN Suspect S ON C.CrimeID = S.CrimeID
where S.Age > V.Age; 


-- 16) FIND SUSPECTS INVOLVED IN MULTIPLE INCIDENTS
SELECT S.SuspectID, S.Name AS SuspectName, COUNT(DISTINCT C.IncidentType) AS IncidentTypeCount
FROM Suspect S
JOIN Crime C ON S.CrimeID = C.CrimeID
GROUP BY S.SuspectID, S.Name
HAVING COUNT(DISTINCT C.IncidentType) > 1;


-- 17) LIST INCIDENTS WITH NO SUSPECTS INVOLVED
SELECT C.IncidentType, C.IncidentDate FROM Crime C
JOIN Suspect S ON C.CrimeID = S.CrimeID
WHERE S.Name IS NULL;


-- 18) LIST ALL CASES WHERE AT LEAST ONE INCIDENT IS OF TYPE 'HOMICIDE' AND ALL OTHER INCIDENTS ARE OF TYPE 'ROBBERY'
SELECT * FROM crime 
WHERE IncidentType = 'Homicide' 
OR (IncidentType = 'Robbery' AND CrimeID IN (SELECT CrimeID 
FROM crime WHERE IncidentType = 'Homicide'));
-- As there is no case number,I have used crimeId 


-- 19) RETRIEVE A LIST OF ALL INCIDENTS AND THE ASSOCIATED SUSPECTS,SHOWING SUSPECTS FOR EACH INCIDENT, OR 'NO SUSPECT' IF THERE ARE NONE. 
SELECT C.CrimeID, C.IncidentType AS Incident,
CASE WHEN S.Name is null then 'No Suspect' else S.Name END AS SuspectName
FROM Crime c 
LEFT JOIN Suspect S ON C.CrimeID = S.CrimeID;


-- 20) LIST ALL SUSPECTS WHO HAVE BEEN INVOLVED IN INCIDENTS WITH INCIDENT TYPES 'ROBBERY' OR 'ASSAULT'
SELECT C.CrimeID,S.Name AS SuspectName ,S.Age AS SuspectAge FROM Suspect S
JOIN Crime C ON
C.CrimeID = S.CrimeID
WHERE C.IncidentType IN ('Robbery','Assault');
