SELECT score ,
DENSE_RANK() OVER (order by Scores.score desc) as 'rank' 
FROM Scores
