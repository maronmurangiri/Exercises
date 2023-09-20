#1
SELECT  M.name FROM meal M 
	INNER JOIN meal_ingredient MI ON M.name = MI.meal_name
    WHERE MI.ingredient_name='garlic';
    
#2
SELECT COUNT(M.name) AS vegetarian_meals FROM meal M
	INNER JOIN meal_ingredient MI ON M.name = MI.meal_name
    INNER JOIN ingredient I on MI.ingredient_name = I.name
    WHERE I.vegetarian = true;
    
    
 #3
 SELECT M.name FROM meal M	
	INNER JOIN meal_ingredient MI ON M.name = MI.meal_name
    INNER JOIN ingredient I on MI.ingredient_name = I.name
    WHERE I.gluten_free = true AND I.vegan = true;
    
 
 #4
 SELECT AVG(count_of_used_ingredient) AS average_ingredient_per_meal FROM 
	(SELECT COUNT(ingredient_name) AS count_of_used_ingredient 
		FROM meal_ingredient
        GROUP BY meal_name
        ) AS count_per_meal;
        
#5
SELECT meal_name, COUNT(ingredient_name) AS total_ingredient_per_meal
	FROM meal_ingredient
	GROUP BY meal_name
	HAVING total_ingredient_per_meal > 3;
	
   
#6
SELECT * FROM CUSTOMER C INNER JOIN ORDERS O ON C.CUSTOMER_ID=O.CUSTOMER_ID;

#7
SELECT * FROM PRODUCT P INNER JOIN INVENTORY I ON P.PRODUCT_ID=I.PRODUCT_ID;

 
 