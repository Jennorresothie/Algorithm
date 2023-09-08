-- 코드를 입력하세요
SELECT to_char(o.sales_date, 'YYYY') as year, TO_NUMBER(to_char(o.sales_date, 'MM')) as month, u.gender as gender, count(distinct o.user_id) as users
from user_info u inner join online_sale o on u.user_id = o.user_id
where u.gender IS NOT NULL
group by to_char(o.sales_date, 'YYYY'), TO_NUMBER(to_char(o.sales_date, 'MM')), u.gender
order by year, month,gender