-- 코드를 입력하세요
select p.category, p.price as max_price, p.product_name from food_product p inner join (SELECT category, max(price) as price from food_product group by category having category in ('과자','국','김치', '식용유')) f on p.category = f.category and p.price = f.price order by f.price Desc
