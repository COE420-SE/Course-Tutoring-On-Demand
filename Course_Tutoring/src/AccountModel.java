
public class AccountModel {

	private static String username = "g00076147";
	private static String password = "1234";
	public static boolean validateUser(String user,String pwd){  
		if(user.equals(username) && pwd.equals(password)) {
			System.out.println("details in model received "+ user + pwd);
			return true;
		}else {
			return false;
		}

	}
}
