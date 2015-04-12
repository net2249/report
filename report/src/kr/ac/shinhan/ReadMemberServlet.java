package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReadMemberServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws IOException{
		String name = req.getParameter("name");
		
		List<TeamMember> namedMemberList = MemberManager.getMemberByName(name);
		TeamMember m= namedMemberList.get(0);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		resp.getWriter().println("<html>"); 
		resp.getWriter().println("<body>");	
		resp.getWriter().println("�̸� : "+m.getName() +"</br>");
		resp.getWriter().println("�й� : "+m.getid() +"</br>"); 
		resp.getWriter().println("��ȭ : "+m.gettel() +"</br>"); 
		resp.getWriter().println("���� : "+m.getmail() +"</br>"); 
		resp.getWriter().println("ī�� ID : "+m.getkatok() +"</br>"); 
				
		if(m.getcip()==null)
			resp.getWriter().println("���� �ƴ�"+"</br>");
		else
			resp.getWriter().println("����"+"</br>");
		
		resp.getWriter().println("GitHub ID : "+m.getgitid() +"</br>"); 

		
		resp.getWriter().println("<form method='Post' action='/index.html'>"); 
		resp.getWriter().println("<td> <input type='submit' value='ó������' </td>"); 
	resp.getWriter().println("</from>"); 
		resp.getWriter().println("</html>"); 
		resp.getWriter().println("</body>");
		
		
		
	}

}
