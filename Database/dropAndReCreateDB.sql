

DROP DATABASE IF EXISTS time_survey;
CREATE DATABASE time_survey;

USE time_survey;



create table participant(				PARTICIPANT_ID INTEGER NOT NULL AUTO_INCREMENT,
                                 TITLE VARCHAR(255),
                                 FIRST_NAME VARCHAR(255),
                                 SURNAME VARCHAR(255),
                                 AGE_BAND VARCHAR(255),
                                 SEX VARCHAR(255),
                                 TOWN VARCHAR(255),
                                 POST_CODE VARCHAR(255),
                                 TELEPHONE VARCHAR(255),
                                 EMAIL VARCHAR(255),
                                 OPT_IN VARCHAR(255),
                                 TERMS_AGREED VARCHAR(255),
                                 SPENDING_BAND varchar(25),
  PRIMARY KEY (PARTICIPANT_ID));






create table category(			CATEGORY_ID INTEGER NOT NULL,
                            CATEGORY_NAME VARCHAR(255),
                            CATEGORY_DETAIL VARCHAR(500),
                            CATEGORY_ORDER INTEGER,
  PRIMARY KEY (CATEGORY_ID));


create table question(			QUESTION_ID INTEGER NOT NULL,
                            CATEGORY_ID INTEGER,
                            CREATE_DATE TIMESTAMP DEFAULT NOW(),
                            IS_ANSWER_PRESET   INT(11),
                            QUESTION_TXT VARCHAR(255),
                            QUESTION_ORDER INTEGER,
                            PLACE_HOLDER VARCHAR(255),
  PRIMARY KEY (QUESTION_ID),
  FOREIGN KEY (CATEGORY_ID ) REFERENCES category(CATEGORY_ID));



create table preset_answer(PRESET_ANSWER_ID INTEGER NOT NULL AUTO_INCREMENT,
                           QUESTION_ID INTEGER,
                           PRESET_ANSWER_TXT VARCHAR(255),
  PRIMARY KEY (PRESET_ANSWER_ID),
  FOREIGN KEY (QUESTION_ID ) REFERENCES question(QUESTION_ID));

create table submitted_answer(			SUBMITTED_ANSWER_ID  INTEGER NOT NULL AUTO_INCREMENT,
                                    QUESTION_ID INTEGER,
                                    PARTICIPANT_ID INTEGER,
                                    DATE_SUBMITTED TIMESTAMP DEFAULT NOW(),
                                    COMMENTS_TXT text ,
                                    SUBMITTED_ANSWER text,
  PRIMARY KEY (SUBMITTED_ANSWER_ID),
  FOREIGN KEY (PARTICIPANT_ID) REFERENCES participant(PARTICIPANT_ID),
  FOREIGN KEY (QUESTION_ID ) REFERENCES question(QUESTION_ID));

--

-- Categories   ----------------------------------------------------------------------------------------------------------
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER,CATEGORY_DETAIL,CATEGORY_NAME)   values (1, 1, "Vote here for the airline that makes the journey as pleasurable as possible. We've divided this section into two: short-haul (three hours duration or less) and long haul (flights longer than three hours in duration). Please pick <strong>one</strong> airline from each list, or suggest your own in the box below. ","Airlines");
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER,  CATEGORY_DETAIL,CATEGORY_NAME) values (2, 2, "Reward your favourite places by nominating them here. We've split this section into four: Best European country, Best worldwide country, Best European city and Best worldwide city. Please pick <strong>one</strong> destination from each list, or suggest your own in the box below. ","Destinations");
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER , CATEGORY_DETAIL,CATEGORY_NAME) values (3, 3, "The winners in this section should be the most amazing hotels in the world. We've split them into six categories: Best UK hotel, Best European hotel, Best worldwide hotel, as well as Best European spa and Best worldwide spa. Please select <strong>one</strong> hotel from each list, or suggest your own in the box below. ","Hotels");
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER, CATEGORY_DETAIL,CATEGORY_NAME) values (4, 4, "These are the companies that package up your holiday, making booking a cinch. We've split this section into five: Best family tour operator, Best specialist tour operator, Best ski tour operator, Best luxury tour operator and Best general tour operator. Please pick <strong>one</strong> tour operator from each list, or suggest your own in the box below. ","Tour Operators");
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER, CATEGORY_DETAIL,CATEGORY_NAME) values (5, 5, "Vote for your favourite ocean cruise and river cruise company by picking <strong>one</strong> from each list, or suggest your own in the box below. ","Cruise companies");
insert into time_survey.category(CATEGORY_ID, CATEGORY_ORDER, CATEGORY_DETAIL,CATEGORY_NAME) values (6, 6, "The winner of this category should be the website that makes booking online a breeze. It might find the cheapest flights, the loveliest hotels or perhaps it simply gives brilliant advice.","Website");
--



-- Questions ----------------------------------------------------------------------------------------------------------


-- Hotels
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(1, 1,'Best UK hotel',1,3, 'Please write your nomination here, (Hotel, City, County).');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(2, 1,'Best European hotel',2,3, 'Please write your nomination here, (Hotel, City, Country).');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(3, 1,'Best worldwide hotel',3,3, 'Please write your nomination here, (Hotel, City, Country).');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(4, 1,'Best European spa',4,3, 'Please write your nomination here, (Spa, City, Country).');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(5, 1,'Best worldwide spa',5,3, 'Please write your nomination here, (Spa, City, Country).');

-- Destinations
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(6, 1,'Best European country',6,2, 'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(7, 1,'Best worldwide country',7,2, 'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(8, 1,'Best European city',8,2, 'Please write your nomination here, (City, Country)');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(9, 1,'Best worldwide city',9,2, 'Please write your nomination here, (City, Country)');

-- Airlines
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(10, 1,'Best short-haul airline',10,1, 'Please write your nomination here');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(11, 1,'Best long-haul airline',11,1, 'Please write your nomination here');


-- Tour Operators
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER) values(12, 1,'Best family tour operator',12,4 ,'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER) values(13, 1,'Best specialist tour operator',13,4, 'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER) values(14, 1,'Best ski tour operator',14,4 ,'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER) values(15, 1,'Best luxury tour operator',15,4 ,'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER) values(16, 1,'Best general tour operator',16,4 ,'Please write your nomination here.');

-- Best Cruise companies
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(17, 1,'Best ocean cruise companies',17,5 ,'Please write your nomination here.');
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID ,PLACE_HOLDER ) values(18, 1,' Best river cruise companies',18,5 ,'Please write your nomination here.');


-- Best website
insert into time_survey.question  (QUESTION_ID, IS_ANSWER_PRESET ,question_TXT ,question_ORDER, CATEGORY_ID, PLACE_HOLDER ) values(19, 1,'Best travel website',19,6, 'Please select from below or enter your choice');



-- Hotels
--
--


/*Best UK hotel*/
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'The Merchant Hotel, Belfast');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Barnsley House, Cotswolds');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'The Scarlet, Cornwall');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'The Zetter Hotel, London');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Babbington House, Somerset');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Coworth Park, Berkshire');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Le Manoir aux Quat’Saisons, Oxfordshire');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'The Samling, Lake District');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Chewton Glen, Hampshire');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(1,'Lime Wood, Hampshire');

/*Best European hotel*/
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Château les Carrasses, Languedoc, France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Four Seasons Hotel at the Bosphorus, Istanbul, Turkey');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Le Royal Monceau, Paris, France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Andaz, Amsterdam, the Netherlands');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'The Yeatman, Porto, Portugal');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Hotel Arts, Barcelona, Spain');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Hotel Splendido, Portofino, Italy');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Sveti Stefan, Montenegro');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Crillon le Brave, Provence, France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(2,'Mamashelter, Marseilles, France');

/*Best hotel worldwide*/
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Aman at Summer Palace, Beijing, China');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Anantara Dhigu, Dhigufinolhu Island, Maldives');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Crosby Street Hotel, New York, US');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Palias Namaskar, Marrakech, Morocco');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'W Hotel Vieques, Vieques Island, Puerto Rico');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'One and Only Royal Mirage, Dubai, United Arab Emirates');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Cape Grace, Cape Town, South Africa');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Mandarin Oriental, Bangkok, Thailand');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Las Ventanas Al Paraíso, Los Cabos, Mexico');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(3,'Jakes, Treasure Beach, Jamaica');

/*Best European spa*/
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Verdura Gold and Spa Resort, Sciacca , Sicily');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Yeotown, Devon, UK');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Porto Elounda de Luxe Resort, Crete, Greece');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'SHA Wellness Clinic, Alicante, Spain');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'The Dolder Grand, Zürich, Switzerland');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Corinthia Hotel, London, UK');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Vigilius, South Tyrol, Italy');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'The Arrigo Programme, UK (various locations)');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Les Sources de Caudalie, Bordeaux, France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(4,'Park Hotel Kenmare, Kerry, Ireland');

/*Best worldwide spa*/
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Como Shambhala Estate, Bali, Indonesia');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Kamalaya, Koh Samui, Thailand');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Ananda in the Himalayas, India');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Standard Spa, Miami, US');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Amanfayun, Hangzhou, China');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Trisara, Phuket, Thailand');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Cocoa Island, Makunufushi, Maldives');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'Selman, Marrakech, Morocco');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'The Nam Hai, Hoi An, Vietnam');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(5,'One and Only Palmilla, Los Cabos, Mexico');


-- Destinations
--
--
/*Best European country */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Spain');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Greece');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Portugal');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Italy');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Croatia');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Sweden');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Romania');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Turkey');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(6,'Ireland');


/*Best worlwide country */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'USA');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'India');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Vietnam');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Sri Lanka');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'New Zealand');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Brazil');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Japan');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Seychelles');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Argentina');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(7,'Iceland');


/*Best European city */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Berlin, Germany');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Paris, France');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Cadiz, Spain');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Amsterdam, the Netherlands');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'London, UK');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Budapest, Hungary');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Porto, Portugal');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Venice, Italy');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Edinburgh, UK');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(8,'Krakow, Poland');


/*Best worldwide city */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Buenos Aires, Argentina');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Istanbul, Turkey');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Sydney, Australia');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Shanghai, China');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Rio de Janeiro, Brazil');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Cape Town, South Africa');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Marrakech, Morocco');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Beirut, Lebanon');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'Tokyo, Japan');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(9,'New York, US');



-- Airlines
--
--
/*Best short haul airline */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'British Airways');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Swiss');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'EasyJet');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'SAS');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'TAP Portugal');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Austrian Airlines');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Monarch');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Flybe');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Aer Lingus');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(10,'Virgin Little Red');


/*Best kong haul airline */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Virgin Atlantic');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Etihad');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'British Airways');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'American Airlines');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Emirates');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Qatar Airways');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Singapore Airlines');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Air New Zealand');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Cathay Pacific');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(11,'Malaysia Airlines');



-- Tour operators
--
--

/*Best family tour operator */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Mark Warner');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Powder Byrne');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Activities Abroad');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Virgin Holidays');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Bushbaby Travel');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'The Adventure Company');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Neilson');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Families Worldwide');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(12,'Scott Dunn');


/*Best specialist tour operator */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Martin Randall Travel');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Wendy Wu Tours');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Inntravel');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Naturetrek');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Expert Africa');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Exclusive Escapes');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Saga');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Journey Latin America');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Explore');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(13,'Dragoman');


/*Best ski tour operator */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Peak Retreats');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Esprit');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Family Ski Company');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Snowbizz');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Inghams');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Mark Warner');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Crystal Ski');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'PT Ski');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Powder Byrne');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(14,'Ski Safari');


/*Best luxury tour operator */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Scott Dunn');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Bailey Robinson');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Elegant Resorts');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Audley');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'ITC Classics');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Black Tomato');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'The Ultimate Travel Company');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Turquoise');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Original Travel');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(15,'Carrier');

/*Best general tour operator */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Virgin Holidays');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Trailfinders');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Hayes and Jarvis');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Kuoni');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Thomas Cook');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Travelbag');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Bales Worldwide');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Thomson');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(16,'Scenic Tours');




-- Best cruise companies (nearly there!)
--
--

/*Best ocean cruise company */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'P&O Cruises');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Fred Olsen');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Swan Hellenic');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Crystal Cruises');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Celebrity X Cruises ');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Star Clipper Cruises');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Regent Seven Seas Cruises');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Seabourn');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Royal Caribbean');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(17,'Hurtigruten');

/*Best river  cruise company */
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'Viking River Cruises');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'Avalon Waterways');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'Scenic Tours');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'AmaWaterways');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'CroisiEurope UK');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'Noble Caledonia');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(18,'Orient Express');






-- Best website
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Skyscanner.net');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Viamichelin.co.uk');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Seat61.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Weather2travel.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Welove2ski.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Airbnb.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Seatguru.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Spottedbylocals.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Expedia.com');
insert into time_survey.preset_answer (QUESTION_ID ,preset_answer_TXT ) values(19,'Lastminute.com');