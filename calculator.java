/*���������
 1��100���ڼӼ���
 2��������2�������
 3�������ָ���
 4��������0����������СΪ1��
 5����Ŀ���ظ�
 */

import java.util.*;
import java.io.*;
public class calculator {

	public static void main(String[] args) throws IOException{
		Random random = new Random();
		
		int num;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the total number of questions:");
		num = in.nextInt();//��Ŀ����
		
		char[] charlist = {'+','-'};
		
		File exercisefile = new File("D:\\javajdk\\myfile\\SE\\src\\Exercise.txt");
		try {
			exercisefile.createNewFile();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		File answersfile = new File("D:\\javajdk\\myfile\\SE\\src\\Answers.txt");
		try {
			answersfile.createNewFile();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}//����exercise.txt��answers.txt�ļ�
		
		
		ArrayList<StringBuffer> question = new ArrayList<StringBuffer>();//��question��������
		ArrayList<String> answerlist = new ArrayList<String>();//��answer��������
		for(int i=0;i<num;i++) 
		{
			int result;
			StringBuffer sb = new StringBuffer();
			
			int num1 = 1+random.nextInt(99);
			result = num1;
			sb.append(String.valueOf(num1));//��һ��������
			
			int sum = 1+random.nextInt(2);//�ַ�����Ϊ1��2
			//label:
			for(int j=1;j<=sum;j++)
			{
				int index = random.nextInt(2);
				String str1 = String.valueOf(charlist[index]);
				sb.append(str1);//ȷ�������
				
				if(str1.equals("+"))
				{
					if(result!=99)
					{
						int num2 =1+ random.nextInt(100-result-1);//�Ͳ�����100
						sb.append(String.valueOf(num2));
						result+=num2;
					}//������99+������
					else
					{
						j-=1;
						continue;
					}//����99�����³���
					
				}
				else 
				{
					if(result!=1)
					{
						int num2 = 1+random.nextInt(result-1);//���������0�������ָ���
						sb.append(String.valueOf(num2));
						result-=num2;
					}//������1������
					else {
						j-=1;
						continue;
					}//����1�����³���
				}
				
			}//���equation
			sb.append('=');
			if(question.isEmpty())
			{
				question.add(sb);
				answerlist.add(String.valueOf(result));
			}
			else 
			{
				for(int p=0;p<question.size();p++)
				{
					if(sb.toString().equals(question.get(p)))
					{	
						i-=1;
						continue;
					}
				}
					question.add(sb);
					answerlist.add(String.valueOf(result));
			}//ȥ���ظ�����Ŀ
		}
			
			
		FileWriter f1 = new FileWriter("D:\\javajdk\\myfile\\SE\\src\\Exercise.txt");
		for(int m=0;m<question.size();m++)
		{
			try {
				String s = String.valueOf(m+1+".");
				f1.write(String.format("%-6s", s)+question.get(m).toString()+"\r\n");
				f1.flush();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		f1.close();//����exercise.txt
		
		FileWriter f2 = new FileWriter("D:\\javajdk\\myfile\\SE\\src\\Answers.txt");
		for(int n=0;n<answerlist.size();n++)
		{
			try {
				String s = String.valueOf(n+1+".");
				f2.write(String.format("%-6s", s)+answerlist.get(n).toString()+"\r\n");
				f2.flush();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		f2.close();//����answers.txt
		for(int a = 0;a<question.size();a++)
			System.out.println(question.get(a).toString());

	}

}

