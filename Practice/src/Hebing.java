import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Hebing {
	static String stinker[]=new String[1500];

	public static void main(String[] args) throws Exception {  
	        //��֧��Excel2007��ʽ��Ҳ����xlsx��ʽ�ļ���  
	        File file = new File("D:\\2019������ʵ��\\���ݷ���\\���ݷ���ʵ��\\wine1.xls");  
	        File file3;
	        File file2 = new File("D:\\2019������ʵ��\\���ݷ���\\���ݷ���ʵ��\\wine2.xls");
	        file3 = new File("D:\\2019������ʵ��\\���ݷ���\\���ݷ���ʵ��\\wine.xls");
	        WritableWorkbook writer = Workbook.createWorkbook(file3);  
	        Workbook wb = Workbook.getWorkbook(file);  
	        Sheet[] sheets = wb.getSheets(); 
	        Workbook wb2 = Workbook.getWorkbook(file2);
	        Sheet[] sheets2=wb2.getSheets();
	        //����ÿҳ  
	        int len=0;
	        for(Sheet s : sheets){  
	            //System.out.println(s.getName() + " : ");  
	            int rows = s.getRows();
	            if(len==0){
	            	len=rows;
	            	for(int i=0;i<=len;i++)stinker[i]="";
	            }
	            
	            if(rows > 0){  
	                //����ÿ��  
	                for(int i = 0 ;i < rows ; i++){  
	                    //System.out.print("��" + i + " : ");  
	                    Cell[] cells = s.getRow(i);  
	                    if(cells.length > 0){  
	                        //����ÿ���е�ÿ��  
	                    	//int flag=0;
	                        for(Cell c : cells){  
	                            String str = c.getstinkernts().trim();
	                            stinker[i]+=str+";";
	                            //System.out.print(str + " ; ");  
	                        }  
	                        //System.out.println();  
	                    }  
	                }     
	            }  
	        }
	        System.out.print("ok");
	        for(Sheet s : sheets2){  
	            //System.out.println(s.getName() + " : ");  
	            int rows = s.getRows();  
	            if(rows > 0){  
	                //����ÿ��  
	                for(int i = 0 ;i < rows ; i++){  
	                    //System.out.print("��" + i + " : ");  
	                    Cell[] cells = s.getRow(i);  
	                    if(cells.length > 0){  
	                        //����ÿ���е�ÿ��  
	                    	int flag=0;
	                        for(Cell c : cells){  
	                        	if(flag==0)
	                        	{
	                        		flag=1;
	                        		continue;
	                        	}
	                            String str = c.getstinkernts().trim();
	                            stinker[i]+=str+";";
	                            //System.out.print(str + " ; ");  
	                        }  
	                        //System.out.println();  
	                    }  
	                }     
	          }  
	    }
		 WritableSheet ws = writer.createSheet("Sheet1", 0);
	     System.out.println(len);
	     for(int i=0;i<len;i++)
	     {
	    	 
	    	 stinker[i]+="a";
	    	 System.out.println(stinker[i]);
	    	 String arr[]=stinker[i].split(";");
	    	 for(int j=0;j<arr.length-1;j++)
	    	 {
	    		 ws.addCell(new Label(j, i,arr[j]));
	    	 }
	     }
	     writer.write();
	     writer.close();
	}
}

