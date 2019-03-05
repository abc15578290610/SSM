package com.java.main;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.java.main.dao.userDAO;
public class TestUsers {
	@Test
    public void getUserTest() {
        SqlSession session=MyBatisUtil.getSession();
//        try {
//        	userDAO bookdao=session.getMapper(userDAO.class);
//            List<User> goods=bookdao.getUser();
//            System.out.println("���"+goods.toString());
//            for(int i =0; i < goods.size(); i++){
//                System.out.println("List��" + i + "λ�ǣ�" + goods.get(i).getName());
//             }
//        } finally {
//            session.close();
//        }
        
      try {
        List<User> goods=session.selectList("com.java.main.mapper.mapper.getUser");
        System.out.println("���"+goods.toString());
        for(int i =0; i < goods.size(); i++){
            System.out.println("List��" + i + "λ�ǣ�" + goods.get(i).getName());
         }
	    } finally {
	        session.close();
	    }
    }
}
