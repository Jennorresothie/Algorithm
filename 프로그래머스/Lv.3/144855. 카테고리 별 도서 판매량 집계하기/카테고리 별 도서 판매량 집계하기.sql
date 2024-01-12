SELECT B.CATEGORY, SUM(S.SALES) FROM BOOK B JOIN (select BOOK_ID, SALES from book_sales where to_char(SALES_DATE, 'yyyy-mm') = '2022-01') S ON S.BOOK_ID = B.BOOK_ID
GROUP BY B.CATEGORY
ORDER BY CATEGORY