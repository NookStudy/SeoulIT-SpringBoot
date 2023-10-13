drop table myuser;
create table myuser (
    id varchar2(10),
    name varchar2(10)
);

– 샘플 데이터 직접 추가하기
insert into myuser values ( 'test1', '홍길동1');
insert into myuser values ( 'test2', '홍길동2');
insert into myuser values ( 'test3', '홍길동3');
commit;
