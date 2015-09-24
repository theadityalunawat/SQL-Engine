import gudusoft.gsqlparser.*;
import gudusoft.gsqlparser.nodes.TJoin;
import gudusoft.gsqlparser.nodes.TJoinItem;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.stmt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class initiate {
static Integer distinct_flag=0,condition_flag=0;   
static Integer rowCount,colCount;
@SuppressWarnings("unchecked")
public static void main(String args[]) {
TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvoracle);
sqlparser.sqltext=""+args[0]+"";
if((sqlparser.sqltext.contains("distinct")) || (sqlparser.sqltext.contains("DISTINCT")) || (sqlparser.sqltext.contains("Distinct")))
{
    distinct_flag=1;
}
int ret = sqlparser.parse();
if (ret == 0){
for(int i=0;i<sqlparser.sqlstatements.size();i++){
    try {
        analyzeStmt(sqlparser.sqlstatements.get(i));
    } catch (IOException ex) {
        Logger.getLogger(initiate.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}else{
System.out.print(sqlparser.getErrormessage());
}
}
protected static void analyzeStmt(TCustomSqlStatement stmt) throws IOException{
switch(stmt.sqlstatementtype){
case sstselect:
analyzeSelectStmt((TSelectSqlStatement)stmt);
break;
case sstupdate:
break;
case sstcreatetable:
break;
case sstaltertable:
break;
case sstcreateview:
break;
default:
System.out.println(stmt.sqlstatementtype.toString());
}
}

protected static void analyzeSelectStmt(TSelectSqlStatement pStmt){
   
   String tbl = null;
   String Col = null;
   String condn=null;
   List<String> col_given=new ArrayList<String>();
   List<String> tables_given=new ArrayList<String>();
   List<String> conditions_given=new ArrayList<String>();
   
//System.out.println("\nSelect statement:");
if (pStmt.isCombinedQuery()){
String setstr="";
switch (pStmt.getSetOperator()){
case 1: setstr = "union";break;
case 2: setstr = "union all";break;
case 3: setstr = "intersect";break;
case 4: setstr = "intersect all";break;
case 5: setstr = "minus";break;
case 6: setstr = "minus all";break;
case 7: setstr = "except";break;
case 8: setstr = "except all";break;
}
System.out.printf("set type: %s\n",setstr);
System.out.println("left select:");
analyzeSelectStmt(pStmt.getLeftStmt());
System.out.println("right select:");
analyzeSelectStmt(pStmt.getRightStmt());
if (pStmt.getOrderbyClause() != null){
System.out.printf("order by clause %s\n",pStmt.getOrderbyClause().toString());
}
}else{
//select list
    for(int i=0; i < pStmt.getResultColumnList().size();i++){
TResultColumn resultColumn = pStmt.getResultColumnList().getResultColumn(i);
Col=resultColumn.getExpr().toString();
col_given.add(Col);
//System.out.printf("\tColumn: %s, Alias: %s\n",resultColumn.getExpr().toString(), (resultColumn.getAliasClause() == null)?"":resultColumn.getAliasClause().toString());
}
    //from clause, check this document for detailed information
//http://www.sqlparser.com/sql-parser-query-join-table.php
for(int i=0;i<pStmt.joins.size();i++){
TJoin join = pStmt.joins.getJoin(i);
switch (join.getKind()){
case TBaseType.join_source_fake:
tbl=join.getTable().toString();
tables_given.add(join.getTable().toString());
    //System.out.println(tbl+"\n");
//System.out.printf("\ntable: \n\t%s, alias: %s\n",join.getTable().toString(),(join.getTable().getAliasClause() !=null)?join.getTable().getAliasClause().toString():"");
break;
case TBaseType.join_source_table:
System.out.printf("\ntable: \n\t%s, alias: %s\n",join.getTable().toString(),(join.getTable().getAliasClause() !=null)?join.getTable().getAliasClause().toString():"");
for(int j=0;j<join.getJoinItems().size();j++){
TJoinItem joinItem = join.getJoinItems().getJoinItem(j);
System.out.printf("Join type: %s\n",joinItem.getJoinType().toString());
System.out.printf("table: %s, alias: %s\n",joinItem.getTable().toString(),(joinItem.getTable().getAliasClause() !=null)?joinItem.getTable().getAliasClause().toString():"");
if (joinItem.getOnCondition() != null){
System.out.printf("On: %s\n",joinItem.getOnCondition().toString());
}else if (joinItem.getUsingColumns() != null){
System.out.printf("using: %s\n",joinItem.getUsingColumns().toString());
}
}
break;
case TBaseType.join_source_join:
TJoin source_join = join.getJoin();
System.out.printf("\ntable: \n\t%s, alias: %s\n",source_join.getTable().toString(),(source_join.getTable().getAliasClause() !=null)?source_join.getTable().getAliasClause().toString():"");
for(int j=0;j<source_join.getJoinItems().size();j++){
TJoinItem joinItem = source_join.getJoinItems().getJoinItem(j);
System.out.printf("source_join type: %s\n",joinItem.getJoinType().toString());
System.out.printf("table: %s, alias: %s\n",joinItem.getTable().toString(),(joinItem.getTable().getAliasClause() !=null)?joinItem.getTable().getAliasClause().toString():"");
if (joinItem.getOnCondition() != null){
System.out.printf("On: %s\n",joinItem.getOnCondition().toString());
}else if (joinItem.getUsingColumns() != null){
System.out.printf("using: %s\n",joinItem.getUsingColumns().toString());
}
}
for(int j=0;j<join.getJoinItems().size();j++){
TJoinItem joinItem = join.getJoinItems().getJoinItem(j);
System.out.printf("Join type: %s\n",joinItem.getJoinType().toString());
System.out.printf("table: %s, alias: %s\n",joinItem.getTable().toString(),(joinItem.getTable().getAliasClause() !=null)?joinItem.getTable().getAliasClause().toString():"");
if (joinItem.getOnCondition() != null){
System.out.printf("On: %s\n",joinItem.getOnCondition().toString());
}else if (joinItem.getUsingColumns() != null){
System.out.printf("using: %s\n",joinItem.getUsingColumns().toString());
}
}
break;
default:

break;
}
}
//where clause
if (pStmt.getWhereClause() != null){
condn= pStmt.getWhereClause().getCondition().toString();
condition_flag=1;
//System.out.printf("\nwhere clause: \n\t%s\n", pStmt.getWhereClause().getCondition().toString());
}
// group by
if (pStmt.getGroupByClause() != null){
System.out.printf("\ngroup by: \n\t%s\n",pStmt.getGroupByClause().toString());
}
// order by
if (pStmt.getOrderbyClause() != null){
System.out.printf("\norder by:");
for(int i=0;i<pStmt.getOrderbyClause().getItems().size();i++){
System.out.printf("\n\t%s",pStmt.getOrderbyClause().getItems().getOrderByItem(i).toString());
}
}
// for update
if (pStmt.getForUpdateClause() != null){
System.out.printf("for update: \n%s\n",pStmt.getForUpdateClause().toString());
}
// top clause
if (pStmt.getTopClause() != null){
System.out.printf("top clause: \n%s\n",pStmt.getTopClause().toString());
}
// limit clause
if (pStmt.getLimitClause() != null){
System.out.printf("top clause: \n%s\n",pStmt.getLimitClause().toString());
}

}
try
{
Integer i,j;
HashMap<String,HashMap<String,List<Integer>>> h=null;
if(!((col_given.get(0).toLowerCase().contains("max")) || (col_given.get(0).toLowerCase().contains("avg")) || (col_given.get(0).toLowerCase().contains("min")) || (col_given.get(0).toLowerCase().contains("sum")) || (distinct_flag == 1)))
{ 
   if(tables_given.size() == 1)
   {
    h= data_Hashing.passing_data(tbl);
    List<String> tempColList=new ArrayList<String>();
    for(i=0;i<h.get(tbl).keySet().size();i++)
    {
        tempColList.add(data_Hashing.col_list[i]);
    }
    colCount=tempColList.size();
    rowCount=h.get(tbl).get(tempColList.get(0)).size();

    if(!col_given.get(0).equals("*"))
    {
        for(i=0;i<col_given.size();i++)
        {
            if(!h.get(tbl).keySet().contains(col_given.get(i)))
            {
                System.out.print("error");
                return;
            }
        }
    }
    
    if(col_given.get(0).equals("*") && condition_flag == 0)
       printData.printStarData(h,tbl); 
    
    else if(col_given.size() == 1 && condition_flag == 0)
    {
        System.out.println(tbl+"."+Col);
        for(i=0;i<rowCount;i++)
        {
            if(i != (rowCount-1))
                System.out.println(h.get(tbl).get(Col).get(i));
            else
                 System.out.print(h.get(tbl).get(Col).get(i));
            
        }
    }
    
    else if(col_given.size() > 1 && condition_flag == 0)
        someColumns.showColumns(col_given,h,tbl,rowCount,colCount);
    
    else if(condition_flag == 1 && tables_given.size() == 1) 
      conditionApplier.applyConditions(col_given, h, tbl, rowCount, colCount, condn);
    
    }
   else if(tables_given.size() > 1)
   {
       
      
       Integer rc1,cc1,rc2,cc2,total_rc,total_cc=0;
       List<String> temp_list1=new ArrayList<>();
       List<String> temp_list2=new ArrayList<>();
       HashMap<String,Integer> h1=new HashMap<>();
       HashMap<String,Integer> h2=new HashMap<>();
       HashMap<String,HashMap<String,List<Integer>>> hm1=null;
       HashMap<String,HashMap<String,List<Integer>>> hm2=null;
       hm1= data_Hashing.passing_data(tables_given.get(0));
       
       cc1=hm1.get(tables_given.get(0)).size();
       for(i=0;i<cc1;i++)
           temp_list1.add(data_Hashing.col_list[i]);
       rc1=hm1.get(tables_given.get(0)).get(temp_list1.get(0)).size();
       hm2= data_Hashing1.passing_data(tables_given.get(1));
      
       cc2=hm2.get(tables_given.get(1)).size();
       for(i=0;i<cc2;i++)
           temp_list2.add(data_Hashing1.col_list[i]);
       rc2=hm2.get(tables_given.get(1)).get(temp_list2.get(0)).size();
       for(i=0;i<cc1;i++)
       {
           h1.put(temp_list1.get(i),i);
           total_cc++;
       }
       for(i=0;i<cc2;i++)
       {
           h2.put(temp_list2.get(i),total_cc);
           total_cc++;
       }
        if(!col_given.get(0).equals("*"))
     { 
         
        for(i=0;i<col_given.size();i++)
        {
            if(((hm1.get(tables_given.get(0)).containsKey((col_given.get(i)))) ||(hm2.get(tables_given.get(1)).containsKey((col_given.get(i))))))
            {
                if(col_given.get(i).contains(tables_given.get(0)+"."))
                    col_given.get(i).replace(tables_given.get(0)+".","");
                if(col_given.get(i).contains(tables_given.get(1)+"."))
                    col_given.get(i).replace(tables_given.get(1)+".","");
                
            }
            else
            {
                System.out.println("error");
                
                return;
            }
        }
    }
        
       total_rc=rc1*rc2;
       Integer[][] twoTableArray=new Integer[total_rc+2][total_cc+2];
       Integer k,l=0,p=0,m=0,n=0;
       for(i=0;i<rc1;i++)
           {
               for(k=p;k<p+rc2;k++)
               {
                   for(j=0;j<cc1;j++)
                   {
                       twoTableArray[k][j]=hm1.get(tables_given.get(0)).get(temp_list1.get(j)).get(i);
                       
                   }
               }
               p=p+rc2;
           }
       p=0;
       m=0;
       n=0;
       for(i=0;i<rc1;i++)
       {
           for(k=p;k<p+rc2;k++)
           {
               for(j=cc1;j<total_cc;j++)
               {
                   
                   twoTableArray[k][j]=hm2.get(tables_given.get(1)).get(temp_list2.get(m)).get(n);
                   m++;
               }
               m=0;
               n++;
           }
           p=p+rc2;
           n=0;
       }
       HashMap<String,Integer> combined_H;
       combined_H = new HashMap<>(h1);
       combined_H.putAll(h2);
       List<String> combined_L=new ArrayList<>(temp_list1);
       combined_L.addAll(temp_list2);
       if(condition_flag == 0)
       {
           
           if(col_given.get(0).equals("*"))
           {
               for(i=0;i<total_cc;i++)
               {
                   if(i != (total_cc-1))
                   {
                       if(i < cc1)
                   System.out.print(tables_given.get(0)+"."+combined_L.get(i)+",");
                       else
                           System.out.print(tables_given.get(1)+"."+combined_L.get(i)+",");
                   
                    }      
                       else
                       System.out.print(tables_given.get(1)+"."+combined_L.get(i));
               }
               System.out.println("");
               for(i=0;i<total_rc;i++)
               {
                   for(j=0;j<total_cc;j++)
                       if(j != (total_cc-1))
                       System.out.print(twoTableArray[i][combined_H.get(combined_L.get(j))]+",");
                   else
                           System.out.print(twoTableArray[i][combined_H.get(combined_L.get(j))]);
                   if(i != (total_rc-1))
                   System.out.println("");
               }
               
           }
           else if(col_given.size() > 1)
           {
              
               someColumns.showDoubleMultipleColumns(combined_H,combined_L,twoTableArray,total_cc,total_rc,col_given,tables_given,h1,h2);
               

           }
           
       }
       else
       {
           if(condn.contains(tables_given.get(0)+".") || condn.contains(tables_given.get(1)+"."))
           {
               newConditionApplier.applyCondition(combined_H,combined_L,twoTableArray,total_cc,total_rc,col_given,tables_given,condn,temp_list1,temp_list2,h1,h2);
               
           }
           else
           {
               
               anotherConditionApplier.applyCondition(combined_H,combined_L,twoTableArray,total_cc,total_rc,col_given,tables_given,condn,temp_list1,temp_list2,h1,h2);
           }
       }
       
   }
       
}
else
{
    
    if(col_given.get(0).toLowerCase().contains("max"))
    {
        String temp=col_given.get(0);
        if(temp.contains(tbl+"."))
          temp=temp.replace(tbl+".","");
        temp=temp.replace("max","");
        temp=temp.replace("MAX","");
        temp=temp.replace("Max","");
        temp=temp.replace(")","");
        temp=temp.replace("(","");
        temp=temp.trim();
        h= data_Hashing.passing_data(tbl);
     
        
           if(!h.get(tbl).containsKey(temp))
            {
                System.out.print("error");
                return;
            }
        
    
        System.out.println("max("+tbl+"."+temp+")");
        System.out.print(Collections.max(h.get(tbl).get(temp)));
    }
    else if(col_given.get(0).toLowerCase().contains("min"))
    {
        
        String temp=col_given.get(0);
        if(temp.contains(tbl+"."))
          temp=temp.replace(tbl+".","");
        temp=temp.replace("min","");
        temp=temp.replace("Min","");
        temp=temp.replace("MIN","");
        temp=temp.replace(")","");
        temp=temp.replace("(","");
        temp=temp.trim();
        h= data_Hashing.passing_data(tbl);
        if(!h.get(tbl).containsKey(temp))
            {
                System.out.print("error");
                return;
            }
        System.out.println("min("+tbl+"."+temp+")");
        System.out.print(Collections.min(h.get(tbl).get(temp)));
    }
    else if((col_given.get(0).toLowerCase().contains("sum")))
    {
        String temp=col_given.get(0);
        if(temp.contains(tbl+"."))
          temp=temp.replace(tbl+".","");
         temp=temp.replace("sum","");
        temp=temp.replace("Sum","");
        temp=temp.replace("SUM","");
        temp=temp.replace(")","");
        temp=temp.replace("(","");
        temp=temp.trim();
        h= data_Hashing.passing_data(tbl);
        if(!h.get(tbl).containsKey(temp))
            {
                System.out.print("error");
                return;
            }
        Integer sum=0;
       for (Iterator<Integer> it = h.get(tbl).get(temp).iterator(); it.hasNext();) {
           sum+= it.next();
       }
        System.out.println("sum("+tbl+"."+temp+")");
        System.out.print(sum);
    }
 
    else if(distinct_flag == 1)
    {
        String[] temp = new String[100];
        for(j=0;j<col_given.size();j++)
        {
            temp[j]=col_given.get(j);
            if(temp[j].contains(tbl+"."))
            temp[j]=temp[j].replace(tbl+".","");
            temp[j]=temp[j].replace("(", "");
            temp[j]=temp[j].replace(")", "");
            temp[j]=temp[j].trim();
        }
        
        
        h= data_Hashing.passing_data(tbl);
        for(j=0;j<col_given.size();j++)
        {
            if(!h.get(tbl).containsKey(temp[j]))
            {
                System.out.print("error");
                return;
            }
        }
        String temp1 = "";
        LinkedHashSet<String> dset=new LinkedHashSet();
        for(j=0;j<h.get(tbl).get(temp[0]).size();j++)
        {
            for(i=0;i<col_given.size();i++)
            {
               if(i == 0)
                   temp1=h.get(tbl).get(temp[i]).get(j).toString();
               else
                temp1=temp1+","+h.get(tbl).get(temp[i]).get(j).toString();
                
            }
           
            dset.add(temp1);
            temp1="";
        }
        
        for (Iterator it = dset.iterator(); it.hasNext();) {
           System.out.println(it.next());
       }
            
        
    }
    else if(col_given.get(0).toLowerCase().contains("avg"))
    {
        String temp=col_given.get(0);
         if(temp.contains(tbl+"."))
          temp=temp.replace(tbl+".","");
        temp=temp.replace("avg","");
        temp=temp.replace("Avg","");
        temp=temp.replace("AVG","");
        temp=temp.replace(")","");
        temp=temp.replace("(","");
        temp=temp.trim();
        h= data_Hashing.passing_data(tbl);
       if(!h.get(tbl).containsKey(temp))
            {
                System.out.print("error");
                return;
            }
        Integer sum=0;
        float avg,den;
        for (Iterator<Integer> it = h.get(tbl).get(temp).iterator(); it.hasNext();) {
           sum+= it.next();
       }
        den=h.get(tbl).get(temp).size();
        avg=(sum/den);
        int b=(int)Math.round(avg);
        System.out.println("avg("+tbl+"."+b+")");
    }
  }
 }
  catch(Exception ex)
  {
      System.out.println("error");
  }
    
    
 }

}

