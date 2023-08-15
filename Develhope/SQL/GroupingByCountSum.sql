#1
SELECT meal_name, COUNT(*) AS meals_ordered FROM meal_order
	GROUP BY meal_name;
    
#2
SELECT MO.meal_name meal_name,SUM(M.price) AS total_revenue FROM meal M
	INNER JOIN meal_order MO ON M.name=MO.meal_name
	WHERE M.price>15
    GROUP BY MO.meal_name;
    
#3
SELECT name, COUNT(name) AS number_of_meals FROM meal 
	WHERE calories>500
    GROUP BY name;
    
#4   
 SELECT SUM(price) AS meals_containg_s_total_price FROM meal 
	WHERE LOWER(name) LIKE '%S%';
    
#5-6
SELECT name FROM meal 
	WHERE LOWER(name) LIKE '%s%';
    
#7
SELECT meal_name, COUNT(meal_name) AS meal_ordered FROM meal_order
	WHERE time_meal_ordered < NOW()
    GROUP BY meal_name