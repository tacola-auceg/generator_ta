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
   String adject[]={"äï¢¶","İÁ","ã¿","âì¢´","ğ¶","ğî¢¶","å¼","Ş¼","Íù¢Á","ï£ù¢°","åù¢Á","Şóí¢´","ËÁ","İò¤óñ¢","Şôì¢êñ¢","«è£®"};
   String adj[]={"äï¢¶","İÁ","ã¿","âì¢´","ğ¶","ğî¢¶","å¼","Ş¼","Íù¢Á","ï£ù¢°","åù¢Á","Şóí¢´","ËÁ","İò¤óñ¢","Şôì¢êñ¢","«è£®","Üõ÷¢","Üõù¢","Şõù¢","Şõ÷¢","âù¢","âñ¢","âé¢è÷¢","Üõó¢","Şõó¢","Üõó¢è÷¢","Şõó¢è÷¢ ","àù¢"," àé¢è÷¢","àñ¢","ïñ¢"};
 //  String[] adject1={"Üö°","è¼ğ¢¹","ğòé¢èóñ¢","«è£óñ¢","Éò¢¬ñ"};
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