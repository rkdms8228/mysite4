package com.javaex.vo;

public class UserVo {
	
	//필드
	private int no;
	private String id;
	private String pw;
	private String name;
	private String gender;
	
	
	//생성자
	public UserVo() {}
	
	public UserVo(int no, String id, String pw, String name, String gender) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
	}
	
	//메소드-gs
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + "]";
	}

}
