package cn.ghy.ef.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.ghy.ef.entity.User;
import cn.ghy.ef.util.DBHelper;

public class UserDao {

	public static List<User> getAll() throws SQLException {
		String sql = "select * from ef_user where status=?";
		return DBHelper.executeQuery(User.class, sql, 1);
	}

	public boolean add(User entry) throws SQLException {
		String sql = "insert into ef_user(nickname,username,password,roleid,sex,phone,email,stunumber,registertime,status) values (?,?,?,?,?,?,?,?,?,?)";

		// 为sql语句 添加参数
		 Object params[] = { entry.getNickname(), entry.getUsername(),
		 entry.getPassword(), entry.getRoleid(), entry.getSex(),
		 entry.getPhone(), entry.getEmail(), entry.getStunumber(),
		 entry.getRegistertime(), entry.getStatus()};

		int resultNum = DBHelper.executeUpdate(User.class, sql, params);
		return resultNum > 0 ? true : false;
	}

	public boolean edit(User entry) throws SQLException {
		String sql = "update ef_user set nickname = ?,username = ?,password = ?,phone = ?,email = ? where userid = ? ";
		
		Object params[] = { entry.getNickname(), entry.getUsername(), entry.getPassword(), entry.getPhone(),
				entry.getEmail(), entry.getUserid() };

		int resultNum = DBHelper.executeUpdate(User.class, sql, params);
		return resultNum > 0 ? true : false;
	}
}
