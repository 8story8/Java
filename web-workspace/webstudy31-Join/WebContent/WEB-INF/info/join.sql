select * from dept;
select * from emp;

select * from emp_ex e, dept_ex d where e.deptno = d.deptno;

-- Group By : 데이터들을 원하는 그룹으로 집계하기 위해 사용
-- 부서별로 사원수를 집계
select deptno, count(*) emp_count
from emp
group by deptno
order by emp_count asc;

-- 부서별 사원의 평균 월급(반올림) 조회, 평균월급 내림차순으로
-- 부서번호, 평균월급
select deptno, round(avg(sal)) avg_sal
from emp
group by deptno
order by avg_sal desc;

-- 부서번호 deptno, 부서명 dname, 부서별 사원수 emp_count, 부서별 평균월급 avg_sal
select e.deptno, d.dname, e.emp_count, e.avg_sal from (
	select deptno, count(*) emp_count, round(avg(sal)) avg_sal from emp 
	group by deptno
) e, dept d
where e.deptno = d.deptno
order by e.avg_sal desc;



