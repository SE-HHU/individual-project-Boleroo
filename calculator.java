/*需求分析：
 1、100以内加减法
 2、不超过2个运算符
 3、不出现负数
 4、不出现0，运算数最小为1，
 5、题目不重复
 */

import java.util.*;
import java.io.*;
public class calculator {

	public static void main(String[] args) throws IOException{
		Random random = new Random();
		
		int num;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the total number of questions:");
		num = in.nextInt();//题目总数
		
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
		}//创建exercise.txt和answers.txt文件
		
		
		ArrayList<StringBuffer> question = new ArrayList<StringBuffer>();//将question存入链表
		ArrayList<String> answerlist = new ArrayList<String>();//将answer存入链表
		for(int i=0;i<num;i++) 
		{
			int result;
			StringBuffer sb = new StringBuffer();
			
			int num1 = 1+random.nextInt(99);
			result = num1;
			sb.append(String.valueOf(num1));//第一个运算数
			
			int sum = 1+random.nextInt(2);//字符数量为1或2
			//label:
			for(int j=1;j<=sum;j++)
			{
				int index = random.nextInt(2);
				String str1 = String.valueOf(charlist[index]);
				sb.append(str1);//确定运算符
				
				if(str1.equals("+"))
				{
					if(result!=99)
					{
						int num2 =1+ random.nextInt(100-result-1);//和不超过100
						sb.append(String.valueOf(num2));
						result+=num2;
					}//若不是99+，继续
					else
					{
						j-=1;
						continue;
					}//若是99，重新出题
					
				}
				else 
				{
					if(result!=1)
					{
						int num2 = 1+random.nextInt(result-1);//结果不出现0，不出现负数
						sb.append(String.valueOf(num2));
						result-=num2;
					}//若不是1，继续
					else {
						j-=1;
						continue;
					}//若是1，重新出题
				}
				
			}//完成equation
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
			}//去掉重复的题目
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
		f1.close();//输入exercise.txt
		
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
		f2.close();//存入answers.txt
		for(int a = 0;a<question.size();a++)
			System.out.println(question.get(a).toString());

	}

}

