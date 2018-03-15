package test;

public class TestUnit {

	public static void main(String[] args) {
		String url = "redirect:find_ok.jsp";
		if(url.trim().startsWith("redirect:")){
			System.out.println("Redirect O");
			System.out.println(url.trim().substring(9));
		}
		else{
			System.out.println("Redirect X");
		}
	}
}
