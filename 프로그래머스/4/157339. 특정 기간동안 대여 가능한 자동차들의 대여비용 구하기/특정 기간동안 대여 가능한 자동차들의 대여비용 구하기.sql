SELECT
    C.CAR_ID,
    C.CAR_TYPE,
    ROUND (C.DAILY_FEE*30*(1-P.DISCOUNT_RATE / 100)) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR AS C
    JOIN 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    ON C.CAR_ID = H.CAR_ID 
    JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
    ON C.CAR_TYPE = P.CAR_TYPE
WHERE
    C.CAR_TYPE IN ('SUV', '세단')
    AND
    P.DURATION_TYPE	= '30일 이상'
    AND
    C.CAR_ID NOT IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE <= '2022-11-30'
            AND
            END_DATE >= '2022-11-01'
    )
GROUP BY C.CAR_ID
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC