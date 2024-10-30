-- 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, "NONE")
FROM PATIENT
WHERE GEND_CD = 'W'
AND AGE <= 12
ORDER BY 4 DESC, 1;