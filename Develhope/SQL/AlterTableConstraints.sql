ALTER TABLE ingredient
	ADD CONSTRAINT UNIQUE(name);


ALTER TABLE ingredient
	MODIFY NAME VARCHAR(300) NOT NULL;
    
    
ALTER TABLE ingredient
	MODIFY contains_lactose VARCHAR(255) NOT NULL;
    
    
ALTER TABLE ingredient
	MODIFY vegetarian VARCHAR(255) NOT NULL;
    
    
ALTER TABLE ingredient
	MODIFY vegan VARCHAR(255) NOT NULL;
    
    
ALTER TABLE ingredient
	MODIFY gluten_free VARCHAR(255) NOT NULL;
    
    