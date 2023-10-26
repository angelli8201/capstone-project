drop database if exists lego_test;
create database lego_test;
use lego_test;

create table theme (
    theme_id int primary key auto_increment,
    theme_name varchar(255) not null,
	theme_description varchar(500) not null,
    theme_url varchar(255) not null
);

create table legoSet (
    set_id varchar(255) primary key,
    set_Name varchar(255) not null,
    pieces int,
    price double,
    ages varchar(5),
    image_url varchar(255),
    set_theme_Id int,
    set_description varchar(500),
    rating int,
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
create table blog (
 blog_id int primary key auto_increment,
 blog_title varchar(255) not null,
 blog_description varchar(500) not null,
 date_posted date,
 author varchar(255) not null
);

create table newsPost (
    post_id int primary key auto_increment,
    post_title varchar(255) not null,
    post_caption varchar(255) not null,
    date_posted date
);

delimiter //
create procedure set_known_good_state()
begin
	SET SQL_SAFE_UPDATES = 0;
	delete from legoSet;
    delete from legoMiniFigure;
    delete from theme;
    delete from newsPost;
    delete from blog;

    alter table theme auto_increment=1;
	alter table blog auto_increment=1;
    alter table newsPost auto_increment=1;
    
    SET SQL_SAFE_UPDATES = 1;
	insert into theme (theme_name, theme_description,theme_url) values
    ('Space','test','test'),
    ('Castle','test','test'),
    ('Pirates','test','test');

	insert into legoSet (set_id,set_Name, pieces, price, ages, image_url, set_theme_id, set_description, rating) values
    ('000','Space Shuttle', 500, 59.99, '8-12', 'space_shuttle.jpg', 1, 'Explore the galaxy with this awesome space shuttle!', 4),
    ('001','Medieval Castle', 1200, 89.99, '10+', 'medieval_castle.jpg', 2, 'Build your own medieval kingdom with this castle set.', 5),
    ('002','Pirate Ship', 700, 79.99, '7-14', 'pirate_ship.jpg', 3, 'Sail the high seas and search for hidden treasures!', 4);
    
    insert into blog (blog_title,blog_description,date_posted,author) values
    ('Animal Crossing', 'I cannot wait for the new Animal Crossing x Lego collaboration!', '2023-10-10','legolover123'),
    ('Holidays coming up!', 'I wonder what Lego has in store for the holidays this year :)','2023-10-13','randomlegopiece'),
    ('Brick Swap Time - Looking for Technic Pieces!','Hey everyone, I am on the hunt for some Technic pieces to complete my latest project. Anyone up for a trade? I have got a variety of bricks and minifigs to offer. How about we help each other out!','2023-10-14','milleniumfalcon');
    


	insert into legoMiniFigure (figure_id,figure_name, pieces, image_url, figure_theme_id, figure_description) values
    (100,'Astronaut', 10, 'astronaut.jpg', 1, 'An adventurous space explorer.'),
    (200,'Knight', 8, 'knight.jpg', 2, 'A brave defender of the kingdom.'),
    (300,'Pirate Captain', 12, 'pirate_captain.jpg', 3, 'Commander of a fearsome pirate crew.');


	insert into newsPost (post_title, post_caption, date_posted) values
    ('New Space Sets Released!', 'Explore the cosmos with our latest space-themed LEGO sets.', '2023-10-15'),
    ('Medieval Castle Contest Winners', 'Congratulations to the winners of our castle-building contest!', '2023-09-28'),
    ('Pirate Ship Adventure', 'Set sail on a thrilling pirate ship adventure with our newest set.', '2023-11-02');

end//
delimiter ;

