package Date;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadCSV {
	static double [][] mat;

	public static double[][] readFile(String fileName,int row,int colum) throws IOException{
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		 scanner.useDelimiter(",|\r\n");
		int NumOfSamples =row;
		int NumOfAttributesReal = colum;
		int numOfAtt=3;
		scanner.nextLine();
	
		//transform data from file into TrainRecord objects
		mat = new double[NumOfSamples][NumOfAttributesReal];
		
		int classLabel = -1;
		int indexTrain=0;
		
		//read half from male to trainSet
		for (indexTrain=0; indexTrain<(NumOfSamples) && scanner.hasNext(); indexTrain++){
			int k=0;
			for(int i = 0; i < NumOfAttributesReal; i ++){				
				String s=scanner.next();
				if (s.equals(""))
					mat[indexTrain][i]=0;
				mat[indexTrain][i] = Double.parseDouble(s);
			}
			
	
			assert (mat[indexTrain][70] == 0 || mat[indexTrain][70]==1): "Reading class label is wrong!";
		}
		
		for (int i=0;i<3;i++)
			System.out.println(Arrays.toString(mat[i]));
		
		return mat;
		
	}
	/*
	public static void main(String[] args) throws IOException {
		mat=readFile("C:/Users/Roey/Documents/לימודים/מדעי המחשב/שנה ג סמסטר ב/למידת מכונה/Speed Dating Data half.csv",4360,55);
	}
	*/
}
