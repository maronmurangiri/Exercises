#1
SELECT MAX(price) AS above_500_calories_meals_maximum_price FROM meal 
	WHERE calories>500;

#2
SELECT AVG(calories) AS above_15_euro_meals_average_calories FROM meal 
	WHERE price>15;
    
#3
SELECT name, MAX(price) AS maximum_price  FROM meal
GROUP BY name
HAVING maximum_price;

#4
SELECT name, price AS price_below_average_price FROM meal 
	WHERE price < (
		SELECT AVG(price) AS average_price FROM meal
			having average_price);
        
#5
SELECT name, price, calories FROM meal 
	WHERE calories > 600 AND price < (
		SELECT AVG(price) as average_price FROM meal
			HAVING average_price);
