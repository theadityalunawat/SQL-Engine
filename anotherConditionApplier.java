import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aditya.lunawat
 */
public class anotherConditionApplier {

    static void applyCondition(HashMap<String, Integer> combined_H, List<String> combined_L, Integer[][] twoTableArray, Integer total_cc, Integer total_rc, List<String> col, List<String> tables_given,String condition, List<String> temp_list1, List<String> temp_list2,HashMap<String,Integer> h1,HashMap<String,Integer> h2) {
        
        try{
       Integer andFlag=0,orFlag=0,greatFlag=0,smallFlag=0,greatEqualFlag=0,smallEqualFlag=0,eqlEqlFlag=0; 
       String[] cond = null;
       String[] storingCond1;
       String[] storingCond2;
       String colCondition1=null;
       String colCondition2=null;
       Integer colValue1,colValue2;
       Integer i,j;
        
       
       
       if(condition.contains("and")|| condition.contains("And") || condition.contains("AND"))
       {
           andFlag=1;
           if(condition.contains("and"))
           cond=condition.split("and");
           else  if(condition.contains("And"))
               cond=condition.split("And");
           else if(condition.contains("AND"))
               cond=condition.split("AND");
               
           cond[0]=cond[0].trim();
           cond[1]=cond[1].trim();
          
          
        
           
           if(cond[0].contains(">=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains(">=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 && twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
            if(cond[0].contains("<=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 && twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("<=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)]<=colValue1 && twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 && twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
            if(cond[0].contains(">") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 && twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 && twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 && twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains(">") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 && twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains("="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 && twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
            if(cond[0].contains("<") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 && twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 && twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 && twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 && twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 && twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
            if(cond[0].contains("=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) && twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) && twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) && twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) && twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) && twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
       }
       
       
             else if(condition.contains("or") || condition.contains("Or") || condition.contains("OR"))
       { 
           orFlag=1;
           if(condition.contains("or"))
             cond=condition.split("or");
           else if(condition.contains("Or"))
               cond=condition.split("Or");
           else if(condition.contains("OR"))
             cond=condition.split("OR");
           cond[0]=cond[0].trim();
           cond[1]=cond[1].trim();
          
          
        if(cond[0].contains(tables_given.get(0)+"."))
        {
            
          cond[0]=cond[0].replace(tables_given.get(0)+".","");
           
        }
        if(cond[0].contains(tables_given.get(1)+"."))
        {
            cond[0]=cond[0].replace(tables_given.get(1)+".","");
        }
        if(cond[1].contains(tables_given.get(0)+"."))
        {
            cond[1]=cond[1].replace(tables_given.get(0)+".","");
        }
        if(cond[1].contains(tables_given.get(1)+"."))
        {
           cond[1]=cond[1].replace(tables_given.get(1)+".","");
        }
        cond[0]=cond[0].trim();
        cond[1]=cond[1].trim();
           
           if(cond[0].contains(">=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains(">=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split(">=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1 || twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
            if(cond[0].contains("<=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 || twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("<=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)]<=colValue1 || twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("<=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1 || twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
            if(cond[0].contains(">") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 || twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 || twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 || twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains(">") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 || twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains(">") && cond[1].contains("="))
           {
               storingCond1=cond[0].split(">");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1 || twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
            if(cond[0].contains("<") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 || twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 || twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 || twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 || twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("<") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("<");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1 || twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
            if(cond[0].contains("=") && cond[1].contains(">="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split(">=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) || twoTableArray[i][combined_H.get(colCondition2)] >= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains("<="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("<=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) || twoTableArray[i][combined_H.get(colCondition2)] <= colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains(">"))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split(">");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) || twoTableArray[i][combined_H.get(colCondition2)] > colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           if(cond[0].contains("=") && cond[1].contains("<"))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("<");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) || twoTableArray[i][combined_H.get(colCondition2)] < colValue2)
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           if(cond[0].contains("=") && cond[1].contains("="))
           {
               storingCond1=cond[0].split("=");
               storingCond2=cond[1].split("=");
               storingCond1[0]=storingCond1[0].trim();
               storingCond1[1]=storingCond1[1].trim();
               storingCond2[0]=storingCond2[0].trim();
               storingCond2[1]=storingCond2[1].trim();
               colCondition1=storingCond1[0];
               colValue1=Integer.parseInt(storingCond1[1]);
               colCondition2=storingCond2[0];
               colValue2=Integer.parseInt(storingCond2[1]);
               
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           for(i=0;i<total_rc;i++)
           {
              
                   if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1) || twoTableArray[i][combined_H.get(colCondition2)].equals(colValue2))
                   {
                       System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                    }
                   }
                   
             }
           return;
           }
           
           
       }
       
        else if(condition.contains(">=") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split(">=");
           cond[0]=cond[0].trim();
           
           cond[1]=cond[1].trim();
           
           
           
        colCondition1=cond[0];
        colValue1=Integer.parseInt(cond[1]);
        
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           
           for(i=0;i<total_rc;i++)
           {
                    if(twoTableArray[i][combined_H.get(colCondition1)] >= colValue1)
                  {
                     System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                     }
                  }
           }   
                    
                   
         }
       
           else if(condition.contains("<=") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split("<=");
           cond[0]=cond[0].trim();
           
           cond[1]=cond[1].trim();
           
           
           
        colCondition1=cond[0];
        colValue1=Integer.parseInt(cond[1]);
        
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           
           for(i=0;i<total_rc;i++)
           {
                    if(twoTableArray[i][combined_H.get(colCondition1)] <= colValue1)
                  {
                     System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                     }
                  }
           }   
                    
                   
         }
         else if(condition.contains(">") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split(">");
           cond[0]=cond[0].trim();
           
           cond[1]=cond[1].trim();
           
           
           
        colCondition1=cond[0];
        colValue1=Integer.parseInt(cond[1]);
        
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           
           for(i=0;i<total_rc;i++)
           {
                    if(twoTableArray[i][combined_H.get(colCondition1)] > colValue1)
                  {
                     System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                     }
                  }
           }   
                    
                   
         }
       
         else if(condition.contains("<") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split("<");
           cond[0]=cond[0].trim();
           
           cond[1]=cond[1].trim();
           
           
           
        colCondition1=cond[0];
        colValue1=Integer.parseInt(cond[1]);
        
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           
           for(i=0;i<total_rc;i++)
           {
                    if(twoTableArray[i][combined_H.get(colCondition1)] < colValue1)
                  {
                     System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                     }
                  }
           }   
                    
                   
         }
       
         else if(condition.contains("=") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split("=");
           cond[0]=cond[0].trim();
           
           cond[1]=cond[1].trim();
           
           
           
        colCondition1=cond[0];
        colValue1=Integer.parseInt(cond[1]);
        
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<total_cc;k++)
                if(h1.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(0)+"."+combined_L.get(k)+",");
                else if(h2.containsKey(combined_L.get(k)))
                      System.out.print(tables_given.get(1)+"."+combined_L.get(k)+",");
                
               
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                    if(h1.containsKey(col.get(k)))
                   System.out.print(tables_given.get(0)+"."+col.get(k)+",");
                    else if(h2.containsKey(col.get(k)))
                   System.out.print(tables_given.get(1)+"."+col.get(k)+",");
                
           }
           
           for(i=0;i<total_rc;i++)
           {
                    if(twoTableArray[i][combined_H.get(colCondition1)].equals(colValue1))
                  {
                     System.out.println("");
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                         if(j != (col.size()-1))
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]);  
                        }
                     
                    }
                    else 
                    {
                        for(j=0;j<total_cc;j++)
                        {
                         if(j != (total_cc-1))   
                        System.out.print(twoTableArray[i][combined_H.get(col.get(j))]+",");
                         else
                           System.out.print(twoTableArray[i][combined_H.get(col.get(j))]); 
                        }
                     
                     }
                  }
           }   
                    
                   
         }
       
       
       
    }
        catch(Exception e)
        {
            System.out.println("error");
            return;
        }
  }
}

          
