#1
#i
/*The function CONCAT(COLUMN1, COLUMN2) AS alias_name is used to concatenate the values from two columns, COLUMN1 and COLUMN2, 
into a single string and the string given an alias 'alias_name.*/
 SELECT CONCAT(name,' = Ksh ', price) AS meal_per_price FROM meal;
 
 #ii
 /* "LOWER(COLUMN) function is used to convert text or string values to lowercase. */
 SELECT LOWER(NAME) AS name_in_lowecase FROM meal;
 
 #iii
  /* "UPPER(COLUMN) function is used to convert text or string values to uppercase. */
 SELECT UPPER(NAME) AS name_in_uppercase FROM meal;
 
 #iv
 /* TRIM(COLUMN) function is used to remove any leading or trailing whitespace (spaces, tabs, etc.) from a given text or string. */ 
 SELECT TRIM(NAME) AS trimmed_name FROM meal;
 
 #v 
 /* LENGTH(COLUMN) function determines the number of characters in a given text or string, including letters, numbers, spaces, and symbols. */
 SELECT LENGTH(NAME) AS name_length FROM meal;
 
 #vi 
 /* SUBSTRING(COLUMN, START, LENGTH) function is used to extract a portion of a text or string
  "COLUMN" specifies a column from which you want to extract a substring.
  "START" parameter indicates the position within the column's text where the extraction should begin.
  "LENGTH" parameter specifies how many characters should be included in the extracted substring.*/
 SELECT SUBSTRING(name, 1, 5) AS name_first5_characters FROM meal;

 #vii 
 /*  ROUND() function is used to round a numerical value of the specified "COLUMN name" parameter to the number of decimal places defined by the "DECIMAL_PLACES" parameter. */
 SELECT ROUND(price, 1) AS rounded_price FROM meal;
 
 #viii
 /* DATE_ADD() function is used to add a specified time interval to a date or datetime value in the "COLUMN." */
SELECT DATE_ADD(time_meal_ordered, INTERVAL 4 HOUR) FROM meal_order;

#ix
/*  DATE_SUB() function is used to subtract a specified time interval to a date or datetime value in the "COLUMN."*/
SELECT DATE_SUB(time_meal_ordered, INTERVAL 4 HOUR) FROM meal_order;
 
 #x
/*FORMAT() function is used to format a value from a column (or an expression) according to a specified format string. */
SELECT FORMAT(NOW(),'MMM DD, YYYY');


#2
SELECT DATE_SUB(DATE_ADD(NOW(),INTERVAL 14 DAY), INTERVAL 7 MONTH);
