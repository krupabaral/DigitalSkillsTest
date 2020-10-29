import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String InputFilePath = "C:\\Krupa\\Employment\\TechnicalTest\\archive\\car_input.txt";
		String OutputFilePath = "C:\\Krupa\\Employment\\TechnicalTest\\archive\\car_output.txt";
		
		ArrayList<String> ReadRegNumber = new ReadData().ReadInputFile(InputFilePath);
		
		for (int j=0; j<=ReadRegNumber.size() - 1; j++) {
			String RegNum = ReadRegNumber.get(j);
			
			ArrayList<String> ReadOutput = new ReadData().ReadOutputFile(OutputFilePath,RegNum);
			ArrayList<String> DataFromPage = new GetDataFromPage().GetData(RegNum);

			//System.out.println(CollectionUtils.isEqualCollection(listA, listB));
			
			String Status = null;
			 boolean isEqual = DataFromPage.equals(ReadOutput); 
			 System.out.println(isEqual);
			 if (isEqual == true) {
				 Status = "Pass";
			 }
			 else if (isEqual == false) {
				 Status = "Fail";
			 }
			 
			System.out.println(RegNum + "-" + Status);

		}
		
	
	}

}
