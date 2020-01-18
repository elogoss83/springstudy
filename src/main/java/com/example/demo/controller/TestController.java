package com.example.demo.controller; // 해당 클래스가 어떤 패키지(폴더구조)에 속하는지를 의미

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

// import는 미리 완성된 코드들을 불러서 TestController 클래스에서 사용하겠다는 의미.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	// 요청 url : hi
	// 응답 : hi
	@RequestMapping("/hi") // 서버로 url이 'hi'인 요청이 오면 hi() 메서드를 실행하여 응답하겠다는 의미. 결과는 hi라는 문자가 브라우저에 출력됨
	@ResponseBody // 메서드가 리턴하는 값을 문자 그대로 브라우저에 보여주겠다는 의미
	String hi() {
		return "hi";
	}

// 요청 url : bye
	// 응답 : bye
	@RequestMapping("/bye") // 서버로 url이 'bye'인 요청이 오면 bye() 메서드를 실행하여 응답하겠다는 의미. 결과는 bye라는 문자가 브라우저에 출력됨
	@ResponseBody
	String bye() {
		return "bye";
	}

	// 요청 url : what-is-your-name"
	// 응답 : 자신의 이름
	@RequestMapping("/what-is-your-name") // 서버로 url이 'what-is-your-name'인 요청이 오면 myName() 메서드를 실행하여 응답하겠다는 의미. 결과는 자신의
											// 이름이 브라우저에 출력됨
	@ResponseBody
	String myName() {
		return "이병현";
	}

	// 요청 url : 2dan
	// 응답 : 구구단 2단
	@RequestMapping("/2dan") // 서버로 url이 '2dan'인 요청이 오면 dan2() 메서드를 실행하여 응답하겠다는 의미. 결과는 구구단 2단이 브라우저에 출력됨
	@ResponseBody
	String dan2() {
		String s = "2dan<br>";
		for (int i = 1; i < 10; i++) {
			s += String.valueOf("2 * " + i + " = " + i * 2 + "<br>");
		}
		return s;
	}

	// 요청 url : kukudan
	// 응답 : 구구단 1~9단
	@RequestMapping("/kukudan") // 서버로 url이 'kukudan'인 요청이 오면 kukudan() 메서드를 실행하여 응답하겠다는 의미. 결과는 구구단 9단까지 브라우저에
								// 출력됨
	@ResponseBody
	String kukudan() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			for (int t = 1; t < 10; t++) {
				sb.append(String.valueOf(i + " * " + t + " = " + i * t + "<br>"));
			}
		}
		return sb.toString();
	}

	// 요청 url : int_arr
	// 응답 : 숫자 배열 [100, 200, 300]
	@RequestMapping("/int_arr")
	@ResponseBody
	String int_arr() {
		return "[100, 200, 300]";
	}

	@RequestMapping("/int-arr")
	@ResponseBody
	int[] fun6() {
		int[] arr = new int[3];

		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;

		return arr;
	}

	// 요청 url : http://localhost:9999/printDan1
	// 클라이언트에게 받은 값에 해당하는 구구단을 출력해주세요.
	@RequestMapping("printDan1")
	@ResponseBody
	String printDan1(String dan) {
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(dan);
		for (int t = 1; t < 10; t++) {
			sb.append(i + " * " + t + " = " + i * t + "<br>");
		}
		return sb.toString();
	}

	// 요청 url : http://localhost:9999/printDan2
	// 클라이언트에게 받은 값1에 해당하는 구구단을 클라이언트에게 받은 값2 만큼만 출력해주세요.

	@RequestMapping("printDan2")
	@ResponseBody
	String printDan2(String dan, String limit) {
		int d = Integer.parseInt(dan);
		int l = Integer.parseInt(limit);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= l; i++) {
			sb.append(d + " + " + i + " = " + d * i + "<br>");
		}
		return sb.toString();
	}

	/*
	 * 문제 : 아래와 같이 작동 되어야 합니다.
	 * 
	 * http://localhost:8081/home/addNumber?num=111 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/addNumber?num=222 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/addNumber?num=333 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/addNumber?num=444 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/addNumber?num=555 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/addNumber?num=666 // 출력 => 추가되었습니다.
	 * http://localhost:8081/home/showAllNumbers // 출력 => [111,222,333,444,555,666]
	 */
	ArrayList<Integer> list = new ArrayList<Integer>();

	@RequestMapping("/addNumber")
	@ResponseBody
	String addNumber(String num) {
		this.list.add(Integer.parseInt(num));
		return "추가되었습니다.";
	}

	@RequestMapping("/showAllNumbers")
	@ResponseBody
	ArrayList<Integer> showAllNumbers() {
		return this.list;
	}

	int lastId = 0;
	ArrayList<HashMap<Object, Object>> Articles = new ArrayList<HashMap<Object, Object>>();

	@RequestMapping("/home/addArticle")
	@ResponseBody
	String addArticle(String title, String body) {
		this.lastId++;
		HashMap<Object, Object> map = new HashMap<>();
		map.put("id", this.lastId);
		map.put("title", title);
		map.put("body", body);
		Articles.add(map);
		
		return String.valueOf(this.lastId + "번 글이 생성되었습니다.");
	}

	@RequestMapping("/home/getArticles")
	@ResponseBody
	ArrayList<HashMap<Object, Object>> getArticles() {

		return this.Articles;
	}

	@RequestMapping("/home/delArticles")
	@ResponseBody
	String delArticles(String id) {
		for (int i = 0; i < this.Articles.size(); i++) {
			if ((int) Articles.get(i).get("id") == Integer.parseInt(id)) {
				this.Articles.remove(i);
				return String.valueOf(id + "번 글이 삭제되었습니다.");
			}
		}
		return String.valueOf(id + "번 글이 없습니다.");
	}

	@RequestMapping("/home/modifyArticles")
	@ResponseBody
	String modifyArticles(String id, String title, String body) {
		for (int i = 0; i < this.Articles.size(); i++) {
			if ((int) Articles.get(i).get("id") == Integer.parseInt(id)) {
				Articles.get(i).replace("title", title);
				Articles.get(i).replace("body", title);
				return String.valueOf(id + "번 글이 수정되었습니다.");
			}
		}
		return String.valueOf(id + "번 글이 없습니다.");
	}

}
