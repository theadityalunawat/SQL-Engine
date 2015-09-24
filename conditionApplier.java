import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class conditionApplier {
   public static void applyConditions(List<String> col,HashMap<String,HashMap<String,List<Integer>>> h,String tbl,Integer rowCount,Integer colCount,String condition)
   {
      try{
          
      
       Integer andFlag=0,orFlag=0,greatFlag=0,smallFlag=0,greatEqualFlag=0,smallEqualFlag=0,eqlEqlFlag=0;
       String[] cond = null;
       String[] storingCond1;
       String[] storingCond2;
       String colCondition1=null;
       String colCondition2=null;
       Integer colValue1,colValue2;
       Integer i,j;
       

       for(i=0;i<col.size();i++)
     {
         if(col.get(i).contains(tbl+"."))
         {
             col.set(i,col.get(i).replace(tbl+".",""));
         }
     }
       
       if((condition.contains("and")) || (condition.contains("And")) || condition.contains("AND"))
       {
           andFlag=1;
           if(condition.contains("and"))
           cond=condition.split("and");
           if(condition.contains("And"))
           cond=condition.split("And");
           if(condition.contains("AND"))
           cond=condition.split("AND");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 && h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
               
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 && h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                      
                    if(!col.get(0).equals("*"))
                    {
                        
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
               
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 && h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 && h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 && h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 && h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 && h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 && h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

              return;
           }
           else if(cond[0].contains("<=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 && h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

              return; 
           }
           else if(cond[0].contains("<=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 && h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 && h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains(">") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 && h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           return;
           }
           else if(cond[0].contains(">") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 && h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

             return;  
           }
           else if(cond[0].contains(">") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 && h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 && h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 && h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 && h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

              return; 
           }
           else if(cond[0].contains("<") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 && h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains("<") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 && h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains("<") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 && h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) && h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1)&& h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

             return; 
           }
           else if(cond[0].contains("=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) && h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

             return;  
           }
           else if(cond[0].contains("=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) && h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) && h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

            return;   
         }
       }
       else if((condition.contains("or")) || condition.contains("Or") || condition.contains("OR"))
       {
           orFlag=1;
           if(condition.contains("or"))
           cond=condition.split("or");
           else if(condition.contains("Or"))
           cond=condition.split("Or");
           else if(condition.contains("OR"))
           cond=condition.split("OR");
           
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 || h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 || h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 || h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 || h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1 || h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 || h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 || h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 || h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

            return;
           }
           else if(cond[0].contains("<=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 || h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

                return;
           }
           else if(cond[0].contains("<=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1 || h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 || h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains(">") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 || h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           return;
           }
           else if(cond[0].contains(">") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 || h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
               
           }
           else if(cond[0].contains(">") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 || h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains(">") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1 || h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 || h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("<") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 || h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

              return; 
           }
           else if(cond[0].contains("<") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 || h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains("<") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 || h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

               return;
           }
           else if(cond[0].contains("<") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1 || h.get(tbl).get(colCondition2).get(i).equals(colValue2))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) || h.get(tbl).get(colCondition2).get(i) >= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("=") && cond[1].contains("<="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) || h.get(tbl).get(colCondition2).get(i) <= colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

              return; 
           }
           else if(cond[0].contains("=") && cond[1].contains(">"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) || h.get(tbl).get(colCondition2).get(i) > colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }

             return;  
           }
           else if(cond[0].contains("=") && cond[1].contains("<"))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1) || h.get(tbl).get(colCondition2).get(i) < colValue2)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
            return;
           }
           else if(cond[0].contains("=") && cond[1].contains("="))
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
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
               System.out.println("");
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
               System.out.println("");
           }
              
           for(i=0;i<rowCount;i++)
           {
                   if((h.get(tbl).get(colCondition1).get(i).equals(colValue1) || (h.get(tbl).get(colCondition2).get(i).equals(colValue2))))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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
           colCondition1=cond[0];
           cond[1]=cond[1].trim();
           colValue1=Integer.parseInt(cond[1]);
           
           
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                if(i != (rowCount-1)) System.out.println("");
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                if(i != (rowCount-1)) System.out.println("");
           }
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) >= colValue1)
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else 
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
          
       }
       else if(condition.contains("<=") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split("<=");
           cond[0]=cond[0].trim();
           colCondition1=cond[0];
           cond[1]=cond[1].trim();
           colValue1=Integer.parseInt(cond[1]);
           
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                if(i != (rowCount-1)) System.out.println("");
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                if(i != (rowCount-1)) System.out.println("");
           }
           
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) <= colValue1)
                   {
                    if(!col.get(0).equals("*"))
                    {
                       
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
       }
       else if(condition.contains("=") && orFlag==0 && andFlag ==0)
       {
         
           cond=condition.split("=");
           cond[0]=cond[0].trim();
           colCondition1=cond[0];
           cond[1]=cond[1].trim();
           colValue1=Integer.parseInt(cond[1]);
           
           if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                if(i != (rowCount-1)) System.out.println("");
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                if(i != (rowCount-1)) System.out.println("");
           }
           
           for(i=0;i<rowCount;i++)
           {
               //System.out.println(h.get(tbl).get(colCondition1).get(i)+"  "+colValue1);
                   if(h.get(tbl).get(colCondition1).get(i).equals(colValue1))
                   {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           
       }
       else if(condition.contains(">") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split(">");
           cond[0]=cond[0].trim();
           colCondition1=cond[0];
           cond[1]=cond[1].trim();
           colValue1=Integer.parseInt(cond[1]);
           
          if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                if(i != (rowCount-1)) System.out.println("");
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                if(i != (rowCount-1)) System.out.println("");
           }
           
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) > colValue1)
                   {
                    if(!col.get(0).equals("*"))
                    {
                       for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                   }
                   
           }
           
       }
       else if(condition.contains("<") && orFlag==0 && andFlag ==0)
       {
           cond=condition.split("<");
           cond[0]=cond[0].trim();
           colCondition1=cond[0];
           cond[1]=cond[1].trim();
           colValue1=Integer.parseInt(cond[1]);
           
            if(col.get(0).equals("*"))
           {
               for(Integer k=0;k<colCount;k++)
                   if(k !=(colCount-1)) System.out.print(tbl+"."+data_Hashing.col_list[k]+","); else System.out.print(tbl+"."+data_Hashing.col_list[k]);
                if(i != (rowCount-1)) System.out.println("");
               
           }
           else
           {
               for(Integer k=0;k<col.size();k++)
                   if( k != (col.size()-1)) System.out.print(tbl+"."+col.get(k)+","); else System.out.print(tbl+"."+col.get(k));
                if(i != (rowCount-1)) System.out.println("");
           }
           
           for(i=0;i<rowCount;i++)
           {
                   if(h.get(tbl).get(colCondition1).get(i) < colValue1)
                  {
                    if(!col.get(0).equals("*"))
                    {
                      for(j=0;j<col.size();j++)
                        {
                        if(j != (col.size()-1)) System.out.print(h.get(tbl).get(col.get(j)).get(i)+","); else System.out.print(h.get(tbl).get(col.get(j)).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
                    }
                    else
                    {
                        for(j=0;j<colCount;j++)
                        {
                        if(j != (colCount-1)) System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+","); else System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                        }
                    if(i != (rowCount-1)) System.out.println("");
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



