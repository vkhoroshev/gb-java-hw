-- Задание 1
USE `employees`;
DROP PROCEDURE IF EXISTS `dismiss_employee_by_personnel_number`;

DELIMITER $$
USE `employees`$$
CREATE DEFINER = CURRENT_USER PROCEDURE `dismiss_employee_by_personnel_number`(IN emp_id INT, OUT result CHAR(50))
BEGIN
    DECLARE is_works INT DEFAULT 0;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SET result = 'Ошибка при увольнении.';
    END;
    
    START TRANSACTION;
    
    SELECT
        COUNT(*) INTO is_works
    FROM
        dept_emp AS dept_emp
    WHERE
        dept_emp.emp_no = emp_id
        AND dept_emp.to_date = '9999-01-01';
    
    IF is_works = 1 THEN
        BEGIN
            UPDATE dept_emp SET to_date = CURRENT_DATE() WHERE (emp_no = emp_id) AND (to_date = '9999-01-01');
            UPDATE titles SET to_date = CURRENT_DATE() WHERE (emp_no = emp_id) AND (to_date = '9999-01-01');
            UPDATE salaries SET to_date = CURRENT_DATE() WHERE (emp_no = emp_id) AND (to_date = '9999-01-01');
            
            COMMIT;
            SET result = 'Сотрудник успешно уволен!';
        END;
    ELSE
        SET result = 'Сотрудник уже уволен.';
    END IF;
END$$
DELIMITER ;
