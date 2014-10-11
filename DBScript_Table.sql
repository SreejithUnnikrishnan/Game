--Created by Sreejith Unnikrishnan
--table creation for Simple questions for initial stages 
create table simple_question(
qst_no INTEGER(4) NOTNULL,
question	VARCHAR(100)	NOTNULL,
option1	CHAR(20),
option2	CHAR(20),
option3	CHAR(20),
option4	CHAR(20),
answer	CHAR(20),
PRIMARY KEY(qst_no));

--table creation for Medium level questions for secondary stages
create table medium_question(
qst_no INTEGER(4) NOTNULL,
question	VARCHAR(100)	NOTNULL,
option1	CHAR(20),
option2	CHAR(20),
option3	CHAR(20),
option4	CHAR(20),
answer	CHAR(20),
PRIMARY KEY(qst_no));

--table creation for Tough Questions for last level
create table difficult_question(
qst_no INTEGER(4) NOTNULL,
question	VARCHAR(100)	NOTNULL,
option1	CHAR(20),
option2	CHAR(20),
option3	CHAR(20),
option4	CHAR(20),
answer	CHAR(20),
PRIMARY KEY(qst_no));

--table creation for User creation 
create table login(
user_id	CHAR(10)	NOTNULL,
first_name	CHAR(15)	NOTNULL,
last_name	CHAR(15),
password	VARCHAR(30)	NOTNULL,
PRIMARY KEY(user_id));

--Table for tracking user updates
create table user_history(
user_id CHAR(10) NOTNULL,
game_id	INTEGER(4),
score	INTEGER(4),
question_attmpt	VARCHAR(100),
PRIMARY KEY(user_id,game_id),
constraint FK_ID FOREGIN KEY(user_id) REFERENCES login(user_id) );

