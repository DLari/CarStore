INSERT INTO users
VALUES (1,'PetyPetrov','12-01-1990','qwesvg','qwert1234Qw','client'),
       (2,'MaslennikovDmitriy','10-03-1995','sdgs','sd1531afWE','client'),
       (3,'ZaharovAndrey','25-07-1997','adminLogin','adminPassword','admin');

INSERT INTO orders (id, auto_in_stock_id, dict_order_status_id, users_id, date)
VALUES (1,1,1,1,'20-05-2019'),
       (2,2,1,2,'20-05-2019');
