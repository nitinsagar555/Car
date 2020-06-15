create table spring_session(
PRIMARY_ID char primary key ,
SESSION_ID character,
CREATION_TIME bigint,
LAST_ACCESS_TIME bigint,
MAX_INACTIVE_INTERVAL int,
EXPIRY_TIME bigint, PRINCIPAL_NAME varchar(100));


select * from spring_session;