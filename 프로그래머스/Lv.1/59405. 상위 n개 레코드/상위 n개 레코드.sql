-- 코드를 입력하세요
select * from ( SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME ASC )
where rownum = 1
 
-- select * from animal_ins order by datetime