package decorator;

import org.displaytag.decorator.TableDecorator;

import beans.UserDTO;

public class WrapperUsers extends TableDecorator {
	
	public String getImage() {
		UserDTO ud = (UserDTO) getCurrentRowObject();
		String img = "<img src='images/header/icons/user0.png'>";
		String ancla = "<a href='AdminPage?option=admUser'" + ud.getIdUsu() + ">" + img + "</a>";
		return ancla;
	}
	
	/*public String getUsername() {
		String box = "<input type='text' min='1' max='25'>";
		return box;
	}
	
	public String getPassword() {
		String box = "<input type='password' min='1' max='25'>";
		return box;
	}
	*/
}
