-- 코드를 입력하세요
SELECT
p.PRODUCT_CODE,
sum(o.SALES_AMOUNT)*p.PRICE as SALES
from
product as p
join 
offline_sale as o
on p.product_id = o.product_id

group by p.product_id

order by SALES desc, p.PRODUCT_CODE