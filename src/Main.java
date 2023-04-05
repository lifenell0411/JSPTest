import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		while (true) {

			System.out.print("명령어 >> ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("article write")) {
				System.out.println("==게시물 작성==");
				int id = lastArticleId + 1;
				String regDate = "2023-12-12 12:12:12";

				System.out.print("제목 ) ");
				String title = sc.nextLine();
				System.out.print("내용 ) ");
				String body = sc.nextLine();
				Article article = new Article(id, regDate, title, body);
				articles.add(article);

				System.out.println(id + "번 글이 작성되었습니다.");
				lastArticleId++;

			}

			else if (cmd.equals("article list")) {
				System.out.println("==게시물 목록==");
				if (articles.size() == 0) {
					System.out.println("게시글이 존재하지 않습니다.");
					continue;
				}

				System.out.println("번호    /    제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.println(article.id + "       /     " + article.title);
				}
			}

			else {
				System.out.println("명령어를 확인해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}
		}
		System.out.println("==프로그램 종료==");
		sc.close();
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;

	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}

}