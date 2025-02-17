package org.saiden.springmvc12;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.saiden.springmvc12.model.CarService;
import org.saiden.springmvc12.model.CarVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *    TDD : 테스트 주도 개발(Test-Driven Development, TDD)은 
 *            매우 짧은 개발 사이클을 반복하는 소프트웨어 개발 프로세스
 *            
 *    JUnit : Java 단위 테스트를 위한 TDD 프레임워크
 *    
 *    아래 Library가 Maven의 pom.xml에 추가되어야 한다. 
 *    
 *      <!-- spring junit  -->
  		<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${org.springframework-version}</version>            
        </dependency>

		<!-- Test : 기존 4.7에서 4.9로 수정 -->
  		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.9</version>
   			<scope>test</scope>
  		</dependency>  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-*.xml" })
public class TestUnit {
	@Resource
	private CarService carService;

	@Test
	public void test() {
		List<CarVO> list = carService.getAllCarList();
		for(CarVO carVO : list){
			System.out.println(carVO);
		}
	}
}
