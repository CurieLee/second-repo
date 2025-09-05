<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% 
	try { 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_address="jdbc:oracle:thin:@localhost:1521:sdb";
		String db_username="SQL_USER"; 
		String db_pwd="1234";
		
		Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
		
		String insertQuery = "SELECT MAX(num) FROM practice_board";
		PreparedStatement pstmt = connection.prepareStatement(insertQuery);
		ResultSet result = pstmt.executeQuery(); // 조회된 데이터가 반환되면
		
		int num = 0;
		
		while (result.next()) {
			num = result.getInt("MAX(num)") + 1; // 신규등록 게시글 번호로 사용
		}
		
		Timestamp today_date = new Timestamp(System.currentTimeMillis());
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		insertQuery = "INSERT INTO practice_board(num, writer, title, content, regdate) VALUES(?, ?, ?, ?, ?)";
		
		pstmt = connection.prepareStatement(insertQuery);
		pstmt.setInt(1, num);
		pstmt.setString(2, writer);
		pstmt.setString(3, title);
		pstmt.setString(4, content);
		pstmt.setTimestamp(5, today_date);
		
		pstmt.executeUpdate();
		
		// post_new.jsp 저장 버튼 클릭-> 요청-> post_new_send.jsp DB 에 데이터 저장-> post_list.jsp 반환
		response.sendRedirect("post_list.jsp"); 
		
	} catch (Exception ex) { 
		out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
%>