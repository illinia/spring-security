create table if not exists oauth_access_token (
    token_id varchar(255) not null,
    token blob,
    authentication_id varchar(255) default null,
    user_name varchar(255) default null,
    client_id varchar(255) default null,
    authentication blob,
    refresh_token varchar(255) default null,
    primary key (token_id));

create table if not exists oauth_refresh_token (
    token_id varchar(255) not null,
    token blob,
    authentication blob,
    primary key (token_id));