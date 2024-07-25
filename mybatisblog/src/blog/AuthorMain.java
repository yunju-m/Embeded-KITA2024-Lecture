package blog;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AuthorMain {

	public static void main(String[] args) {

		Reader reader;
		SqlSessionFactory ssf;
		SqlSession ss = null;

		try {
			reader = Resources.getResourceAsReader("conf/configuration.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			ss = ssf.openSession();

			// 1. author테이블에 5개 행 입력
			for (int i = 1; i <= 5; i++) {
				Author author = new Author(0, "작성자"+i, i);
				ss.insert("insertAuthor", author);
				ss.commit();
			}

			// 2. author 행의 수 출력
			int listCount = ss.selectOne("countAuthor");
			System.out.println("Author 행의 수 : " + listCount);

			// 3. author의 5번째 행 수정
			Author author = new Author(5, "새로운 작성자", 1);
			ss.update("updateAuthor", author);
			ss.commit();

			// 4. author 5번째 행 삭제
			ss.delete("deleteAuthor", 5);
			ss.commit();

		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(ss != null) {
				ss.close();
			}
		}
	}

}
