import java.util.HashMap;
import java.util.List;

public class printData {

    static Integer rc=initiate.rowCount;
    static Integer cc=initiate.colCount;
   public static void printStarData(HashMap<String,HashMap<String,List<Integer>>> h,String tbl)
   {                      Integer i,j;
                            for(i=0;i<cc;i++)
                                if(i != (cc-1))
                                System.out.print(tbl+"."+data_Hashing.col_list[i]+",");
                            else
                                 System.out.print(tbl+"."+data_Hashing.col_list[i]);   
                            System.out.println("");
                            for(i=0;i<rc;i++)
                            {
                                for(j=0;j<cc;j++)
                                {
                                    if(j != (cc-1))
                                    System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i)+",");
                                    else
                                        System.out.print(h.get(tbl).get(data_Hashing.col_list[j]).get(i));
                                }
                               if(i != (rc-1))
                                System.out.println("");
                            }
   }

   
}

