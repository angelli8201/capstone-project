drop database if exists lego;
create database lego;
use lego;

create table theme (
    theme_id int primary key auto_increment,
    theme_name varchar(255) not null
);

create table legoSet (
    set_id int primary key,
    set_Name varchar(255) not null,
    pieces int,
    price double,
    ages varchar(5),
    image_url varchar(255),
    set_theme_Id int,
    set_description varchar(750),
    rating double,
    constraint fk_set_theme_id
        foreign key (set_theme_id)
        references theme(theme_id)    
);

create table legoMiniFigure (
    figure_id int primary key,
    figure_name varchar(255) not null,
    pieces int,
    image_url varchar(255),
    figure_theme_id int,
    figure_description varchar(500),
    constraint fk_figure_theme_id
        foreign key (figure_theme_id)
        references theme(theme_id)    
);

create table newsPost (
    postId int primary key auto_increment,
    post_title varchar(255) not null,
    post_caption varchar(255) not null,
    date_posted date
);

 insert into theme (theme_name) values
    ('Star Wars'),
    ('Technic'),
    ('Ideas'),
    ('Architecture'),
    ('Marvel'),
    ('Disney'),
    ('Icons'),
    ('Harry Potter');

	insert into legoSet (set_id, set_Name, pieces, price, ages, image_url, set_theme_id, set_description, rating) values
    (75192,'Millennium Falcon', 7541, 849.99, '16+', 'https://www.lego.com/cdn/cs/set/assets/blt95c35d4ed5665a49/75192.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5', 1, ' This amazing LEGO interpretation of Han Solo’s unforgettable Corellian freighter has all the details that Star Wars fans of any age could wish for, including intricate exterior detailing, upper and lower quad laser cannons, landing legs, lowering boarding ramp and a 4-minifigure cockpit with detachable canopy. ', 4.6),
    (75313,'AT-AT', 6785, 849.99, '18+', 'https://www.lego.com/cdn/cs/set/assets/blta7b7b825b6d4fc0a/75313_Prod.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5', 1, 'This is the AT-AT (75313) that every LEGO® Star Wars™ fan has been waiting for. This epic Ultimate Collector Series build-and-display model features posable legs and head, cannons with a realistic recoil action, rotating cannons, bomb-drop hatch and a hook to attach to Luke Skywalker’s line, just like in the Battle of Hoth.', 4.2),
    (75367,'Venator-Class Republic Attack Cruiser', 5374, 649.99, '18+', 'https://www.lego.com/cdn/cs/set/assets/blt06c6593d8e8d1c13/75367.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5', 1, 'Spark memories of epic Clone Wars adventures with this LEGO® Star Wars™ Ultimate Collector Series version of the Venator-Class Republic Attack Cruiser (75367). Let your mind drift to a galaxy far, far away as you recreate authentic features such as the striking red stripes, command bridge and hangar containing a brick-built scale model of a Republic Gunship.', 4.7),
    (75308,'R2-D2', 2314, 239.99, '18+','https://www.lego.com/cdn/cs/set/assets/blt38e8915698af2d5f/75308.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',1,'Relive classic Star Wars™ moments as you build this exceptionally detailed R2-D2 LEGO® droid figure. The brilliant new-for-May-2021 design is packed with authentic details, including a retractable mid-leg, rotating head, opening and extendable front hatches, a periscope that can be pulled up and turned, and Luke Skywalker’s lightsaber hidden in a compartment in the head.',4.5),
    (42143, 'Ferrari Daytona', 3778, 449.99, '18+','https://www.lego.com/cdn/cs/set/assets/bltb862bc546852bd71/42143.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',2, 'From the LEGO® Technic™ Ultimate Car Concept series comes an impressive build for adult Ferrari fans. Enter a zone of total mindfulness as you recreate the features of the Ferrari Daytona SP3 model in classic red with chrome-painted rims. Then place it on display to admire the iconic rear and curved lines that make this 1:8 scale model so special.',4.2),
    (42115,'Lamborghini Sián FKP 37',3696,449.99,'18+','https://www.lego.com/cdn/cs/set/assets/bltee88e5e65f00bd00/42115.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',2,'Experience the unmistakable power and looks of the Lamborghini Sián FKP 37 as you become immersed in this LEGO® Technic™ building kit (42115). With superb detailing, the model car is a faithful representation of the original Sián FKP 37 in eye-catching lime green with golden rims.',4.0),
    (21323, 'Grand Piano', 3662, 399.99, '18+','https://www.lego.com/cdn/cs/set/assets/blt20c84b1ff55e3256/21323.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',3,'Do you have a passion for music? Do you like to relax by focusing on a fun, hands-on project in your free time? If so, this incredible LEGO® Ideas Grand Piano model kit (21323) is just the creative activity for you.',4.3),
    (21333,'Vincent van Gogh - The Starry Night',2316,169.99,'18+','https://www.lego.com/cdn/cs/set/assets/bltc6d87e5e7bacb3ae/21333.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',3,'Build creativity. Build concentration. Build your own 3D LEGO® brick version of one of Vincent van Gogh’s most celebrated artworks, The Starry Night, which can be seen at The Museum of Modern Art (MoMA) in New York City. Discover innovative building techniques to capture Van Gogh’s swirling brushstrokes, and hang your completed masterpiece by the hook on a wall or display it freestanding. This wonderfully detailed LEGO Ideas model (21333) comes with an adjustable display arm on which the Vincent van Gogh minifigure can stand with his paintbrush, palette and easel.',4.8),
    (21318,'Tree House',3036,249.99,'16+','https://www.lego.com/cdn/cs/set/assets/blt177e3adbf9069c6f/21318.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',3,'Build, display and play with this intricately detailed, 3,036-piece LEGO® Ideas 21318 Tree House playset. A complex build for experienced LEGO builders that all the family will love to play with, it features a landscape base and 3 LEGO tree house cabins—a main bedroom, bathroom and kids’ room. The tree has interchangeable sets of green summer leaf elements and yellow and brown fall leaf elements—these and various plant elements on the base are all made from sustainable-plant-based polyethylene plastic—and the treetop and cabin roofs are removable to allow easy access. ',4.6),
    (21329, 'LEGO® Ideas Fender® Stratocaster',1074,119.99,'18+','https://www.lego.com/cdn/cs/set/assets/blt76e8ec83e0664e81/21329.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',3,'Create your own brick-built 1970s Fender® Stratocaster™ guitar and 65 Princeton® Reverb amplifier with this LEGO® Ideas set (21329). Recall the legendary musicians who have played a Stratocaster® as you recreate its iconic curves and add authentic details such as the posable whammy bar, pickup switch and tuning pegs.',4.4),
    (21028,'New York City',598,59.99,'12+','https://www.lego.com/cdn/cs/set/assets/blte43eb44c1411b445/21028.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',4,'Celebrate the architectural diversity of New York City with this detailed LEGO® brick model. The LEGO Architecture Skyline Collection offers models suitable for display in the home and office, and has been developed for all with an interest in travel, architectural culture, history and design.',4.3),
	(21034,'London',468,39.99,'12+','https://www.lego.com/cdn/cs/set/assets/blt98d7ba0b6a8b2997/21034.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',4,'Celebrate the architectural diversity of London with this detailed LEGO® brick model. The LEGO Architecture Skyline Collection offers models suitable for display in the home and office, and has been developed for all with an interest in travel, architectural culture, history and design. ',4.6),
    (76210,'Hulkbuster', 4049,549.99,'18+','https://www.lego.com/cdn/cs/set/assets/blte9c486327506d9fb/76210.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',5,'LEGO® Marvel Hulkbuster (76210) captures the scale and power of the Hulkbuster MK44 from Marvel Studios’ Avengers: Age of Ultron. Standing over 20.5 in. (52 cm) tall and containing 4,049 pieces, this challenging and rewarding construction project is designed with adult enthusiasts in mind.',2.9),
    (76178,'Daily Bugle',3772,349.99,'18+','https://www.lego.com/cdn/cs/set/assets/blt149a36e6328fd9a8/76178.jpg?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',5,'LEGO® Marvel Spider-Man Daily Bugle (76178) brings together a cast of 25 classic characters from the Spiderverse in a stunning build-and-display construction project for adults.',4.6),
    (76218,'Sanctum Sanctorum',2708,249.99,'18+','https://www.lego.com/cdn/cs/set/assets/blt5157080434f0c032/76218.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',5,'Capture the magic of Doctor Strange with the stunning LEGO® Marvel Sanctum Sanctorum (76218), a celebration of the Master of the Mystic Arts – designed with adult enthusiasts in mind.',4.5),
    (76215,'Black Panther',2961,349.99,'18+','https://www.lego.com/cdn/cs/set/assets/blt6594e9e9614f362f/76215.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',5,'Advanced, buildable model of King T’Challa.This detailed recreation features the almost life-size head, chest and hands of Black Panther, posed in the iconic Wakanda Forever salute. Both hands feature articulated fingers and detach from the main model to increase display possibilities.',3.8),
    (43222,'Disney Castle',4837,399.99,'18+','https://www.lego.com/cdn/cs/set/assets/blt4dbf45919a0034d4/43222.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',6,'Share your love of Disney Princess characters and their partners with this LEGO® ǀ Disney: Disney Castle (43222) set. Based on several well-known Disney Princess movies, this detailed set showcases different rooms, classic Disney references, nostalgic details, plus a special time capsule commemorating 100 years of Disney movies, all in a unique castle designed for display. ',4.9),
    (43217,'Up House',598,59.99,'9+','https://www.lego.com/cdn/cs/set/assets/bltde655e8359417b7d/43217.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',6,'Adventure awaits Disney fans aged 9 and up with this fun LEGO® ǀ Disney and Pixar ‘Up’ House (43217). The set that everyone will be talking about includes a detailed section of the iconic house with a chimney and balloons, 2 LEGO minifigures, a LEGO dog figure, a wilderness explorer backpack and an adventure book.',4.3),
    (43320,'Walt Disney Tribute Camera',811,99.99,'18+','https://www.lego.com/cdn/cs/set/assets/blta0d2ef903df1c30c/43230.png?format=webply&fit=bounds&quality=70&width=800&height=800&dpr=1.5',6,'Showcase your passion for all things Disney with this eye-catching LEGO® ǀ Disney Walt Disney Tribute Camera (43230) set for adults. This detailed collectible set features a vintage-style movie ‘camera’ with a hinged back panel with a surprise and a film strip showing stills from 20 historic Disney movies, a director’s clapperboard with space for the 3 LEGO ǀ Disney minifigures, 2 LEGO animal figures and a multiplane camera with 3 printed screens showing how Disney’s The Old Mill short was made.',4.8);
    
    
	
	insert into legoMiniFigure (figure_id,figure_name, pieces, image_url, figure_theme_id, figure_description) values
    (100,'Astronaut', 10, 'astronaut.jpg', 1, 'An adventurous space explorer.'),
    (200,'Knight', 8, 'knight.jpg', 2, 'A brave defender of the kingdom.'),
    (300,'Pirate Captain', 12, 'pirate_captain.jpg', 3, 'Commander of a fearsome pirate crew.');


	insert into newsPost (post_title, post_caption, date_posted) values
    ('New Space Sets Released!', 'Explore the cosmos with our latest space-themed LEGO sets.', '2023-10-15'),
    ('Medieval Castle Contest Winners', 'Congratulations to the winners of our castle-building contest!', '2023-09-28'),
    ('Pirate Ship Adventure', 'Set sail on a thrilling pirate ship adventure with our newest set.', '2023-11-02');