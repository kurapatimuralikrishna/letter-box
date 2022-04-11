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

INSERT INTO user_profiles(user_id,username,password,phone_number,city,description)
VALUES
	(1,"Veer","sty35h@v%","9302887122","Warangal","Hi, I'm veer, a movie entusiast")
	(2,"Amir","fd5(f&d70","9945654226","Suryapet","Hi, have a nice day");