CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT salary
    FROM
    (
     SELECT salary,
     DENSE_RANK() OVER(ORDER BY salary DESC) AS salary_rank from Employee 
     ) AS temp
     WHERE salary_rank = N
     LIMIT 1
  );
END