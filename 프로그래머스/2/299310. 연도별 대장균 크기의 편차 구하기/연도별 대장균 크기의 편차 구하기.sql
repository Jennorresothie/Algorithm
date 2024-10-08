SELECT 
    YEAR(A.DIFFERENTIATION_DATE) AS YEAR, 
    B.SIZE - A.SIZE_OF_COLONY AS YEAR_DEV, 
    A.ID
FROM ECOLI_DATA A 
JOIN (
    SELECT 
        DATE_FORMAT(DIFFERENTIATION_DATE, '%Y') AS YEARS, 
        MAX(SIZE_OF_COLONY) AS SIZE
    FROM ECOLI_DATA
    GROUP BY DATE_FORMAT(DIFFERENTIATION_DATE, '%Y')
) B ON DATE_FORMAT(A.DIFFERENTIATION_DATE, '%Y') = B.YEARS
ORDER BY 1, 2