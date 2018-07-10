package com.nuritelecom.jun;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuritelecom.domain.BoardVO;
import com.nuritelecom.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySQLConnectionTest {

	@Inject
	private DataSource ds;

	@Inject
	private BoardDAO dao;

	@Test
	public void testConnection() throws Exception {

		try (Connection con = ds.getConnection()) {

			System.out.println("\n >>>>>>>>>> Connection 출력 : " + con + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void daoTest() {
		try {
			
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			List<BoardVO> list = dao.listAll(1);
			
			System.out.println(list.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	@Test
	public void insert() {
		try {
			
			System.out.println("����");

			for (int i = 0 ; i <2000 ; i++) {
				
				
				BoardVO vo = new BoardVO();
				vo.setTitle("title0"+i);
				vo.setContent("content0"+i);
				vo.setWriter("writer0" +i);
				dao.create2(vo);;
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
