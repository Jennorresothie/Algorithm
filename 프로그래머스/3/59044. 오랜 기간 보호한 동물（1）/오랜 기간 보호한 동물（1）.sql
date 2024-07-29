-- 코드를 입력하세요
SELECT
i.name,
i.datetime
from
animal_ins as i
left join
animal_outs as o
on i.animal_id = o.animal_id
where
    o.animal_id is null
order by 2
limit 3