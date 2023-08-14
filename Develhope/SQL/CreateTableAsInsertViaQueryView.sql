#1
CREATE TABLE cheap_meals AS
	SELECT * FROM meal WHERE price < 15;
    
    
#2
CREATE TABLE vegan_ingredient
	SELECT * FROM ingredient WHERE false;
    

INSERT INTO vegan_ingredient
		SELECT * FROM ingredient WHERE vegan;



#3
CREATE VIEW expensive_meal AS
	SELECT * FROM meal WHERE price > 15;


#4
CREATE VIEW lactose_free_ingredient AS
	SELECT * FROM ingredient WHERE !contains_lactose;
    
 
#5
CREATE TABLE high_calorie_meal AS
	SELECT * FROM meal WHERE calories > 650; 