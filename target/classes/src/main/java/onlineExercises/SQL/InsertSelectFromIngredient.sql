#1
INSERT INTO ingredient(name, contains_lactose, vegetarian,vegan, gluten_free)
			VALUES('Eggs',false,false,true,true),
				  ('Bread',true,false,true,false),
                  ('Beef Party',true,true,false,false),
                  ('Lettuce',false,true,false,true),
                  ('Yoghurt',true,false,true,true);


#2
SELECT name FROM ingredient;

#3
#SELECT name, price  FROM ingredient;

#4
SELECT * FROM ingredient
	ORDER BY name;

#5
SELECT * FROM ingredient 
	ORDER BY gluten_free DESC;