package utility;

import model.Blog;

public class CheckBlogPost extends OffensiveWordsChecker implements OffensiveWordsInterface {


	public boolean checkBlogTitle(Blog blog) {
		
		return true;
	}

	
	public boolean checkBlogDescription(Blog blog) {
		
		return true;
	}

	@Override
	public boolean checkBlog(Blog blog) {
	if(checkBlogTitle(blog)&& checkBlogDescription(blog)) 
		return true;
	else
		return false;
	}

}
