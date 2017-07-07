/**   This is the main class which handles the adjectives*/
public class AdjectiveMethods{
	TabMethods tm =new TabMethods();
	ByteMethods bm = new ByteMethods();
 /** In this method when a noun is passed
   * it adds adjective and the return type
   * is String*/
 public String addAdjective(String noun)
  {
   String str="";
   byte[] aana={2,31,1};
   byte[] nounbyte=tm.convert(noun);
 //  if(nounbyte.length==0) nounbyte[0]=0;
   byte[] numbyte,numbyte1;
   String adject[]={"�","��","�","�좴","�","�","�","޼","����","����","����","���","��","����","�����","�裮"};
   String adj[]={"�","��","�","�좴","�","�","�","޼","����","����","����","���","��","����","�����","�裮","����","����","����","����","���","��","�����","���","���","������","������ ","���"," �����","��","��"};
 //  String[] adject1={"���","��","������","����","���"};
   try{

     for(int i=0;i<adject.length;i++)
      {
        numbyte=tm.convert(adject[i]);

        try{
            if(bm.endswith(nounbyte,numbyte))  return noun+" ";
           }
       catch(ArrayIndexOutOfBoundsException e)
         {
           for(int j=0;j<adject.length;j++)
            {
             numbyte=tm.convert(adject[i]);
           if(bm.isequal(numbyte,nounbyte))
               return noun+" ";
            }
         }
      }
      for(int i=0;i<adj.length;i++)
      {
        numbyte1=tm.convert(adj[i]);
        if( !(bm.isequal(nounbyte,numbyte1)))
          return tm.revert(bm.addarray(nounbyte,aana))+" ";
      }
 }catch(Exception e){System.out.println(e);}
   return str;
 }
 }