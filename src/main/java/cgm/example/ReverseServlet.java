package cgm.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reverse")
public class ReverseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String querry = request.getParameter("word");
		
		if(querry != null && !"".equals(querry)) {
			if(isGood(querry)) {
				out.println("Result: " + ReverseAlgorithm(querry));
			}
			else {
				out.println("Text has to contain only letters and digits");
			}
		}
		else {
			out.println("Enter any text to form!");
		}
	}
	
	// algorithm 
	private static String ReverseAlgorithm(String text) {
		
		char [] signs = text.toCharArray();
		String subString = "";
		
		for(int i=0; i<signs.length; i++) {
			if(Character.isLetter(signs[i]))
				subString += signs[i];
		}
		
		StringBuffer rev = new StringBuffer(subString);
		rev.reverse();
		subString = rev.toString();
		
		String result ="";
		
		char [] subChars = subString.toCharArray();
		int tmp = 0;
		for(int i=0; i<signs.length; i++) {
			if(Character.isLetter(signs[i])) {
				signs[i] = subChars[tmp];
				tmp+=1;
			}
			result += signs[i];
		}
		
		
		return result;
		
	}
	
	// method finds if text contains only digits and letters
	private static boolean isGood(String text) {
		for(int i=0; i<text.length(); i++)
		{
			if(!Character.isLetterOrDigit(text.charAt(i)))
				return false;
		}
		return true;
	}
	
}
