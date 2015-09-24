import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.csvreader.CsvReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aditya.lunawat
 */
 public class data_Hashing {
    public static String[] col_list=new String[25]; 
    public static HashMap<String,HashMap<String,List<Integer>>> passing_data(String tbl) 
    {
        try {
            HashMap<String,HashMap<String,List<Integer>>> hm1;
            hm1=new HashMap<String,HashMap<String,List<Integer>>>();
            HashMap<String,List<Integer>> hm2=new HashMap<String,List<Integer>>();
            List<Integer> A=new ArrayList<Integer>();
            List<Integer> B=new ArrayList<Integer>();
            
            FileReader fr = null;
            try {
                fr = new FileReader("metadata.txt");
            } catch (FileNotFoundException ex) {
                return null;
                //Logger.getLogger(data_Hashing.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader br=new BufferedReader(fr);
            String st;
            Integer flag=0,col_count=0;
            
            try {
                while((st=br.readLine()) != null)
                {

                    if(st.equals("<begin_table>"))
                    {
                        if((st=br.readLine()).equals(tbl))
                        {
                            
                            while(!(st=br.readLine()).equals("<end_table>"))
                            {
                                hm2.put(st,A);
                                col_list[col_count++]=st;
                                st=null;
                            }
                        }
                    }
                    st=null;
                }
            } catch (IOException ex) {
              return null;    
            //Logger.getLogger(data_Hashing.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fr.close();
            } catch (IOException ex) {
                
                return null;
                //Logger.getLogger(data_Hashing.class.getName()).log(Level.SEVERE, null, ex);
            }
            hm1.put(tbl, hm2);
            
            
            CsvReader products = new CsvReader(tbl+".csv");
            
            Integer i,valueCount=0,x;
            String y;
            
            
            try {
                while (products.readRecord())
                {
                    
                    for(i=0;i<col_count;i++)
                    {
                        y = products.get(i).trim();
                        B.add(Integer.parseInt(y));
                        
                        valueCount++;
                    }
                    
                    
                    
                    
                    
                    
                }
            } catch (IOException ex) {
               
                return null;
                //Logger.getLogger(data_Hashing.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer j;
            
            
            
            Integer k;
            i=0;
            j=0;
            
            valueCount=valueCount/col_count;
            
            
            for(i=0;i<col_count;i++)
            {
                ArrayList<Integer> Col_addlist=new ArrayList<Integer>();
                for(j=i;j<B.size();j=j+col_count)
                {
                    Col_addlist.add(B.get(j));
                }
                hm2.put(col_list[i], Col_addlist);
                
            }
            
            
            hm1.put(tbl, hm2);
            products.close();
            
            
            return hm1;
        } catch (FileNotFoundException ex) {
            
            return null;
            //Logger.getLogger(data_Hashing.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                        }
    
    
 
                }
    


