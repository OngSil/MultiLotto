import java.util.*;
import java.io.*;
//1. ���� �ҷ����� : ���͸� ������ �ڵ����� �츮�ݸ���Ʈ �����̸� �ֱ�
//2. �ҷ��� ���� �а�, �迭�� ���.
//3. ����Ʈ���� ��� �������� �� �ޱ�
//4. ���� ����ŭ �������� �л� �̱�
//�ߺ����� : TreeSet �̿�(TreeSet ����� ���� ������ ������ �ٽ� �ݺ�


class MultiLotto2_study3 {
	String list = "�츮�ݸ���Ʈ.txt";
	String line; //���پ� ���� �غ�
	String student[] = new String[23];
	int count = 0;

	//1. ���� �ҷ����� : ���͸� ������ �ڵ����� �츮�ݸ���Ʈ �����̸� �ֱ�
	void input(){
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in)); //System.in���� ���� �Է¹ޱ�
		System.out.println("'�츮�ݸ���Ʈ'�� �־��꼼��!!!");

		try{
			String listfile = br1.readLine(); //�Է°� listfile���ִ´�
			if ( listfile.equals("") ){ //�Է°��� �����϶�
				this.list = list; //list�� �츮�ݸ���Ʈ.txt�� �ϰٴ�
				System.out.println(list);
			} else {
				System.out.println("�츮�ݸ���Ʈ�� �־��꼼��");
				input();
			}
		}catch(IOException ie){}
	}
	
	//2. �ҷ��� ���� �а�, �迭�� ���. 
	void fileRead(){
		FileReader fr = null;
		BufferedReader br2;

		try{
			fr = new FileReader(list);
			br2 = new BufferedReader(fr);
			
			//���� ���� �ϳ��� �迭�� ���
			String list = null;
			while( (list=br2.readLine()) != null ){
				student[count] = list;
				count++;
			}
		}catch(IOException ie){
		}
	}
	
	//3. ����Ʈ���� ��� �������� �� �ޱ�
	int a;
	void choose(){
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("��� �̱⤡��? ");
		try{
			String luckyNum = br3.readLine();
			a = Integer.parseInt(luckyNum);
			if(a > 22 || a < 0 ) {
				System.out.println("��ܿ� 22��ۿ� ����!!!!");
				choose();
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("���ڸ� �Է������");
			choose();
		}
	}
	
	//4. ���� ����ŭ �������� �л� �̱�
	//�ߺ����� : TreeSet �̿�(TreeSet ����� ���� ������ ������ �ٽ� �ݺ�
	TreeSet<Integer> set = new TreeSet<Integer>();

	int amount_num = 23;
	int n;

	void selectRan(){
		Random r = new Random();
		for(int i=0; i<a; i++){
			n = r.nextInt(23); //�Է¹��� ����ŭ ���� �� �̾Ƽ�
			set.add(n); //treeSet�� �ִ´�
			if( set.size() < a ){ //�ߺ����� ���ܼ� a��ŭ treeset�� �ȴ��� �ٽ� �̱�
				i--;
			}else{
				break;
			}
		}
		for(int i : set){
			System.out.println("��÷��ȣ: "+i+", ��÷��: "+student[i]);
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
