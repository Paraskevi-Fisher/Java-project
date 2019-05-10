import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Hebing {
	static String stinker[]=new String[1500];

	public static void main(String[] args) throws Exception {  
	        //不支持Excel2007格式（也就是xlsx格式文件）  
	        File file = new File("D:\\2019春哈理工实验\\数据分析\\数据分析实验\\wine1.xls");  
	        File file3;
	        File file2 = new File("D:\\2019春哈理工实验\\数据分析\\数据分析实验\\wine2.xls");
	        file3 = new File("D:\\2019春哈理工实验\\数据分析\\数据分析实验\\wine.xls");
	        WritableWorkbook writer = Workbook.createWorkbook(file3);  
	        Workbook wb = Workbook.getWorkbook(file);  
	        Sheet[] sheets = wb.getSheets(); 
	        Workbook wb2 = Workbook.getWorkbook(file2);
	        Sheet[] sheets2=wb2.getSheets();
	        //遍历每页  
	        int len=0;
	        for(Sheet s : sheets){  
	            //System.out.println(s.getName() + " : ");  
	            int rows = s.getRows();
	            if(len==0){
	            	len=rows;
	            	for(int i=0;i<=len;i++)stinker[i]="";
	            }
	            
	            if(rows > 0){  
	                //遍历每行  
	                for(int i = 0 ;i < rows ; i++){  
	                    //System.out.print("行" + i + " : ");  
	                    Cell[] cells = s.getRow(i);  
	                    if(cells.length > 0){  
	                        //遍历每行中的每列  
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
	                //遍历每行  
	                for(int i = 0 ;i < rows ; i++){  
	                    //System.out.print("行" + i + " : ");  
	                    Cell[] cells = s.getRow(i);  
	                    if(cells.length > 0){  
	                        //遍历每行中的每列  
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

