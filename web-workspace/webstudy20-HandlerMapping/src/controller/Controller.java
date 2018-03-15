package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Controller 구현체들이 구현하는 Interface
 * @author kosta
 *
 */
public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
