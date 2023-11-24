create extension if not exists "uuid-ossp";

create table account(
    id uuid primary key default public.uuid_generate_v4(),
    first_name varchar(255),
    email varchar(255) unique not null,
    created_time timestamptz,
    updated_time timestamptz
);

create table category(
     id uuid primary key default public.uuid_generate_v4(),
     name varchar(255) not null,
     parent_id uuid references category(id),
     created_time timestamptz,
     updated_time timestamptz
);

create table advertisement(
    id uuid primary key default public.uuid_generate_v4(),
    status varchar not null default 'ACTIVE',
    title varchar(255),
    description text,
    category_id uuid references category(id),
    owner_id uuid references account(id),
    created_time timestamptz,
    updated_time timestamptz
);


create table transaction(
    id uuid primary key default public.uuid_generate_v4(),
    advertisement_id uuid references advertisement(id),
    seller_id uuid references account(id),
    buyer_id uuid references account(id),
    created_time timestamptz,
    updated_time timestamptz
);

