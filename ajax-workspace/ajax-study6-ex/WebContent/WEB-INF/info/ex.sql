select * from emp_ex;
select * from dept_ex;
select e.empNo from emp_ex e, dept_ex d where e.deptno = d.deptno;
select e.ename, e.sal, d.dname, d.loc from (select empno, ename, sal, deptno from emp_ex) e, dept_ex d where e.deptno  = d.deptno and e.empno = 1;