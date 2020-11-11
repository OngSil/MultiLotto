import java.util.*;
import java.io.*;
//1. 파일 불러오기 : 엔터만 쳤을때 자동으로 우리반리스트 파일이름 넣기
//2. 불러온 파일 읽고, 배열에 담기.
//3. 리스트에서 몇명 뽑을건지 값 받기
//4. 받은 수만큼 랜덤으로 학생 뽑기
//중복방지 : TreeSet 이용(TreeSet 사이즈가 받은 값보다 작으면 다시 반복


class MultiLotto2_study3 {
	String list = "우리반리스트.txt";
	String line; //한줄씩 읽을 준비
	String student[] = new String[23];
	int count = 0;

	//1. 파일 불러오기 : 엔터만 쳤을때 자동으로 우리반리스트 파일이름 넣기
	void input(){
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in)); //System.in으로 파일 입력받기
		System.out.println("'우리반리스트'를 넣어쥬세여!!!");

		try{
			String listfile = br1.readLine(); //입력값 listfile에넣는다
			if ( listfile.equals("") ){ //입력값이 엔터일때
				this.list = list; //list는 우리반리스트.txt로 하겟다
				System.out.println(list);
			} else {
				System.out.println("우리반리스트만 넣어쥬세여");
				input();
			}
		}catch(IOException ie){}
	}
	
	//2. 불러온 파일 읽고, 배열에 담기. 
	void fileRead(){
		FileReader fr = null;
		BufferedReader br2;

		try{
			fr = new FileReader(list);
			br2 = new BufferedReader(fr);
			
			//파일 내용 하나씩 배열에 담기
			String list = null;
			while( (list=br2.readLine()) != null ){
				student[count] = list;
				count++;
			}
		}catch(IOException ie){
		}
	}
	
	//3. 리스트에서 몇명 뽑을건지 값 받기
	int a;
	void choose(){
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("몇명 뽑기ㄱㄱ? ");
		try{
			String luckyNum = br3.readLine();
			a = Integer.parseInt(luckyNum);
			if(a > 22 || a < 0 ) {
				System.out.println("명단에 22명밖에 엄쪄!!!!");
				choose();
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("숫자만 입력해쥬삼");
			choose();
		}
	}
	
	//4. 받은 수만큼 랜덤으로 학생 뽑기
	//중복방지 : TreeSet 이용(TreeSet 사이즈가 받은 값보다 작으면 다시 반복
	TreeSet<Integer> set = new TreeSet<Integer>();

	int amount_num = 23;
	int n;

	void selectRan(){
		Random r = new Random();
		for(int i=0; i<a; i++){
			n = r.nextInt(23); //입력받은 수만큼 랜덤 수 뽑아서
			set.add(n); //treeSet에 넣는다
			if( set.size() < a ){ //중복수가 생겨서 a만큼 treeset에 안담기면 다시 뽑긔
				i--;
			}else{
				break;
			}
		}
		for(int i : set){
			System.out.println("당첨번호: "+i+", 당첨자: "+student[i]);
		}
	}
	

	public static void main(String[] args) {
		MultiLotto2_study3 ms3 = new MultiLotto2_study3();
		ms3.input();
		ms3.fileRead();
		ms3.choose();
		ms3.selectRan();
	}
}
