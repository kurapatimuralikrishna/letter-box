CREATE TABLE user_profiles(
		user_id INT PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(70),
		password VARCHAR(20),
		phone_number VARCHAR(10),
		city VARCHAR(20),
		description VARCHAR(600)
		);
CREATE TABLE movies(
		movie_name VARCHAR(70) PRIMARY KEY,
		director VARCHAR(70),
		lang VARCHAR(20),
		rating FLOAT
		);
CREATE TABLE movie_reviews(
		user_id INT ,
		movie_name VARCHAR(70),
		rating FLOAT,
		review VARCHAR(600),
        PRIMARY KEY(user_id,movie_name)
		);