package kr.ac.shinhan;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class updateTeam extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
	String id=req.getParameter("id");
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		TeamMember m = MemberManager.getMember(id);
		
		
		resp.getWriter().println("<html>"); 
		resp.getWriter().println("<body>"); 
		 		resp.getWriter().println("<h1> Update Member </h1>"); 
			resp.getWriter().println("<form method='Get' action='/updateMember'>"); 
				resp.getWriter().println("<tr> �̸� : </tr> <tr> <input type='text' name='name' value=" + m.getName() + "> </tr> </br>"); 
		 		resp.getWriter().println("<tr> �й� : </tr> <tr> <input type='text' name='id' value=" + m.getid() + "> </tr> </br>"); 
				resp.getWriter().println("<tr> ��ȭ��ȣ : </tr> <tr> <input type='text' name='tel' value=" + m.gettel() + "> </tr> </br>"); 
			resp.getWriter().println("<tr> ���� : </tr> <tr> <input type='text' name='mail' value=" + m.getmail() + "> </tr> </br>"); 
		 		resp.getWriter().println("<tr> ī�� ID : </tr> <tr> <input type='text' name='katok' value=" + m.getkatok() + "> </tr> </br>"); 
		 		if(m.getcip() == null) { 
		 			resp.getWriter().println("<tr> ���忩�� : </tr> <tr> <input type='checkbox' name='cip'> </tr> </br>"); 
		 		} else {
		 			resp.getWriter().println("<tr> ���忩�� : </tr> <tr> <input type='checkbox' name='cip' checked='checked'> </tr> </br>"); 
		 		}
		 		resp.getWriter().println("<tr> GitID : </tr> <tr> <input type='text' name='gitid' value=" + m.getgitid() + "> </tr> </br>"); 
		 		resp.getWriter().println("<td> <input type='submit' value='��������' </td>"); 
	 		resp.getWriter().println("</from>");		 
		 		resp.getWriter().println("</body>"); 
		 		resp.getWriter().println("</html>"); 

		
	}
	
}