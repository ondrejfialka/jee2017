package cz.ucl.jee;

import org.springframework.stereotype.Service;

@Service
public class LoginService
{
		public String validateUser(LoginBean loginBean)
		{
				String userName = loginBean.getUserName();
				String password = loginBean.getPassword();
				if(userName.equals("user") && password.equals("heslo"))
				{
						return "true";
				}
				else
				{
						return "false";
				}
		}
		
}
