CREATE TABLE post (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    topics VARCHAR(300) NOT NULL,
    content VARCHAR(10000) NOT NULL,
    release DATE NOT NULL,
    likes INT
)
