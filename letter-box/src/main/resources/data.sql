INSERT INTO movies
VALUES 
	('DHAMAAL','MURALI','HINDI',4.5),
	('HARAM','MURALI','ENGLISH',3.5),
	('HERAFERI','SAHIL','GERMAN',4.0);

INSERT INTO movie_lists
VALUES
	(1,1,"mylist"),
    (2,1,"myotherlist");
    
INSERT INTO movies_inlist
VALUES
	(1,1,"HARAM"),
    (2,1,"DHAMAAL"),
    (3,2,"HERAFERI"),
    (4,2,"DHAMAAL");