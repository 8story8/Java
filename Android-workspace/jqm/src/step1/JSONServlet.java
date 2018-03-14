package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out=response.getWriter();
		String flag=request.getParameter("flag");
		System.out.println(flag);
		ArrayList list=new ArrayList();
		if(flag.equals("한식")){
			list.add("김밥천국");list.add("죠스떡볶이");list.add("태성골뱅이");
		}else if(flag.equals("중식")){
			list.add("동천홍");list.add("콩짜장");list.add("중화루");
		}else if(flag.equals("일식")){
			list.add("미가");list.add("나가사키");list.add("쿠노이치");
		}
		JSONArray array=new JSONArray(list);
		out.print(array.toString());
		out.close();
	}
}











