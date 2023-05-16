CREATE TABLE PRODUCT
(
    id         INT            NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100)   NOT NULL,
    image      VARCHAR(200)   NOT NULL,
    price      INT            NOT NULL,
    created_dt DATETIME       NOT NULL default current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE MEMBER
(
    email VARCHAR(30)   NOT NULL,
    password     VARCHAR(30)   NOT NULL,
    created_dt   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (email)
);

INSERT INTO PRODUCT (name, image, price)
VALUES ( '히로', '/image/hero.JPG', '1000000' );

INSERT INTO PRODUCT (name, image, price)
VALUES ( '봉구', '/image/bonggu.JPG', '1100000' );

INSERT INTO MEMBER (email, password)
VALUES ('hero@naver.com', '1111');

INSERT INTO MEMBER (email, password)
VALUES ('bonggu@naver.com', '1111');