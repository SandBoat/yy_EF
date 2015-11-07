package cn.ghy.ef.entity;

public class Role {
	private Integer roleid;
	private String rolename;
	private String authority;
	private Integer status;
	/*
	 * authority - 权限  格式化字符串
	 * 格式: moduleid:action,moduleid:action...
	 * 例如：1:write,5:modify,11:read
	 * */
}
