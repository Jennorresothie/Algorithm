select order_id, product_id, TO_CHAR(OUT_DATE,'YYYY-MM-DD'), case when to_char(out_date, 'yyyy-mm-dd') < '2022-05-02' then '출고완료'
when to_char(out_date, 'yyyy-mm-dd') > '2022-05-01' then '출고대기' else '출고미정' end as 출고여부
from food_order order by 1