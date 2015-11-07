package cn.ghy.ef.entity;
/*
 * 模块 - 系统模块以及子模块、子网模块以及子模块等等
 * 树形结构
 * */

public class Module {
	private Integer moduleid;
	private String modulename;
	private Integer parentid;//父模块id，顶级模块为0
	private String childrenid;//子模块用|分隔
	private Integer status;
}
