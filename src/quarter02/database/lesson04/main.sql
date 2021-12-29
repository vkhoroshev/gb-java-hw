-- Задание 1
USE `employees`;
CREATE OR REPLACE VIEW `average_salary_by_department` AS
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
USE `employees`;
DROP FUNCTION IF EXISTS `find_employee_by_department_number`;

DELIMITER $$
USE `employees`$$
CREATE DEFINER = CURRENT_USER FUNCTION `find_employee_by_department_number`(dept_no CHAR(4)) RETURNS INT
BEGIN
    SET @result = (
        SELECT
            dept_manager.emp_no AS emp_no
        FROM
            dept_manager AS dept_manager
        WHERE
            dept_manager.dept_no = dept_no
            AND dept_manager.to_date = '9999-01-01'
        LIMIT 1);
    
    RETURN @result;
END$$
DELIMITER ;

-- Задание 3
USE `employees`;
DROP TRIGGER IF EXISTS `employees`.`add_bonus_new_employee`;

DELIMITER $$
USE `employees`$$
CREATE DEFINER = CURRENT_USER TRIGGER `add_bonus_new_employee` AFTER INSERT ON `employees` FOR EACH ROW
BEGIN
    INSERT INTO
        salaries
    SET
        emp_no = NEW.emp_no,
        salary = 1000,
        from_date = CURRENT_DATE(),
        to_date = CURRENT_DATE();
END$$
DELIMITER ;
