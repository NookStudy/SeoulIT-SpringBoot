create table Transaction1 (
    consumerId varchar2(10),
    amount number
);

create table Transaction2 (
    consumerId varchar2(10),
    amount number
);

create table Transaction3 (
    consumerId varchar2(10),
    amount number
);

delete transaction2 where consumerid = '길동이';

commit;