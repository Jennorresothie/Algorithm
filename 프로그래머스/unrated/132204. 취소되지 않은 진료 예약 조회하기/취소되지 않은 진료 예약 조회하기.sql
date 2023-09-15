--  2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회
--  진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT A inner join DOCTOR D on A.MDDR_ID = D.DR_ID inner join PATIENT P on A.PT_NO = P.PT_NO
where to_char(A.APNT_YMD, 'yyyy-mm-dd') = '2022-04-13' and A.MCDP_CD='CS' and A.APNT_CNCL_YN = 'N'
order by A.APNT_YMD