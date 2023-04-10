DROP TABLE IF EXISTS drinks;


CREATE TABLE IF NOT EXISTS drinks (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    ingredients VARCHAR(500) NOT NULL
);


INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Coffee', 'Coffee:3, Sugar:1, Cream:1') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Coffee'
) LIMIT 1;

INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Decaf Coffee', 'Decaf Coffee:3, Sugar:1, Cream:1') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Decaf Coffee'
) LIMIT 1;

INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Caffe Latte', 'Espresso:2, Steamed Milk:1') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Caffe Latte'
) LIMIT 1;

INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Caffe Americano', 'Espresso:3') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Caffe Americano'
) LIMIT 1;

INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Caffe Mocha', 'Espresso:1, Cocoa:1, Steamed Milk:1, Whipped Cream:1') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Caffe Mocha'
) LIMIT 1;

INSERT INTO drinks (name, ingredients)
SELECT * FROM (SELECT 'Cappuccino', 'Espresso:2, Steamed Milk:1, Foamed Milk:1') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM drinks WHERE name = 'Cappuccino'
) LIMIT 1;

DROP TABLE IF EXISTS cost;

CREATE TABLE  cost (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    cost_per_unit FLOAT NOT NULL,
    quantity FLOAT NOT NULL
);

INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Coffee', 0.75, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Decaf Coffee', 0.75, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Sugar', 0.25, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Cream', 0.25, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Steamed Milk', 0.35, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Foamed Milk', 0.35, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Espresso', 1.10, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Cocoa', 0.90, 10);
INSERT INTO cost (name, cost_per_unit, quantity) VALUES ('Whipped Cream', 0.90, 10);





