package blog;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogMain {

	public static void main(String[] args) {

		Reader reader;
		SqlSessionFactory ssf;
		SqlSession ss = null;

		try {
			reader = Resources.getResourceAsReader("conf/configuration.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			ss = ssf.openSession();

			// 1. blog테이블에 5개 행 입력
			for (int i = 1; i <= 5; i++) {
				Blog blog1 = new Blog(0, "블로그제목"+i, "블로그내용"+i, null, null, 0);
				ss.insert("insertBlog", blog1);
				ss.commit();
			}
			
			// 2. blog 행의 수 출력
			int listCount = ss.selectOne("countBlog");
			System.out.println("blog 행의 수 : " + listCount);
			
			// 3. blog 5번째 행 수정
			Blog blog2 = new Blog(5, "새로운 블로그제목", "새로운 블로그내용", null, null, 0);
			ss.update("updateBlog", blog2);
			ss.commit();
			
			// 4. blog 5번째 행 삭제
			ss.delete("deleteBlog", 5);
			ss.commit();
			
			// 5. 조인된 blog 리스트
			List<Blog> blogList = ss.selectList("selectBlog");
			System.out.println(blogList);

			for (Blog blog : blogList) {
				System.out.println("blog_id : " + blog.getBlogId());
				Author author = blog.getAuthor();
				System.out.println("\tauthor : " + author);
				List<Comment> commList = blog.getComms();
				for (Comment comm : commList) {
					System.out.println("\t" + comm);
				}
			}
			
			// 6. comment 리스트 검색
			CommentSearcher cs = new CommentSearcher(1, "content", "내용");
			List<Comment> commentList = ss.selectList("selectCommsByBlogId", cs);
			for (Comment comment : commentList) {
				System.out.println(comment);
			}
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

	}

}
