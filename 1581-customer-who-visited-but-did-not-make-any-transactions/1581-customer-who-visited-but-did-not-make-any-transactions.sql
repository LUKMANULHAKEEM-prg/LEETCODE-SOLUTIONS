# Write your MySQL query statement below
-- select v.customer_id,count(v.customer_id) as count_no_trans
-- from Visits as v left join Transactions as t
-- on v.visit_id=t.visit_id;
-- where amount is null;

select v.customer_id,count(v.customer_id) as count_no_trans
from Visits as v 
left join Transactions as t
on v.visit_id = t.visit_id
where transaction_id is null
group by v.customer_id;
