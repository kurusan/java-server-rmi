package com.bank.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.util.RequestBuilder;
import com.bank.util.DbUtils;

public final class CommonDAO{
	
	public CommonDAO (){
		try {
			DbUtils.getConnection();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public <Type> ArrayList<Type> select (Class<Type> type, String tableName, String whereClause) {
		
		try {
			return RequestBuilder.<Type>getObjectList(type, tableName, whereClause);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert (Object object, String tableName) {
		try {
			PreparedStatement prepState = RequestBuilder.buildInsertStatement(object, tableName);
			return prepState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1;
	}
	

	public int update (Object object, String tableName, String whereClause) {
		try {
			PreparedStatement prepState = RequestBuilder.buildUpdateStatement(object, tableName, whereClause);
			return prepState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1;
	}

	public int delete(Object object, String tableName, String whereClause) {
		try {
			PreparedStatement prepState = RequestBuilder.buildDeleteStatement(object, tableName, whereClause);
			return prepState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1;
	}
}
