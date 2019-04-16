package com.test.main;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.java.main.MyBatisUtil;
import com.java.main.User;
import com.java.main.dao.userDAO;

@SuppressWarnings("unused")
public class TestUsers {
	@Test
    public void getUserTest() {
        SqlSession session=MyBatisUtil.getSession();
//        try {
//        	userDAO bookdao=session.getMapper(userDAO.class);
//            List<User> goods=bookdao.getUsers();
//            System.out.println("���"+goods.toString());
//            for(int i =0; i < goods.size(); i++){
//                System.out.println("List��" + i + "λ�ǣ�" + goods.get(i).getUserName());
//             }
//        } finally {
//            session.close();
//        }
      try {
        User goods=session.selectOne("com.java.main.dao.userDAO.getUser","zhong");//�˴���ֵ��ֱ�Ӷ�Ӧ��mapping.xml�ļ���namespace+��Ҫִ�е�sql���id����
        System.out.println("���");
        System.out.println(goods.getPassword()+"List��" + goods.getUserName());
	    } finally {
	        session.close();
	    }
    }
}

