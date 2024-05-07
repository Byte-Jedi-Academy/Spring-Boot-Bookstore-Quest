CREATE TABLE "books"(
    "isbn" text not null,
    "title" text,
    "author" text,
    "price" float,
    "stock" integer,
    "text" text,
    CONSTRAINT "books.pkey" PRIMARY KEY("isbn")
);
CREATE TABLE "users"(
    "id" bigint not null,
    "name" text,
    "surname" text,
    "email" text,
    "password" text,
    "address" text,
    CONSTRAINT "users.pkey" PRIMARY KEY("id")
);

CREATE TYPE order_status AS ENUM (
    'PREPARING',
    'ON_THE_WAY',
    'OUT_FOR_DELIVERY',
    'DELIVERED'
);

CREATE TABLE "orders"(
    "id" bigint not null,
    "user_id" bigint,
    "book_isbn" text,
    "piece" int,
    "orderDate" date,
    "orderStatus" order_status,
    
    FOREIGN KEY (user_id) REFERENCES "users"(id),
    FOREIGN KEY (book_isbn) REFERENCES "books"(isbn),
    CONSTRAINT ".pkey" PRIMARY KEY("id")

);