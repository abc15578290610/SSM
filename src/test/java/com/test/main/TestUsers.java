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
//            System.out.println("输出"+goods.toString());
//            for(int i =0; i < goods.size(); i++){
//                System.out.println("List第" + i + "位是：" + goods.get(i).getUserName());
//             }
//        } finally {
//            session.close();
//        }
      try {
        User goods=session.selectOne("com.java.main.dao.userDAO.getUser","zhong");//此处的值，直接对应到mapping.xml文件的namespace+需要执行的sql语句id即可
        System.out.println("输出");
        System.out.println(goods.getPassword()+"List第" + goods.getUserName());
	    } finally {
	        session.close();
	    }
    }
}

