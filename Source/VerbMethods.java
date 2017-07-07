public class VerbMethods
{
		ByteMethods bm = new ByteMethods();
		TabMethods tm = new TabMethods();
		FileRead file = new FileRead();

		final int PRESENT			=	2;
		final int PAST				=	3;
		final int FUTURE			=	4;
		final int FUTURE_NEUTER		=	5;
		final int INFINITIVE 		=	6;
		final int VERBALPARTICIPLE 	=	7;
		final int PRESENT_NEUTER 	=	8;

	public VerbMethods()
	{
	}
	/** This method returns the generated string using
	  *  auxillaryverb,tense,verb and adverb*/
	public String[] callAll(String subject,String verb,String aux[],String tense,String aaoo,String adverb)
	{
		String result[] =new String[16];

		result[0]="õ¤¬ì¬ò èí¤èè º®ò º®òõ¤ô¢¬ô";

		byte[][] b=new byte[4][];
		byte[] b1=tm.convert(verb);
		byte[] b2=tm.convert(subject);
		byte[] b3=tm.convert(tense);
		byte[][] a1=null;
		int auxlen=aux.length;

		b=addTense(b1,b2,b3);

		byte[][] auxi=new byte[4][];

		for(int i=0;i<4;i++)
		{
			if(aux[i].equals("¶¬í"))
				auxlen--;
			auxi[i]=tm.convert(aux[i]);
		}

		byte[] c=genderEndings(b2,b3,b[1]);
		String s3="";
		byte[] z=null;
		z=bm.addarray(b[2],c);
		String adverb_string ="";

		if("õ¤¬ùò¬ì".equals(adverb)); ///
		else
			adverb_string = tm.revert(addAdverb(adverb))+" ";

		try
		{
			if(auxlen==0)
			{
				s3=tm.revert(bm.addarray1(b[0],z));
				result[0]=" "+adverb_string+" "+s3+"\n";
			}
			else
			{
				a1=addAuxi(b[3],b[1],auxi,b3,b2,auxlen);
				for(int i=0;i<a1.length;i++)
					result[i]=" "+adverb_string+" "+tm.revert(a1[i])+"\n";
			}
		}catch(Exception e){System.out.println("exception in call all");}

		return result;
	}

	/** This method returns the byte array,
	  * after adding kiru,kindru etc according
	  * to the tense selected*/
	public byte[][] addTense(byte[] verbbyte,byte[] subbyte,byte[] tenbyte)
	{

		byte[][] b = new byte[4][];
		int cat=0;
		String verb=tm.revert(verbbyte);

		try
		{
			cat = file.getVerbCat(verb,"verbcat.txt");
			System.out.println("verbcat  "+cat);
			switch(cat)
			{
				case 1:
						b[3]=verbbyte;
						b[0]=verbbyte;             //verb
						b[1] = Constants.th;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kindru;
							else
								b[2] = Constants.kiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.th;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.zero;
							else
								b[2] = Constants.v;
						}
						break;

				case 2:
						b[3]=verbbyte;
						b[0]=verbbyte;             //verb
						b[1] = Constants.nth;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kindru;
							else
								b[2] = Constants.kiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.nth;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.zero;
							else
								b[2] = Constants.v;
						}
						break;

				case 3:
						b[3] = verbbyte;
						b[0]=verbbyte;             //verb
						b[1] = Constants.n;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kindru;
							else
								b[2] = Constants.kiru;
						}
						if (bm.isequal(Constants.pasbyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.in;
							else
								b[2] = Constants.n;
						}
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.k;
							else
								b[2] = Constants.v;
						}
						break;

				case 4:
						b[3]=verbbyte;
						b[0]=verbbyte;             //verb
						b[1]  = Constants.thth;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kkindru;
							else
								b[2] = Constants.kkiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.thth;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.kk;
							else
								b[2] = Constants.pp;
						}
						break;
				case 5:
						b[3]=verbbyte;
						b[0]=verbbyte;             //verb
						b[1] = Constants.nth;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kkindru;
							else
								b[2] = Constants.kkiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.nth;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.kk;
							else
								b[2] = Constants.pp;
						}
						break;
				case 6:
						b[3]=verbbyte;
						b[0]=verbbyte;             //verb
						b[1] = Constants.t;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kindru;
							else
								b[2] = Constants.kiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.t;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
								b[2] = Constants.inn;
							else
								b[2] = Constants.p;
						}
						break;
				case 7:
						b[3] = verbbyte;
						b[0] = verbbyte;             //verb
						b[1] = Constants.e;
						if(bm.isequal(Constants.prebyte,tenbyte))
						{
							if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
								b[2] = Constants.kindru;
							else
								b[2] = Constants.kiru;
						}
						if(bm.isequal(Constants.pasbyte,tenbyte))
							b[2] = Constants.in;
						if(bm.isequal(Constants.futbyte,tenbyte))
						{
							if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.zero;
                     else
                        b[2]= Constants.v;
                    }
                  break;
    case 8:
                  b[3]=bm.subarray(verbbyte,0,verbbyte.length-1);
	 	      	  b[0]=verbbyte;             //verb
                  b[1] = Constants.t;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0]=bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.t;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.zero;
                     else
                        b[2] = Constants.v;
                    }
                  break;
    case 9:
                  b[3]=bm.subarray(verbbyte,0,verbbyte.length-1);
	 	      	  b[0]=verbbyte;             //verb
                  b[1] = Constants.rr;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0]=bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.rr;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.zero;
                     else
                        b[2] = Constants.v;
                    }
                  break;
   case 10:
                  b[3] = bm.subarray(verbbyte,0,verbbyte.length-1);
	 	      	  b[0] = verbbyte;             //verb
                  b[1] = Constants.nrr;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0] = bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.nrr;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.l;
                     else
                        b[2] = Constants.v;
                    }
                  break;
    case 11:
                  b[3] = verbbyte;
	 	      	  b[0] = verbbyte;             //verb
                  b[1] = Constants.nn;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0]=bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.nn;  ///////////
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.l;
                     else
                        b[2] = Constants.v;
                    }
                  break;
     case 12:
                  b[3] = verbbyte;
	 	      	  b[0] = verbbyte;             //verb
                  b[1] = Constants.innt;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0] = bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.innt;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.ll;
                     else
                        b[2] = Constants.v;
                    }
                    break;
   case 14:
                  b[3] = bm.subarray(verbbyte,0,verbbyte.length-1);
	 	      	  b[0] = verbbyte;            //verb
                  b[1] = Constants.rrrr;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                     b[0] = bm.subarray(b[0],0,b[0].length-1);
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.rrkinru;
                   else
                     b[2] = Constants.rrkiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0] = bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.rrrr;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     b[0] = bm.subarray(b[0],0,b[0].length-1);
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.rrk;
                     else
                        b[2] = Constants.rrp;
                    }
                  break;
  case 15:
                  b[3] = bm.subarray(verbbyte,0,verbbyte.length-1);
	 	      	  b[0] = verbbyte;             //verb
                  b[1] = Constants.rrrr1;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                     b[0] = bm.subarray(b[0],0,b[0].length-1);
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.rrkinru;
                   else
                     b[2] = Constants.rrkiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0] = bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.nrr;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     b[0] = bm.subarray(b[0],0,b[0].length-1);
                     if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.rrk;
                     else
                        b[2] = Constants.rrp;
                    }
                  break;
  case 16:

				  b[3]= new byte[verbbyte.length];
                  for(int i=0;i<verbbyte.length;i++)
                     b[3][i]=verbbyte[i];
	              b[3][1]=1;
                  b[0]=verbbyte;             //verb
                  b[1] = Constants.t;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.kindru;
                   else
                     b[2] = Constants.kiru;

                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0][1]=1;//bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.t;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                    if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.zero;
                     else
                        b[2] = Constants.p;
                    }
                  break;
  case 17:
                  b[3] = verbbyte;
	 	      	  b[0] = verbbyte;             //verb
                  b[1] = Constants.nth;
                  if(bm.isequal(Constants.prebyte,tenbyte))
                   {
                    b[0][1]=1;
                   if(bm.isequal(Constants.avai,subbyte) || bm.isequal(Constants.avaikal,subbyte))
                     b[2] = Constants.rukinru;
                   else
                     b[2] = Constants.rukiru;
                    }
                  if(bm.isequal(Constants.pasbyte,tenbyte))
                   {
                    b[0][1]=1;//bm.subarray(b[0],0,b[0].length-1);
                    b[2] = Constants.nth;
                    }
                  if(bm.isequal(Constants.futbyte,tenbyte))
                    {
                     b[0][1]=1;
                    if(bm.isequal(subbyte,Constants.avai)|| bm.isequal(subbyte,Constants.avaikal) || bm.isequal(subbyte,Constants.athu))
                        b[2] = Constants.ru;
                     else
                        b[2] = Constants.ruv;
                    }
                  break;


      }

          System.out.println(cat+"");    }
         catch(Exception e){System.out.println("From the verbcate exception");}
         return b;
      }

/**This method generates gender endings.*/
public byte[] genderEndings(byte[] sub,byte[] tense,byte[] pasttensemarker)
  {
	byte[] b = new byte[10];

       String s="";
        try
        {
         String subject=tm.revert(sub);
	     s = file.getGenderEnding(subject,"genderendings.txt");
         b=tm.convert(s);
        if( bm.isequal(tense,Constants.pasbyte) && bm.isequal(Constants.in,pasttensemarker))
          if(bm.isequal(sub,Constants.avai)|| bm.isequal(sub,Constants.avaikal))
             b = Constants.a;
        if(bm.isequal(tense,Constants.futbyte))
         if(bm.isequal(sub,Constants.avai)|| bm.isequal(sub,Constants.avaikal) || bm.isequal(sub,Constants.athu))
          b = Constants.um;
	  }

      catch(Exception e){System.out.println("From the gender ending exception");}
      return b ;
}
/** This method adds the auxillary */
public byte[][] addAuxi( byte[] verb, byte[] ptm, byte[][] auxi,byte[] tense,byte[] subject,int auxlen)
  {
    int cat=0;
    int word=0;
    int inc=0;
    byte[][] b=new byte[16][];
    int cla=0;
    int nextcla=0;
    String ten=tm.revert(tense);

    int tense_variable = 0;

    if(ten.equals("ï¤èö¢è£ôñ¢"))
    	tense_variable = PRESENT;
    else if(ten.equals("Þøï¢îè£ôñ¢"))
    	tense_variable = PAST;
    else if(ten.equals("âî¤ó¢è£ôñ¢"))
    	tense_variable = FUTURE;

    String aux1="";
    String aux2="";
    String auxil[]=new String[4];
    for(int i=0;i<auxi.length;i++)
     auxil[i]=tm.revert(auxi[i]);
    byte temp[][] =new byte[16][];
    byte[][] resaux=new byte[16][];
    byte[] space ={0,32,0};
    byte[] subver=bm.addarray(space,verb);
    try
      {
       word=1;

       // for more than one auxilary
       for(int i=0;i<auxlen-1;i++)
        {

	     cla = file.getAuxCat(auxil[i],"auxiliary.txt");

		nextcla = file.getAuxCat(auxil[i+1],"auxiliary.txt");
          if(i==0)
            {
            if(cla==1)
              {
               if(bm.isequal(ptm,Constants.e))
                 resaux[0] = ptm;
               //else if(bm.isequal(ptm,thth))
                 //resaux[0]=kka;
               else
                resaux[0]=bm.addarray(ptm,Constants.u);
                }
            if(cla==2)
             {
               if(bm.isequal(ptm,Constants.thth))
			      resaux[0] = Constants.kka;
			   else if(bm.isequal(ptm,Constants.nth))
			      resaux[0] = Constants.kka;
			   else if(bm.isequal(ptm,Constants.rrrr))
			      resaux[0] = Constants.rrka;
			   else
			       {
			   		if(bm.isequal(ptm,Constants.nrr))
			   		  resaux[0] = Constants.lla;
			   		else
			   		   {
			   		     resaux[0] = Constants.a;
			   		   }
					}
		     }
            if(cla==3)
             {
                if(bm.isequal(ptm,Constants.e))
                  resaux[0] = ptm;
               // else
                 // resaux[0] = bm.addarray(ptm,Constants.u);

                  if(bm.isequal(ptm,Constants.thth))
				     resaux[1] = Constants.kka;
				  else if(bm.isequal(ptm,Constants.nth))
				     resaux[1] = Constants.kka;
				  else if(bm.isequal(ptm,Constants.rrrr))
				     resaux[1] = Constants.rrka;
				  else
				     {
				    	if(bm.isequal(ptm,Constants.nrr))
				  	 	   resaux[1] = Constants.lla;
				  	 	else
				  	 	   {
				     	     resaux[1] = Constants.a;
				  	       }
				 	 }
               word*=2;
             }
            }
           if(nextcla==1 || nextcla==4)
            {

              aux1 = file.getAuxString(auxil[i],"auxiliary.txt",VERBALPARTICIPLE);

              for(int x=0;x<word;x++)
              resaux[x]=bm.addarray1(resaux[x],tm.convert(aux1));
            }
         if(nextcla==2 || nextcla==5 || nextcla==6)
            {

             aux1 = file.getAuxString(auxil[i],"auxiliary.txt",INFINITIVE);

            for(int x=0;x<word;x++)
              resaux[x]=bm.addarray1(resaux[x],tm.convert(aux1));
            }
         if(nextcla==3)
            {
             word*=2;
              aux1 = file.getAuxString(auxil[i],"auxiliary.txt",VERBALPARTICIPLE);


	           aux2 = file.getAuxString(auxil[i],"auxiliary.txt",INFINITIVE);

            for(int x=0;x<word/2;x++)
             {
              resaux[x]=bm.addarray1(resaux[x],tm.convert(aux1));
              resaux[word/2+x]=bm.addarray1(resaux[x],tm.convert(aux2));
             }
            }

           }


           // for the last auxilary
        cla = file.getAuxCat(auxil[auxlen-1],"auxiliary.txt");
      if(cla==1 || cla==2 || cla==3)
       {
         if(cla==1)
          {
            if(auxlen==1)
             {
             if(bm.isequal(ptm,Constants.e))
               resaux[0]=ptm;
             else if(bm.isequal(ptm,Constants.nn))
               resaux[0] = Constants.e;
             else if(bm.isequal(ptm,Constants.n))
               resaux[0] = Constants.yi;
             else
              resaux[0]=bm.addarray1(ptm,Constants.u);
               }
           }//

          else if(cla==2)
           {
          if(auxlen==1)
             {
			  if(bm.isequal(ptm,Constants.thth))
			     resaux[0] = Constants.kka;
			  else if(bm.isequal(ptm,Constants.nth))
			     resaux[0] = Constants.kka;
			   else if(bm.isequal(ptm,Constants.rrrr))
			     resaux[0] = Constants.rrka;
			  else
			     {
					 if(bm.isequal(ptm,Constants.nrr))
					   resaux[0] = Constants.lla;
					 else
					 resaux[0] = Constants.a;
				 }
		    }
           }

    else if(cla==3)
        {
           if(auxlen==1)
             {
               if(bm.isequal(ptm,Constants.thth))
                 resaux[1] = Constants.kka;
               else if(bm.isequal(ptm,Constants.nth))
			     resaux[1] = Constants.kka;
			   else if(bm.isequal(ptm,Constants.rrrr))
			     resaux[1] = Constants.rrka;
			   else
                 {
				 	if(bm.isequal(ptm,Constants.nrr))
				 	   resaux[1] = Constants.lla;
				 	else
				 	   {
					     resaux[1] = Constants.a;
				       }
				 }
                if(bm.isequal(ptm,Constants.e))
                  resaux[0] = ptm;
			  	else if(bm.isequal(ptm,Constants.nn))
                  resaux[0]= Constants.e;
                else
                  resaux[0]=bm.addarray1(ptm,Constants.u);
               word*=2;
              }
         }
         for(int x=0;x<word;x++)
           b[x]=bm.addarray(subver,resaux[x]);
           if((bm.isequal(subject,Constants.avai)|| bm.isequal(subject,Constants.avaikal))&& bm.isequal(tense,Constants.prebyte))
            {
              aux1 = file.getAuxString(auxil[auxlen-1],"auxiliary.txt",PRESENT_NEUTER);

            }
           else if((bm.isequal(subject,Constants.athu)||bm.isequal(subject,Constants.avai)|| bm.isequal(subject,Constants.avaikal))&& bm.isequal(tense,Constants.futbyte))
            {
              aux1 = file.getAuxString(auxil[auxlen-1],"auxiliary.txt",FUTURE_NEUTER);

          }
          else
           {
              aux1 = file.getAuxString(auxil[auxlen-1],"auxiliary.txt",tense_variable);

           }
         for(int x=0;x<word;x++)
           b[x]=bm.addarray1(bm.addarray(b[x],tm.convert(aux1)),genderEndings(subject,tense,ptm));
         }
    else if(cla==4)
        {
         if(auxlen==1)
           if(bm.isequal(ptm,Constants.e))
             resaux[0]=ptm;
           if(bm.isequal(ptm,Constants.nn))
             resaux[0] = Constants.e;
           else
             resaux[0] = bm.addarray1(ptm,Constants.u);
        for(int x=0;x<word;x++)
         b[x]=bm.addarray(subver,resaux[x]);
        aux1=auxil[auxlen-1];
        for(int x=0;x<word;x++)
         b[x]=bm.addarray1(b[x],tm.convert(aux1));
        return b;
        }
      else if(cla==5)
       {
       if(auxlen==1)
          {
		    if(bm.isequal(ptm,Constants.thth))
		      resaux[0] = Constants.kka;
		    else if(bm.isequal(ptm,Constants.nth))
		      resaux[0] = Constants.kka;
		    else if(bm.isequal(ptm,Constants.rrrr))
		      resaux[0] = Constants.rrka;
		    else
				{
				 if(bm.isequal(ptm,Constants.nrr))
				   resaux[0] = Constants.lla;
				 else
				   resaux[0] = Constants.a;
				 }
	  	  }
       for(int x=0;x<word;x++)
       b[x]=bm.addarray(subver,resaux[x]);
       aux1=auxil[auxlen-1];
       for(int x=0;x<word;x++)
        b[x]=bm.addarray(b[x],tm.convert(aux1));
       return b;
        }
       else if(cla==6)
        {
          if(auxlen==1)
           {
            if(bm.isequal(ptm,Constants.thth))
               resaux[0] = Constants.kka;
            else if(bm.isequal(ptm,Constants.nth))
               resaux[0] = Constants.kka;
            else if(bm.isequal(ptm,Constants.rrrr))
               resaux[0] = Constants.rrka;
            else
              {
				  if(bm.isequal(ptm,Constants.nrr))
				     resaux[0] = Constants.lla;
				   else
				     resaux[0] = Constants.a;
		       }
		    }
        for(int x=0;x<word;x++)
          b[x]=bm.addarray(subver,resaux[x]);
        aux1=auxil[auxlen-1];
        for(int x=0;x<word;x++)
          b[x]=bm.addarray(bm.addarray1(b[x],tm.convert(aux1)),genderEndings(subject,tense,ptm));
       return b;
        }
if((bm.isequal(subject,Constants.avai)|| bm.isequal(subject,Constants.avaikal))&& bm.isequal(tense,Constants.pasbyte)&& bm.isequal(ptm,Constants.in))
   for(int x=0;x<word;x++)
     b[x]=bm.addarray(b[x],Constants.na);

     }catch(Exception e){System.out.println("In the last auxilary exception");}
    return b;
 }


public byte[] addAdverb(String given_adverb)
 {
  byte[] adverb_result=null;
  byte[] given_adverb_byte=tm.convert(given_adverb);
  byte[] L={29};
  byte[] n={31};
  //bm.printarray(given_adverb_byte);
  String []adverbtype1 = {"«õèñ¢","õ¤¬ó¾","Üö°"};
  String []adverbtype2 = {"Ü®è¢è®","Þù¤«ñô¢","Þù¤»ñ¢","ñÁð®»ñ¢","ñ¦í¢´ñ¢","ªñô¢ô"};
  String []adverbtype3 = {"à÷¢","âî¤ó¢","ð¤ù¢","ªõ÷¤","«ð£ô","«ð£ù¢Á","ªè£í¢´","«ï£è¢è¤","ðø¢ø¤","°ø¤î¢¶","²ø¢ø¤","õ¤ì¢´","îõ¤ó","ºù¢ù¤ì¢´","«õí¢®","åì¢®","ªð£Áî¢¶","ªð£Áî¢îõ¬ó","âù¢Á","ºù¢","²ø¢ø¤½ñ¢","Ýè","«ñô¢","è¦ö¢","âî¤ó¤ô¢","ðè¢èî¢î¤ô¢","Ü¼è¤ô¢","ñ£ø£è","«ïó£è","õ£ò¤ô£è","Íôñ£è","õö¤ò£è","«ðó¤ô¢","ªð£¼ì¢´","Ãì","õêñ¢","Þìñ¢","õ¬ó"};
  String []adverbtype4 = {"Ãê¢êô¢","ðê¢¬ê","ñë¢ê÷¢"};
//"õ¤ì","õ¤ì¾ñ¢","«ð£ô¢",,"ð¤ù¢","à÷¢","Þ¬ì«ò","ï´«õ","ñî¢î¤ò¤ô¢","ªõ÷¤«ò",,"ðî¤ô¢","àó¤ò","à÷¢÷","î°ï¢î","à¬ìò","«î£Áñ¢","Ýó"
  for(int i=0;i<adverbtype1.length;i++)
    if(given_adverb.equals(adverbtype1[i]))
          adverb_result=bm.addarray(given_adverb_byte,Constants.aaka);
  for(int i=0;i<adverbtype2.length;i++)
     if(given_adverb.equals(adverbtype2[i]))
          adverb_result=given_adverb_byte;
  for(int i=0;i<adverbtype3.length;i++)
      if(given_adverb.equals(adverbtype3[i]))
        if(bm.endswith(given_adverb_byte,L))
           adverb_result=bm.addarray(bm.addarray(given_adverb_byte,L),Constants.ee);
        else if(bm.endswith(given_adverb_byte,n))
           adverb_result=bm.addarray(bm.addarray(given_adverb_byte,n),Constants.ee);
         else
           adverb_result=bm.addarray(given_adverb_byte,Constants.ee);
  for(int i=0;i<adverbtype4.length;i++)
      if(given_adverb.equals(adverbtype4[i]))
          adverb_result=bm.addarray(given_adverb_byte,Constants.aay);

  return adverb_result;
 }

}