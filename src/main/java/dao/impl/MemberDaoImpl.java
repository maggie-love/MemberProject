package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		
		//Member m=new Member("a","XX","777","台中市","456","0913");
		//new MemberDaoImpl().addMember(m);
		System.out.println(new MemberDaoImpl().findByUsername("6"));
	}

	private static Connection conn=DbConnection.getDb();

	@Override
	public void addMember(Member member) {
		/*
		 * 1.SQL語法
		 * 2.交給PreparedStatement
		 * 3.executeUpdate
		 */
		
		String SQL="insert into member(name,username,password,address,phone,mobile) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatemnt=conn.prepareStatement(SQL);
			preparedStatemnt.setString(1, member.getName());
			preparedStatemnt.setString(2, member.getUsername());
			preparedStatemnt.setString(3, member.getPassword());
			preparedStatemnt.setString(4, member.getAddress());
			preparedStatemnt.setString(5, member.getPhone());
			preparedStatemnt.setString(6, member.getMobile());
			preparedStatemnt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Member findByUsernameAndPassword(String username, String password) {
		
		/*
		 * 1.SQL語法
		 * 2.Preparedstatement-->executeQuery()
		 * 3.ResultSet-->Member
		 * 
		 */
		String  SQL="select * from member where username=? and password=?";
		Member member=null;
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet  resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				member=new Member();
				member.setId(resultSet.getInt("id"));
				member.setName(resultSet.getString("name"));
				member.setUsername(resultSet.getString("username"));
				member.setPassword(resultSet.getString("password"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setMobile(resultSet.getString("mobile"));
			
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public boolean findByUsername(String username) {
		/*
		 * 1.SQL語法,boolean變數
		 * 2.PreparedStatement-->executeQuery
		 * 3.ResultSet-->true/false
		 */
		String  SQL="select * from member where username=? ";
		boolean isUsernameBeenUse=false;
		Member m=null;
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SQL);
			preparedStatement.setString(1, username);			
			ResultSet  resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) isUsernameBeenUse=true;
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return isUsernameBeenUse;
	}

}
