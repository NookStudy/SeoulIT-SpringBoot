import java.util.Date;

public class UnderstandDI {

	public static void main(String[] args) {
		//날짜를 구하기 위해서는 Date클래스의 기능에 의존해야 한다.
		Date date = new Date();
		System.out.println(date);
	}
	
	public static void getDate(Date d) {
		Date date = d;
		System.out.println(date);
	}
	
	public static void memberUse1() {
		//강한결합 : 직접 생성
		//생성자가 Private로 바뀌면 에러발생.
		Member memeber1 = new Member();
	}
	
	public static void memberUse2(Member m) {
		//약한결함 : 생성된 것을 주입 받음 - 의존 주입(Dependencty Injection)
		//생성자가 private로 바뀌어도 어차피 만들어진걸 가져오는거라 ㄴ상관
		//약한결합은 사용하는 프로그래밍은 다른 클래스의 변화에 따른 유동성이 적어진다. 안정적임.
		Member member2 = m;
	}
	
}

class Member{
	String name;
	String nickname;
	public Member() {}
}
