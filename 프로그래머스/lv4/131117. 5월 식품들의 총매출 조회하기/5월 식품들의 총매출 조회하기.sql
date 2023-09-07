-- 코드를 입력하세요, 1.날짜 2.계산
SELECT o.product_id, p.product_name, sum(o.amount)*p.price as total_sales
from food_product p inner join food_order o on p.product_id = o.product_id
where to_char(o.produce_date, 'yyyy-mm') = '2022-05'
group by o.product_id, p.product_name, p.price
order by total_sales desc, o.product_id asc