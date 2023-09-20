#1
SELECT * FROM meal WHERE PRICE<15;

#2
SELECT * FROM ingredient WHERE vegetarian;

#3
SELECT * FROM meal WHERE calories > 500;

#4
SELECT * FROM meal WHERE price BETWEEN 15 AND 16;

#5
SELECT * FROM ingredient WHERE !contains_lactose AND GLUTEN_FREE;

#6
SELECT * FROM meal WHERE price < 15 OR calories > 600;

#7
SELECT * FROM ingredient WHERE vegan OR gluten_free;

#8
SELECT * FROM meal WHERE name = 'Pesto Pasta';

#9
SELECT * FROM ingredient WHERE contains_lactose;

#10
SELECT * FROM meal WHERE price >20 and calories < 800;
