package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;
import service.ExcelFileStorage;
import utility.CheckBlogPost;


@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers")	;
		System.out.println(blogDetails);
		String[] userBlog=blogDetails.split(",");
		String title = userBlog[0];
		String description = userBlog[1];
		LocalDate postedOn = LocalDate.now();
		
		User user = null;
		Blog blog=new Blog(title,description,postedOn);
		System.out.println(title);
		System.out.println(description);
		
		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setDate(postedOn);
		
		CheckBlogPost checkBlog=new CheckBlogPost();
		boolean check=checkBlog.checkBlog(blog);
		
		ExcelFileStorage excel=new ExcelFileStorage();
		excel.insertBlog(blog);
		
		System.out.println(check);
		if(check) {
			
			request.setAttribute("blog", blog);
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message","Your blog contains offensive words. Please use appropriate words.");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}
