drop table simple_bbs;
create table simple_bbs (
    id number(4) primary key,
    writer varchar2(100),
    title varchar2(100),
    content varchar2(100)
);

drop sequence simple_bbs_seq;
create sequence simple_bbs_seq;


insert into simple_bbs values(simple_bbs_seq.nextval,'홍길동','제목','냉무');

commit;