create table if not exists item_model (
  id identity,
  name varchar(50) not null,
  brand varchar(50),
  year_of_creation int not null,
  price numeric not null,
  created_at integer not null
);