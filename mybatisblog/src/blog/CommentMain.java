package blog;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentMain {

	public static void main(String[] args) {

		Reader reader;
		SqlSessionFactory ssf;
		SqlSession ss = null;

		try {
			reader = Resources.getResourceAsReader("conf/configuration.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			ss = ssf.openSession();

			// 1. comment테이블에 5개 행 입력
			for (int i = 1; i <= 5; i++) {
				Comment comment = new Comment(0, "댓글제목"+i, "댓글내용"+i, i);
				ss.insert("insertComment", comment);
				ss.commit();
			}

			// 2. author 행의 수 출력
			int listCount = ss.selectOne("countComment");
			System.out.println("Comment 행의 수 : " + listCount);

			// 3. author의 5번째 행 수정
			Comment comment = new Comment(5, "새로운 댓글제목", "새로운 댓글내용", 5);
			ss.update("updateComment", comment);
			ss.commit();

			// 4. author 5번째 행 삭제
			ss.delete("deleteComment", 5);
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
