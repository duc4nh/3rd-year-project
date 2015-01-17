package subPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import object.Interaction;
import object.InteractionCategory;
import database.InteractionDatabase;

/**
 * Generate interaction database from the csv file. Not for user.
 * 
 * @author DucAnh
 *
 */
public class InteGen2
{

	public static void main(String[] args)
	{
		try
		{
			File file = new File("inte.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				String[] str = line.split(",");
				InteractionCategory c;
				if (str[6].charAt(0) == 'A')
					c = InteractionCategory.ANIMAL;
				else if (str[6].charAt(0) == 'F')
					c = InteractionCategory.FOOD;
				else if (str[6].charAt(0) == 'H')
					c = InteractionCategory.HUMAN;
				else
					c = InteractionCategory.OBJECT;
				InteractionDatabase.add(new Interaction(Integer
				        .parseInt(str[0]), str[1], c, Integer.parseInt(str[2]),
				        Integer.parseInt(str[3]), Integer.parseInt(str[4]),
				        Integer.parseInt(str[5])));
			}
			fileReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		InteractionDatabase.printAllDetails();
		System.out.println("Size: " + InteractionDatabase.getSize());
		InteractionDatabase.save();
	}
}