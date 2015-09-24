import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aditya.lunawat
 */
public class someColumns {
    
    public static void showColumns(List<String> col,HashMap<String,HashMap<String,List<Integer>>> h,String tbl,Integer rowCount,Integer colCount)
    {
     
     Integer i,j;
     for(i=0;i<col.size();i++)
     {
         if(col.get(i).contains(tbl+"."))
         {
             col.set(i,col.get(i).replace(tbl+".",""));
         }
     }
     
     
     for(i=0;i<col.size();i++)
         if(i != (col.size()-1))
         {
            System.out.print(tbl+"."+col.get(i)+",");
         }
            else
             System.out.print(tbl+"."+col.get(i));
        System.out.println("");
     for(i=0;i<rowCount;i++)
     {
         for(j=0;j<col.size();j++)
             if(j != (col.size()-1))
            System.out.print(h.get(tbl).get(col.get(j)).get(i)+",");
             else
             System.out.print(h.get(tbl).get(col.get(j)).get(i));
         if(i != (rowCount-1)) 
         System.out.println("");
     }
    }
    
     
   

    static void showDoubleMultipleColumns(HashMap<String, Integer> combined_H, List<String> combined_L, Integer[][] twoTableArray, Integer total_cc, Integer total_rc, List<String> col_given, List<String> tables_given, HashMap<String, Integer> h1, HashMap<String, Integer> h2)
    {
        
        Integer i,j;
       
        for(i=0;i<col_given.size();i++)
               {
                   if(i != (col_given.size()-1))
                   {
                   if(h1.containsKey(col_given.get(i))) 
                       System.out.print(tables_given.get(0)+"."+col_given.get(i)+",");
                   else if(h2.containsKey(col_given.get(i))) 
                       System.out.print(tables_given.get(0)+"."+col_given.get(i)+",");
                   else 
                       return;
                   }
                   else
                   {
                       {if(h1.containsKey(col_given.get(i))) 
                       System.out.print(tables_given.get(0)+"."+col_given.get(i));
                   else if(h2.containsKey(col_given.get(i))) 
                       System.out.print(tables_given.get(1)+"."+col_given.get(i));
                   else 
                       return; 
                   }
                 }
               }
                 System.out.println("");
                 for(i=0;i<total_rc;i++)
                 {
                  for(j=0;j<col_given.size();j++)
                  if(j != (col_given.size()-1))    
                  System.out.print(twoTableArray[i][combined_H.get(col_given.get(j))]+",");
                  else
                      System.out.print(twoTableArray[i][combined_H.get(col_given.get(j))]);
                  if(i != (total_rc-1))
                  System.out.println("");
                 }  
    
    

     
    
}
}
