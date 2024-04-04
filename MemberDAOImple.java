package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBConnection {
	private static MemberDAOImple instance = null;

	private MemberDAOImple() {

	}

	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public int checkUser(String userid, String password) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_CHECK_USER);

			pstmt.setString(1, userid);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

@Override
public MemberVO select(String userid) {
	MemberVO vo = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	System.out.println(userid + "값 입니다");

	try {
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("드라이버 로드 성공");

		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");

		pstmt = conn.prepareStatement(SQL_SELECT);
		
		rs = pstmt.executeQuery();

		if (rs.next()) { // 레코드가 존재할 때까지
			userid = rs.getString(1); 
			String password = rs.getString(2); 
			String email = rs.getString(3); 
			String emailAgree = rs.getString(4); 
			String interestString =rs.getString(5);
			System.out.println(interestString);
			String[] interest = interestString.split(",");
				String phone = rs.getString(6);
				String introduce = rs.getString(7);

			vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		}

	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return vo;
}

@Override
public MemberVO update(String userid,MemberVO vo ) {
	MemberVO updatevo = null;
	
	System.out.println("update 실행 시작");
	Connection conn = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
	// Statement와 상속관계

	try {
		// 2. Oracle JDBC 드라이버를 메모리에 로드
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("드라이버 로드 성공");

		// 3. DB와 Connection(연결)을 맺음
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");

		// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
		pstmt = conn.prepareStatement(SQL_UPDATE);

		// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
		pstmt.setString(1, vo.getPassword());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getEmailAgree());
		pstmt.setString(4, vo.getInterestJoin());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getIntroduce());
		pstmt.setString(7, userid);


		// 6. SQL 문장 실행(DB 서버로 SQL 전송)
		pstmt.executeUpdate();

		// 7. DB 서버가 보낸 결과 확인/처리
		System.out.println("수정완료.");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return updatevo; 

}

@Override
public int delete(String userid) {
	int result = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
	// Statement와 상속관계

	try {
		// 2. Oracle JDBC 드라이버를 메모리에 로드
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("드라이버 로드 성공");

		// 3. DB와 Connection(연결)을 맺음
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");

		// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
		pstmt = conn.prepareStatement(SQL_DELETE);

		// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
		pstmt.setString(1, userid);
	

		// 6. SQL 문장 실행(DB 서버로 SQL 전송)
		result = pstmt.executeUpdate();

		// 7. DB 서버가 보낸 결과 확인/처리
		System.out.println(result + "행이 삭제됐습니다.");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return result; // 0 : 실패, 1 : 성공
}
	

}