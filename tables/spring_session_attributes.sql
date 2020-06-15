create table spring_session_attributes(
SESSION_PRIMARY_ID char primary key,
ATTRIBUTE_NAME VARCHAR(50),
ATTRIBUTES_BYTES blob);

drop table spring_session_attributes;
SELECT * FROM spring_session_attributes