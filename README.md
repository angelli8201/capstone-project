# capstone-project

As a casual Lego enjoyer, I want to search for products so I can find something I might be interested in purchasing. In the 85+ years that LEGO has been running, they have released over 15,000 sets. With sets coming and in and out of rotation every year, I want to see a wide collection of new, popular, and even rare sets for sale. For my project, I want to build an e-comm app. The business model would be on Legos. The design of the store would be very colorful and nostalgic. I would create product pages with detailed product listings with descriptions, images, and prices. As a user, I want to add a product to my cart, so I may purchase it later. The cart should display current items added, in addition to the cart total. In addition, I would like to create a Lego news section, talking about what recent events the company has done. My learning goal is to look into React Stripe to mimic checkout and payment flow. In addition, I want to implement Framer Motion for react animations.

Database
- legoSet
- legoMiniFigure
- theme
- newsPost



-Lego Set - A LEGO set refers to a collection of LEGO bricks and elements packaged together in a box with instructions for building specific models or structures.
-Lego MiniFigure - A LEGO minifigure is a small, posable figure that typically stands around 1.5 inches (4 centimeters) tall. These figures are an essential component of many LEGO sets and play a crucial role in the LEGO building and play experience. 
-Lego theme - A lego theme refers to a specific category or concept around which a collection of LEGO sets is designed.
-NewsPost - A news post shows what LEGO has been doing recently or what new creations are planning to be released!




MySQL-
TABLE 1 - legoset
legoSetId, name,  pieces, ages, price, image_url


TABLE 2 - legoMiniFigure
figureId, name, pieces, image_url


TABLE 3 - theme
themeId, name

TABLE 4- newsPost
postId, title, caption, date



Monday
-models,data layer, domain layer (2.5 hour)
-create tables in MYSQL and populate with data (2.5 hours)
-testing (1 hour)


Tuesday
-finish up testing (1hour)
-make controllers (1hour)
-setup frontend(routing, pages, components) (2hours)
-research into tailwind/framer motion/react stripe (2hours)


Wednesday
-complete landing/home page (1.5 hour)
-complete themes page (1.5hour)
-complete news page (1.5hour)



Thursday
-complete all things lego page (2 hours)
-complete minifigures page (2hours)
-complete cart summary process (1.5 hour)

Friday
-look into react stripe and implement it for payment page. mimic checkout process (3 hours)
-create product listings on stripe (1.5hour)
-create server to handle payment requests (1.5hour)



Monday
-look into framer motion and add react animations to pages (3 hours)
-add blogs section (2 hours)
-add comment feature (1 hour)

Tuesday
-clean up clode (2 hours)
-populate database more and stripe product listings more(2hours)
-edit blogs section logic (2 hours)

Wednesday
-clean up code (2hours)
-add framer motion animations on buttons/ cards (1hour)
-edit ui (2 hours)

Thursday 
-make presentation (2 hours)
-practice presentation


1. Open the command line terminal.
2. Navigate to the server directory, then the sql directory, and then run the two MySQL schemas: 
lego_production_schema.sql and lego_test_schema.sql
3. Go to the server directory and navigate through the following directories: src -> main -> java -> learn. Finally, run App.java 
4. Open a new command line terminal.
5. Navigate to the client directory and then to the lego_store directory and start the client application with “npm start”
6. Open a new command line terminal
7. Navigate to the client directory and start the second client application with “npm start”


