package edu.web.member;

public interface MemberDAO {
	public abstract int insert(MemberVO vo);
	
	public abstract int checkUser(String userid, String password);
	
	public abstract MemberVO select(String userid);
	
	public abstract MemberVO update(String uerid, MemberVO vo);
	
	public abstract int delete(String userid);
}
