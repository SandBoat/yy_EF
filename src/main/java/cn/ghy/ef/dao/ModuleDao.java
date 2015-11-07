package cn.ghy.ef.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ghy.ef.entity.Module;
import cn.ghy.ef.util.DBHelper;

public class ModuleDao {

	public List<Module> read() throws SQLException {
		String sql = "select * from ef_user where status=?";
		return DBHelper.executeQuery(Module.class, sql, 1);
	}

	public boolean add(Module entry) throws SQLException {
		String sql = "insert into ef_user(modulename,parentid,childrenid,status) values (?,?,?,?)";

		// 为sql语句 添加参数
		Object params[] = { entry.getModulename(), entry.getParentid(), entry.getChildrenid(), entry.getStatus() };

		int resultNum = DBHelper.executeUpdate(Module.class, sql, params);
		return resultNum > 0 ? true : false;
	}

	// // 默认除moduleid外所有字段值皆可修改
	public boolean edit(Module entry) throws SQLException {
		String sql = "update ef_user set modulename = ?,parentid = ?,childrenid = ?,status = ? where moduleid = ? ";

		Object params[] = { entry.getModulename(), entry.getParentid(), entry.getChildrenid(), entry.getStatus(),
				entry.getModuleid() };

		int resultNum = DBHelper.executeUpdate(Module.class, sql, params);
		return resultNum > 0 ? true : false;
	}

}
