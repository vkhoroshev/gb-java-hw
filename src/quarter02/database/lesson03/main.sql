-- *******************************************************************************
-- База данных "Страны и города мира"
USE geodata;

-- Задание 1
SELECT
    _cities.id AS cities_id,
    _cities.title AS cities_title,
    _cities.important AS cities_important,
    _regions.title AS regions_title,
    _countries.title AS countries_title
FROM
    _cities AS _cities
        LEFT JOIN _regions AS _regions
            ON _cities.region_id = _regions.id
        LEFT JOIN _countries AS _countries
            ON _cities.country_id = _countries.id
LIMIT 50;

-- Задание 2
SELECT
    _cities.id AS cities_id,
    _cities.title AS cities_title
FROM
    _cities AS _cities
WHERE
    _cities.region_id IN (
        SELECT
            id AS id
        FROM
            _regions AS _regions
        WHERE
            _regions.title LIKE 'Моск%');

-- *******************************************************************************
-- База данных "Сотрудники"
USE employees;

-- Задание 1
SELECT
    dept_emp.dept_no AS dept_no,
    departments.dept_name AS dept_name,
    ROUND(AVG(salaries.salary), 2) AS average_salary
FROM
    dept_emp AS dept_emp
        LEFT JOIN departments AS departments
            ON dept_emp.dept_no = departments.dept_no
        LEFT JOIN salaries AS salaries
            ON dept_emp.emp_no = salaries.emp_no
WHERE
    dept_emp.to_date = '9999-01-01'
    AND dept_emp.dept_no IN ('d001', 'd004')
GROUP BY
    dept_no
HAVING
    average_salary > 70000;

-- Задание 2
SELECT
    dept_emp.emp_no AS personnel_number,
    CONCAT(employees.first_name, ' ', employees.last_name) AS full_name,
    MAX(salaries.salary) AS max_salary
FROM
    dept_emp AS dept_emp
        LEFT JOIN employees AS employees
            ON dept_emp.emp_no = employees.emp_no
        LEFT JOIN salaries AS salaries
            ON dept_emp.emp_no = salaries.emp_no
WHERE
    dept_emp.to_date = '9999-01-01'
    AND dept_emp.dept_no IN ('d002', 'd003')
GROUP BY
    personnel_number
HAVING
    max_salary > 75000
ORDER BY
    max_salary DESC;

-- Задание 3
DELETE FROM
    employees
WHERE
    employees.emp_no = (
        SELECT
            emp_no AS emp_no
        FROM
            salaries AS salaries
        WHERE
            to_date = '9999-01-01'
        ORDER BY
            salary DESC
        LIMIT 1);

-- Задание 4
SELECT
    dept_emp.dept_no AS dept_no,
    departments.dept_name AS dept_name,
    COUNT(dept_emp.emp_no) AS count_emp
FROM
    dept_emp AS dept_emp
        LEFT JOIN departments AS departments
            ON dept_emp.dept_no = departments.dept_no
WHERE
    dept_emp.to_date = '9999-01-01'
GROUP BY
    dept_no
HAVING
    count_emp > 20000;

-- Задание 5
SELECT
    dept_emp.dept_no AS dept_no,
    departments.dept_name AS dept_name,
    COUNT(dept_emp.emp_no) AS count_emp,
    SUM(salaries.salary) AS sum_salary
FROM
    dept_emp AS dept_emp
        LEFT JOIN departments AS departments
            ON dept_emp.dept_no = departments.dept_no
        LEFT JOIN (
                SELECT
                    emp_no AS emp_no,
                    salary AS salary
                FROM
                    salaries AS salaries
                WHERE
                    to_date = '9999-01-01') AS salaries
            ON dept_emp.emp_no = salaries.emp_no
WHERE
    dept_emp.to_date = '9999-01-01'
GROUP BY
    dept_no
ORDER BY
    sum_salary DESC;
