  insert into dbt.users ( first_name, password)
        values ('user', '$2a$12$ENAAz26.lGK7IpHGRhOq5OfXw4geKU5ScLBChm1o3SR4PAVnu82Hy');

insert into dbt.roles (role_name) value ('ROLE_USER');
insert into dbt.roles (role_name) value ('ROLE_ADMIN');

insert into dbt.users_roles (user_id, role_id) VALUES (1, 1);
insert into dbt.users_roles (user_id, role_id) VALUES (2, 1);
insert into dbt.users_roles (user_id, role_id) VALUES (2, 2);

insert into dbt.users (first_name, password)
values ('admin', '$2a$12$eoIh3U2njGPs1QS1bpX3nuaYxensxXpe9gR7kk/EWovtAUhxMEiaa');

