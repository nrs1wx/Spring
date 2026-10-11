   CREATE TABLE products (
       id       BIGSERIAL PRIMARY KEY,
       name     VARCHAR(255) NOT NULL,
       category VARCHAR(100),
       price    NUMERIC(10,2) NOT NULL
   );

   CREATE INDEX idx_products_category ON products(category);