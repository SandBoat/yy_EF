package cn.ghy.ef.dao;

import java.sql.SQLException;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import cn.ghy.ef.entity.User;

public class TestUserDao {
	UserDao user;

	@Before
	public void setUP() {
		user = new UserDao();
	}

	@Test
	public void testAdd() {
		// user模型对象
		User userAdd = new User();

		// 为对象赋值
		userAdd.setNickname("ef三剑客2");
		userAdd.setUsername("剑客");
		userAdd.setPassword("222");
		userAdd.setRoleid(2);
		userAdd.setSex(""); // 无法赋值bull
		userAdd.setPhone("");
		userAdd.setEmail("");
		userAdd.setStunumber("");
		userAdd.setRegistertime(new Date());
		userAdd.setStatus(0);

		try {
			// 插入
			user.add(userAdd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		// user模型对象
		User userEdit = new User();
		
		userEdit.setUserid(2);
		userEdit.setNickname("ef三剑客2");
		userEdit.setUsername("剑客");
		userEdit.setPassword("222_test2");
		userEdit.setRoleid(2);
		userEdit.setSex(""); 	// 无法赋值null
		userEdit.setPhone("");
		userEdit.setEmail("");
		userEdit.setStunumber("");
		userEdit.setRegistertime(new Date());
		userEdit.setStatus(0);
		
		try {
			// 修改
			user.edit(userEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
