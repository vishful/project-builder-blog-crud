package utility;

import model.Blog;

public interface OffensiveWordsInterface {
	boolean checkBlogTitle(Blog blog);
	boolean checkBlogDescription(Blog blog);
}
