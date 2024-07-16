CREATE TABLE IF NOT EXISTS goods
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) ,
    price real
);

CREATE TABLE IF NOT EXISTS order_goods
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    good_id BIGINT,
    foreign key (order_id) references user_order(id),
    foreign key (good_id) references goods(id)
);

CREATE TABLE IF NOT EXISTS user_order
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    total_price real,
    good_id bigint,
    order_id bigint,
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) ,
    password VARCHAR(255) ,
);
