/* Part 1 number of each employee title after 1965-01-01 */
SELECT t.title AS "Title", count(t.title) AS "Number of Employees" 
FROM titles t
INNER JOIN employees e
ON  t.emp_no = e.emp_no
WHERE  e.birth_date > '1965-01-01'
GROUP BY t.title;

/* Part 2 Average Salary per title */
SELECT t.title AS "Title", avg(s.salary) AS "Average Salary"
FROM titles t
INNER JOIN salaries s
ON t.emp_no = s.emp_no
group by t.title;

/* Part 3 Total salary of the marketing department between 1990 - 1992 */
select sum(s.salary) as "Marketing Salary"
from salaries s
inner join dept_emp de
on de.emp_no = s.emp_no
inner join departments d
on d.dept_no = de.dept_no
where s.from_date >= '1990-01-01'
and s.to_date <= '1992-12-31'
and d.dept_name = 'Marketing';
