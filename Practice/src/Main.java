import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			char[] s = in.nextLine().toCharArray();
			int len = s.length;
			boolean vic = true;
			boolean finding = true;
			int point = 0;
			int startpoint = 0;
			int endpoint = len-1;
			
			boolean spec = false;
			boolean fu = false;
			for (int i = 0;i < len;i++)
			{
				if (spec == false && s[i] == '+')
				{
					spec = false;
					startpoint = i+1;
					continue;
				}
				else if (spec == false && s[i] == '-')
				{
					spec = true;
					fu = true;
					startpoint = i+1;
					continue;
				}
				
				if (s[i] == ' ') {
					vic = false;
					break;
				}
				if ( ! (s[i]>='0'&&s[i]<='9') && s[i] != '.')
				{
					vic = false;
					break;
				}
				else spec = true;
				
				
				if (s[i] == '.') 
					{
						point++;
						endpoint = i-1;
					}
				if (point>1){
					vic = false;
					break;
				}
				

				if (s[i] != '0' && point == 0)
					finding = false;
				
				if (s[i] == '0' && finding)
					startpoint = i+1;
			}
			if (vic==false)
				System.out.print(0);
			
			else{
				if (finding == true)
					System.out.print(0);
				else
					if (fu == true) System.out.print("-");
					for (int i=startpoint;i<=endpoint;i++)
					{
						if (s[i] == ' ') continue;
						System.out.print(s[i]);
					}
			}
			System.out.println();
		}

		in.close();
	}
}
