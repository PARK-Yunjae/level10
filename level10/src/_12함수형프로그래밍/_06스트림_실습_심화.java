package _12함수형프로그래밍;

import java.util.ArrayList;
import java.util.List;

class Employee {
	int no; // 사원번호
	String name; // 사원명
	String title; // 직책
	int supNo; // 관리자 사원번호
	String date; // 생년월일
	int salary; // 월급
	int com; // 커미션
	int deNo; // 부서코드

	public Employee(String no, String name, String title, String supNo, String date, String salary, String com,
			String deNo) {
		this.no = Integer.parseInt(no);
		this.name = name;
		this.title = title;
		this.supNo = Integer.parseInt(supNo);
		this.date = date;
		this.salary = Integer.parseInt(salary);
		this.com = Integer.parseInt(com);
		this.deNo = Integer.parseInt(deNo);
	}
}

class Department {

	int no; // 부서코드
	String name; // 부서이름
	String location; // 부서 위치

	public Department(String no, String name, String location) {
		this.no = Integer.parseInt(no);
		this.name = name;
		this.location = location;
	}

}

public class _06스트림_실습_심화 {

	public static void main(String[] args) {
		String[][] deData = { { "10", "ACCOUNTING", "NEW YORK" }, { "20", "RESEARCH", "DALLAS" },
				{ "30", "SALES", "CHICAGO" }, { "40", "OPERATIONS", "BOSTON" } };

		String[][] emData = { { "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" },
				{ "7521", "WARD", "SALESMAN", "7698", "22-2-1981", "1250", "500", "30" },
				{ "7566", "JONES", "MANAGER", "7839", "2-4-1981", "2975", "0", "20" },
				{ "7654", "MARTIN", "SALESMAN", "7698", "28-9-1981", "1250", "1400", "30" },
				{ "7698", "BLAKE", "MANAGER", "7839", "1-5-1981", "2850", "0", "30" },
				{ "7782", "CLARK", "MANAGER", "7839", "9-6-1981", "2450", "0", "10" },
				{ "7788", "SCOTT", "ANALYST", "7566", "13-7-1987", "3000", "0", "20" },
				{ "7839", "KING", "PRESIDENT", "NULL", "17-11-1981", "5000", "1000", "10" },
				{ "7844", "TURNER", "SALESMAN", "7698", "8-9-1981", "1500", "0", "30" },
				{ "7876", "ADAMS", "CLERK", "7788", "13-7-1987", "1100", "0", "20" },
				{ "7900", "JAMES", "CLERK", "7698", "3-12-1981", "950", "0", "30" },
				{ "7902", "FORD", "ANALYST", "7566", "3-12-1981", "3000", "0", "20" },
				{ "7934", "MILLER", "CLERK", "7782", "23-1-1982", "1300", "0", "10" } };

		// 급여는 커미션을 제외해서 계산한다
		List<Department> dList = new ArrayList<Department>();
		List<Employee> eList = new ArrayList<Employee>();

		for (int i = 0; i < deData.length; i += 1) {
			dList.add(new Department(deData[i][0], deData[i][1], deData[i][2]));
		}

		for (int i = 0; i < emData.length; i += 1) {
			eList.add(new Employee(emData[i][0], emData[i][1], emData[i][2], emData[i][3], emData[i][4], emData[i][5],
					emData[i][6], emData[i][7]));
		}

		// [문제 1] 부서별 평균월급여
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");
		
		// [문제 2] 부서별 전체 사원수와 커미션을 받는 사원들의 수
		System.out.println("[문제 2] 부서별 전체 사원수와 커미션을 받는 사원들의 수");
		System.out.println("부서명\t전체 사원 수\t커미션 받는 사원 수");
		
		// [문제 3] 부서별 최대 급여와 최소 급여
		System.out.println("[문제 3] 부서별 최대 급여와 최소 급여");
		System.out.println("부서명\t최대급여\t최소급여");
		
		// [문제 4] 부서번호가 30번인 사원들의 이름, 직급, 부서번호, 부서위치를 조회하시오.
		System.out.println("[문제 4] 부서번호가 30번인 사원들의 이름, 직급, 부서코드, 부서위치");
		System.out.println("이름\t직급\t부서코드\t부서위치");

		// [문제 5] 커미션을 받는 사원의 이름, 커미션, 부서이름,부서위치를 조회하시오.
		System.out.println("[문제 5] 커미션을 받는 사원의 이름, 커미션, 부서이름, 부서위치");
		System.out.println("이름\t커미션\t부서이름\t부서위치");

		// [문제 6] 급여가 높은 순으로 조회하되 급여가 같을 경우 이름의 철자가 빠른 사원순으로 사번,이름,월급여를 조회하시오.
		System.out.println("[문제 6] 급여가 높은 순으로 조회하되 급여가 같을 경우 이름의 철자가 빠른 사원순으로 사번,이름,월급여를 조회하시오.");
		System.out.println("이름\t급여");

		// [문제 7] DALLAS에서 근무하는 사원의 이름,직급,부서번호,부서명을 조회하시오.
		System.out.println("[문제 7] DALLAS에서 근무하는 사원의 이름,직급,부서번호,부서명을 조회하시오.");
		System.out.println("부서명\t평균 급여");

		// [문제 8] 이름에 A 가 들어가는 사원의 이름,부서명을 조회하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 9] ALLEN과 같은 부서에 근무하는 사원의 이름, 부서번호를 조회하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 10] 10번 부서에서 근무하는 사원의 이름과 10번 부서의 부서명을 조회하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 11] 전체 평균 월급여보다 더 많은 월급여를 받은 사원의 사원번호,이름,월급여 조회하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 12] 부서번호가 20인 사원중에서 최대급여를 받는 사원과 동일한 급여를 받는 사원의 사원번호, 이름을 조회하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 13] 사원 테이블에서 사원명과 해당 사원의 관리자명을 검색하시오
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

		// [문제 14] 사원 테이블에서 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여를 검색하시오.
		System.out.println("[문제 1] 부서별 평균월급여");
		System.out.println("부서명\t평균 급여");

	}
}
