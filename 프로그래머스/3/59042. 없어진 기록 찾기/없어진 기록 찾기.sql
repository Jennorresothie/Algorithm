-- 코드를 입력하세요
SELECT o.animal_id, o.name
from 
ANIMAL_INS as i
right join
ANIMAL_OUTS as o
on i.animal_id = o.animal_id
where i.animal_id is null