package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TPermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7512049132416900243L;
		//id
		private int id;
		//Ȩ����
		private String pname;
		//�ϼ�id
		private int pid;
		//�㼶
		private int lev;
		//�Ƿ�Ҷ��
		private int isleaf;
		//˳��
		private int sort;
		//·��
		private String url;
		//ͼ��
		private String icon;
		//��Ȩ�޼�
		private List<TPermission> children = new ArrayList<>();
		//����һ����Ȩ��
		public void addChild(TPermission permission) {
			children.add(permission);
		}
		
		public List<TPermission> getChildren() {
			return children;
		}

		public void setChildren(List<TPermission> children) {
			this.children = children;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public int getLev() {
			return lev;
		}
		public void setLev(int lev) {
			this.lev = lev;
		}
		public int getIsleaf() {
			return isleaf;
		}
		public void setIsleaf(int isleaf) {
			this.isleaf = isleaf;
		}
		public int getSort() {
			return sort;
		}
		public void setSort(int sort) {
			this.sort = sort;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		@Override
		public String toString() {
			return "TPermission [id=" + id + ", pname=" + pname + ", pid=" + pid + ", lev=" + lev + ", isleaf=" + isleaf
					+ ", sort=" + sort + ", url=" + url + ", icon=" + icon + "]";
		}
}