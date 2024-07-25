package blog;

import java.io.IOException;
import java.io.Reader;

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
				Blog blog = new Blog(0, "블로그제목"+i, "블로그내용"+i, null, null, 0);
				ss.insert("insertBlog", blog);
				ss.commit();
			}
			
			// 2. blog 행의 수 출력
			int listCount = ss.selectOne("countBlog");
			System.out.println("blog 행의 수 : " + listCount);
			
			// 3. blog 5번째 행 수정
			Blog blog = new Blog(5, "새로운 블로그제목", "새로운 블로그내용", null, null, 0);
			ss.update("updateBlog", blog);
			ss.commit();
			
			// 4. blog 5번째 행 삭제
			ss.delete("deleteBlog", 5);
			ss.commit();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

	}

}
