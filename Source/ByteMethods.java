/**
  *  This class defines some methods which are
  *  specific to byte arrays
  */

public class ByteMethods{
public static void main(String a[])
  {
    ByteMethods t= new ByteMethods();
    byte[] b={(byte)1,(byte)2,(byte)3};
    byte[]  c={3};
    byte[] d={5,23};
     t.printarray(t.addarray(b,c));
   }
/**
  * This method whether two byte arrays equal or not
  * Return type is boolean
  */
public boolean isequal(byte[] b,byte[] c)
  {

    if(b.length!=c.length)
       return false;

     for(int i=0;i<b.length;i++)
      if(b[i]==c[i]);
      else
        return false;
    return true;
  }
 /**
   * This method removes vowel from two byte arrays
   * the return type is byte array
   */
 public byte[] removevowel(byte[] b,byte[] c)
  {
   byte a[] =new byte[b.length+c.length-1];
      if((b[b.length-1]==5) && (c[0]==3))
       {
      for(int i=0;i<b.length;i++)
         a[i]=b[i];
      for(int i=0;i<c.length;i++)
         a[b.length-1+i]=c[i];
       }
     return a;
  }
 /**
   * This method adds two byte arrays
   *Return type is byte array
   */
public byte[] addarray(byte b[],byte[] c)
  {

      byte[] a=null;
      if(b.length==1 && b[0]==0)
        a=c;
      else if(c.length==1 && c[0]==0)
        a=b;
        // if first "u" next "a" "aa" "i" "ii" "u" "uu" "e" "ee" "ai" "o" "oo" "aw"
     else if((b[b.length-1]==5) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {
        a= new byte[b.length+c.length-1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
         for(int i=0;i<c.length;i++)
            a[b.length-1+i]=c[i];
                }
       else if(((b[b.length-1]==1)||(b[b.length-1]==2)||(b[b.length-1]==6)||(b[b.length-1]==7)||(b[b.length-1]==10)||(b[b.length-1]==12)) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {
        a= new byte[b.length+c.length+1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
            a[b.length]=27;
         for(int i=0;i<c.length;i++)
            a[b.length+i+1]=c[i];
       }
      else if(((b[b.length-1]==3)||(b[b.length-1]==4)||(b[b.length-1]==9)||(b[b.length-1]==11)) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {//System.out.println("coming");
        a= new byte[b.length+c.length+1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
            a[b.length]=24;
         for(int i=0;i<c.length;i++)
            a[b.length+i+1]=c[i];
       }
       else if( ((b[b.length-1]==19) || (b[b.length-1]==26)) && (c[0]==1 || c[0]==3))
          {
			  a=new byte[b.length+1+c.length];
			  for(int i=0;i<b.length;i++)
			     a[i]=b[i];
			  a[b.length]=b[b.length-1];
			  for(int i=0;i<c.length;i++)
                  a[b.length+i+1]=c[i];
		  }
      else if(((b[b.length-1]==24)||(b[b.length-1]==3)) && ((c[0]==5)||(c[0]==1)||(c[0]==8)))          // rule 2 if first endswith 'yi' and sencond starts with 'u' add 'yi' with first
         {                                                        // rule 3 if first endswith 'i' and second startswith u then add 'yi'wtih the first
           a= new byte[b.length+c.length+1];
          for(int i=0;i<b.length;i++)
             a[i]=b[i];
             a[b.length]=24;
          for(int i=0;i<c.length;i++)
            a[b.length+1+i]=c[i];

         }
       else if( ( (b[b.length-1]==1) ||(b[b.length-1]==2) ||(b[b.length-1]==3) ||(b[b.length-1]==4) ||(b[b.length-1]==5) ||(b[b.length-1]==6) ||(b[b.length-1]==7) ||(b[b.length-1]==8) ||(b[b.length-1]==9) ||(b[b.length-1]==10) ||(b[b.length-1]==11) ||(b[b.length-1]==12)) &&((c[0]==14)||(c[0]==16)||(c[0]==20)||(c[0]==22))&&((c[1]==1)||(c[1]==2)||(c[1]==3)||(c[1]==4)||(c[1]==5)||(c[1]==6)||(c[1]==7)||(c[1]==8)||(c[1]==9)||(c[1]==10)||(c[1]==11)||(c[1]==12)))
       {  a= new byte[b.length+c.length+1];
          for(int i=0;i<b.length;i++)
             a[i]=b[i];
             a[b.length]=c[0];
          for(int i=0;i<c.length;i++)
            a[b.length+i+1]=c[i];
        }


      else
       {
          a= new byte[b.length+c.length];
          for(int i=0;i<b.length;i++)

            a[i]=b[i];
          for(int i=0;i<c.length;i++)
            a[b.length+i]=c[i];
        }

     return a;
  }

 /**
   * This method adds two byte arrays
   *Return type is byte array
   */
public byte[] addarray1(byte b[],byte[] c)
  {

      byte[] a=null;
      if(b.length==1 && b[0]==0)
        a=c;
      else if(c.length==1 && c[0]==0)
        a=b;
     else if((b[b.length-1]==5) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {
        a= new byte[b.length+c.length-1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
         for(int i=0;i<c.length;i++)
            a[b.length-1+i]=c[i];
       }
       else if(((b[b.length-1]==1)||(b[b.length-1]==2)||(b[b.length-1]==7)||(b[b.length-1]==10)||(b[b.length-1]==11)||(b[b.length-1]==12)) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {
        a= new byte[b.length+c.length+1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
            a[b.length]=27;
         for(int i=0;i<c.length;i++)
            a[b.length+i+1]=c[i];
       }
      else if(((b[b.length-1]==3)||(b[b.length-1]==4)||(b[b.length-1]==9)) && ((c[0]==1)||(c[0]==2)||(c[0]==3)||(c[0]==4)||(c[0]==5)||(c[0]==6)||(c[0]==7)||(c[0]==8)||(c[0]==9)||(c[0]==10)||(c[0]==11)||(c[0]==12)))  //rule 1 first endswith u and second starts with i or u remove the first u
       {
        a= new byte[b.length+c.length+1];
         for(int i=0;i<b.length;i++)
            a[i]=b[i];
            a[b.length]=24;
         for(int i=0;i<c.length;i++)
            a[b.length+i+1]=c[i];
       }

      else if(((b[b.length-1]==24)||(b[b.length-1]==3)) && ((c[0]==5)||(c[0]==1)))          // rule 2 if first endswith 'yi' and sencond starts with 'u' add 'yi' with first
         {                                                          // rule 3 if first endswith 'i' and second startswith u then add 'yi'wtih the first
           a= new byte[b.length+c.length+1];
          for(int i=0;i<b.length;i++)
             a[i]=b[i];
             a[b.length]=24;
          for(int i=0;i<c.length;i++)
            a[b.length+1+i]=c[i];

         }
     else
       {
          a= new byte[b.length+c.length];
          for(int i=0;i<b.length;i++)

            a[i]=b[i];
          for(int i=0;i<c.length;i++)
            a[b.length+i]=c[i];
        }

     return a;
  }
/**
  *  It returns the subarray of the given array
  *  using the starting and ending positions of
  *  the required array
  */
public byte[] subarray(byte[] b,int c,int d)
  {
   byte[] a=new byte[d-c];
     for(int i=c;i<d;i++)
       a[i-c]=b[i];
   return a;
  }
 /**
   *  It checks the first given  array is starting
   *  with the the second or not
   */
public boolean startswith(byte[] b,byte[] c)
  {
     int len1=0,len2=0;
     if(b.length>c.length)
        {
         len1=b.length;
         len2=c.length;
        }
     else
        {
        len1=c.length;
        len2=b.length;
        }
    for(int i=0;i<len2;i++)
      if(b[i]==c[i]);
      else return false;
  return true;
 }
 /**
   *  It checks the first given  array is ending
   *  with the the second or not
   */
public boolean endswith(byte[] b,byte[] c)
  {
  int len1=0,len2=0;
     if(b.length>c.length)
        {
         len1=b.length;
         len2=c.length;
        }
     else
        {
        len1=c.length;
        len2=b.length;
        }
 for(int i=len1-1,j=len2-1;j!=-1;j--,i--)
   if(b[i]==c[j]);
   else return false;
      return true;
 }
/**This method is used for printing the byte array.*/

public void printarray(byte[] b)
 {
   for(int i=0;i<b.length;i++)
     System.out.println(i+"  "+b[i]);
 }
}