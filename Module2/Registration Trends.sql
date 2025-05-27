SELECT 
    DATE_FORMAT(registration_date, '%Y-%m') AS year_month,
    COUNT(*) AS registrations
FROM 
    Registrations
WHERE 
    registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY 
    year_month
ORDER BY 
    year_month;
