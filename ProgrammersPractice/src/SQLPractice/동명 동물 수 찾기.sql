SELECT NAME, COUNT(ANIMAL_ID) AS CNT
FROM ANIMAL_INS 
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING CNT >= 2
ORDER BY NAME;