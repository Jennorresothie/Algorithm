select * from(select i.animal_id, i.name
from animal_ins i inner join animal_outs o on i.animal_id = o.animal_id
ORDER BY ( O.DATETIME - I.DATETIME ) DESC)
where rownum < 3
