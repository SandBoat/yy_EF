package cn.ghy.ef.util;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DBHelper {
	
	private static DataSource _dataSource;
	private final static Logger _log=LoggerFactory.getLogger(DBHelper.class);
	
	static{
		Properties profile=new Properties();
		InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("dbcp.properties");
		DataSource ds;
		try {
			profile.load(in);
			ds = BasicDataSourceFactory.createDataSource(profile);
			_log.info("Connect is OK {}", ds.getConnection().toString());
			_dataSource=ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static <E> List<E> executeQuery(Class<E> clazz,String sql,Object...params) throws SQLException{
		QueryRunner run = new QueryRunner(_dataSource);
		ResultSetHandler<List<E>> rsh=new BeanListHandler<E>(clazz);
		return run.query(sql, rsh, params);
	}
	
	// insert update delete
	// 将对象params中的参数用来替换sql语句中的占位符
	public static <E> int executeUpdate(Class<E> clazz,String sql,Object...params) throws SQLException{
		QueryRunner run = new QueryRunner(_dataSource);
		return run.update(sql, params);
	}
}
