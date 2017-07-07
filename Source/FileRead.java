import java.io.*;
/** This is the main class which is used for reading files
  * to get the auxillary verb,verb category & gender endings */
public class FileRead
{
	File inputFile = null;
    /**Constructor*/
	public FileRead()
	{

	}
	/** main method in which file read object is created*/
	public static void main(String args[])
	{
		FileRead fr = new FileRead();
		System.out.println(fr.getAuxString("ªè£÷¢","auxiliary.txt",2));
		System.out.println(fr.getAuxString("Ü¶","genderendings.txt",1));

		System.out.println(fr.getVerbCat("ð®","verbcat.txt"));
		System.out.println(fr.getAuxCat("ªè£÷¢","auxiliary.txt"));

	}

	/** This method gets the auxillary verb from the file
	  * when the file name, the root auxillary,
	  * and the record no is given*/
	public String getAuxString(String rootaux,String fileName,int no)
	{
		String auxinf = "";
		try
		{

				StreamTokenizer input = new StreamTokenizer(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName))));
				input.eolIsSignificant(true);

				int tokentype = 0;

				while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
				{

					if(!input.sval.equals(rootaux))
					{

						do{
							tokentype = input.nextToken();

							if(tokentype == StreamTokenizer.TT_EOF)
							{
								System.out.println("It is EOF");
								return null;
							}
							if(tokentype == StreamTokenizer.TT_EOL)
								break;
							else;

						  }while(!(tokentype == StreamTokenizer.TT_EOL));
					}
					else
					{
						for(int i=0;i<no;i++)
						{
							input.nextToken();
						}
						return input.sval;
					}

				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return auxinf;
		}

	/** This method gets the verb category for the given root auxillary*/
	public int getVerbCat(String rootaux,String fileName)
	{
		int verbcat = 0;
		try
		{

				StreamTokenizer input = new StreamTokenizer(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName))));
				//input.eolIsSignificant(true);

				int tokentype = 0;
				boolean string = true;
				while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
				{
				   if(string)
				   {
					string = false;
					if(input.sval.equals(rootaux))
					{
						input.nextToken();
						return (int)input.nval;
					}

					}
				   else
				      string = true;
				  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return verbcat;
		}

	/** This method gets the auxillary category when
	  * the root auxillary is given*/
	public int getAuxCat(String rootaux,String fileName)
	{
		int auxcat = 0;
		try
		{

				StreamTokenizer input = new StreamTokenizer(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName))));
				input.eolIsSignificant(true);

				int tokentype = 0;

				while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
				{

					if(!input.sval.equals(rootaux))
					{

						do{
							tokentype = input.nextToken();

							if(tokentype == StreamTokenizer.TT_EOF)
							{
								System.out.println("It is EOF");
								return 0;
							}
							if(tokentype == StreamTokenizer.TT_EOL)
								break;
							else;

						  }while(!(tokentype == StreamTokenizer.TT_EOL));
					}
					else
					{
						input.nextToken();
						return (int)input.nval;
					}

				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return auxcat;
		}

	/** This method generates the gender endings when the subject
	  * and the file is given*/
		public String getGenderEnding(String subject,String file)
		{
			return getAuxString(subject,file,1);
		}
}



