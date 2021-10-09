INSERT INTO Artists (Artist_name, year_started, year_ended, place_of_origin, instagram_handle)
VALUES
('Tame Impala', '2007', '9999', 'Perth, Western Australia', 'tameimpala'),
('The Strokes', '1998', '9999', 'New York City, New York', 'thestrokes'),
('Kygo', '2010', '9999', 'Bergen, Norway', 'kygomusic');

INSERT INTO Albums (Artist_id, Album_name, Year_released, Genre, RIAA_rating)
VALUES 
('1', 'Currents', '2015', 'Psychadelic pop', 'Platinum'),
('2', 'Is this It', '2001', 'Indie Rock', 'Platinum'),
('3', 'Cloud Nine', '2016', 'Tropical House', 'Gold');

INSERT INTO Songs (Album_id, Song_name, Fun_fact, Date_released) 
VALUES
('1', 'The Less I Know The Better', 'Kevin Parker states that this song originated from his love of disco', '2015-11-29'),
('1', 'Let It Happen', 'The song charted at number 28 on Billboards Adult Aternative Songs chart', '2015-03-10'),
('2', 'Someday', 'Featured in 2006 movie Click', '2001-07-30'),
('2', 'Last Nite', 'The songs opening guitar riff and overall structure is based on song American Girl by Tom Petty', '2001-07-30'),
('3', 'Firestone', 'The song features vocals from australian singer Conrad Sewell', '2014-12-01'),
('3', 'Stole the Show', 'The song features vocals from american singer Parson James', '2015-03-23');

INSERT INTO Festivals_Played (Artist_id, Name_of_festival, Start_date, End_date)
VALUES
('2', 'Lollapalooza', '2019-08-01', '2019-08-04'),
('3', 'Electric Daisy Carnival', '2017-06-16', '2017-06-18'),
('3', 'Coachella', '2018-04-13', '2018-04-15');

INSERT INTO Song_Artist(Artist_id, Song_id)
VALUES
('1', '2'),
('2', '3'),
('2', '4');




