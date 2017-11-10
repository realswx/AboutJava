package com.qtech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qtech.entity.Company;
import com.qtech.entity.Student;
import com.qtech.util.DBUtil;

public class CompanyDAO {

	public List<Company> getAllCompany(int currentpageindex) {
		// TODO Auto-generated method stub
		List<Company> companies=new ArrayList<Company>();
		DBUtil dbUtil = new DBUtil();
		Connection conn=dbUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tb_company limit ?,8");
			ps.setInt(1, currentpageindex*8-8);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Company company=new Company();
				company.setC_id(rs.getInt("company_id"));
				company.setC_name(rs.getString("company_name"));
				company.setC_area(rs.getString("company_area"));
				company.setC_size(rs.getString("company_size"));
				company.setC_type(rs.getString("company_type"));
				company.setC_brief(rs.getString("company_brief"));
				company.setC_state(rs.getInt("company_state"));
				company.setC_sort(rs.getInt("company_sort"));
				company.setC_viewnum(rs.getInt("company_viewnum"));
				company.setC_pic(rs.getString("company_pic"));
				//System.out.println(company.toString());
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}
	public static void insertCompany(String companyName,String companyArea,String companySize,String companyType,String companyBrief,String companyState,String companySort,String companyPic) throws SQLException{
		String sql = "insert into tb_company values(4,'"+companyName+"','"+companyArea+"','"+companySize+"','"+companyType+"'";
		if(companyBrief==null){
			sql+=",'"+null+"'";
		}else{
			sql+=",'"+companyBrief+"'";
		}
		sql+=","+companyState;
		if(companySort==null){
			sql+=","+0;
		}else{
			sql+=","+companySort;
		}
		sql+=",'0'";
		sql+=",'"+companyPic+"')";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		System.out.println(sql);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
	}
	public void updateCompany(String companyid,String companyName, String companyArea,
			String companySize, String companyType, String companyBrief,
			String companyState, String companySort, String companypic) throws SQLException {
		String sql = "update tb_company set company_Name='"+companyName+"',company_area='"+companyArea+"',company_size='"+companySize+"',company_type='"+companyType+"',company_brief='"+companyBrief+"',company_state="+companyState+",company_sort="+companySort+",company_pic='"+companypic+"' where company_id="+companyid;
		System.out.println(sql);
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		System.out.println(sql);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println();
	}
}
