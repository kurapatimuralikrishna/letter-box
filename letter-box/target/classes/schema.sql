CREATE DATABASE letterbox;
USE letterbox;
CREATE TABLE user_profiles(
		user_id INT PRIMARY KEY AUTO_INCREMENT DEFAULT 1,
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
CREATE TABLE movie_lists(
		list_id INT PRIMARY KEY AUTO_INCREMENT DEFAULT 1,
		user_id INT,
		list_name VARCHAR(60)
		);
CREATE TABLE movies_inlist(
		id INT AUTO_INCREMENT DEFAULT 1 PRIMARY KEY,
		list_id INT,
		movie_name VARCHAR(70)
		);
CREATE TABLE comments(
		comment_id INT PRIMARY KEY AUTO_INCREMENT DEFAULT 1,
		user_id INT,
		list_id INT,
		root_comment_id INT,
		description VARCHAR(500)
		);
		