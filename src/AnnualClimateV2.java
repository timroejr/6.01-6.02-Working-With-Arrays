/**
 * 
 * @author timothyroejr
 * @version 7/2/15
 */

import java.util.Scanner;
public class AnnualClimateV2 {


	public static String [] temp = new String[12];
	public static String [] prec = new String[12];
	public static String [] month = new String[12];
	static class data {
		public void temperature() {
			temp[0] = "66.2";
			temp[1] = "67.2";
			temp[2] = "70.6";
			temp[3] = "73.8";
			temp[4] = "78.2";
			temp[5] = "81.2";
			temp[6] = "82.5";
			temp[7] = "82.8";
			temp[8] = "81.7";
			temp[9] = "78.1";
			temp[10] = "73.1";
			temp[11] = "68.3";
		}

		public void precipitation() {
			prec[0] = "3.8";
			prec[1] = "2.6";
			prec[2] = "3.7";
			prec[3] = "3.6";
			prec[4] = "5.4";
			prec[5] = "7.6";
			prec[6] = "6.0";
			prec[7] = "6.7";
			prec[8] = "8.1";
			prec[9] = "5.5";
			prec[10] = "5.6";
			prec[11] = "3.1";	
		}
		public void month() {
			month[0] = "Jan";
			month[1] = "Feb";
			month[2] = "Mar";
			month[3] = "Apr";
			month[4] = "May";
			month[5] = "Jun";
			month[6] = "Jul";
			month[7] = "Aug";
			month[8] = "Sep";
			month[9] = "Oct";
			month[10] = "Nov";
			month[11] = "Dec";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("C(elsius) or F(ahrenheit): ");
		String selection = in.nextLine();
		System.out.print("I(nches) or C(entimeters): ");
		String measurement = in.nextLine();
		System.out.println("\t\tClimate Data");
		System.out.println("\t\t************");
		System.out.println("\tLocation: West Palm Beach, FL");
		int index = 0;
		data d = new data();
		d.temperature();
		d.precipitation();
		d.month();
		double tempAverage = 0.0;
		double tempParse = 0.0;
		double precAverage = 0.0;
		double precParse = 0.0;
		double tempAverageRoundOff = 0.0;
		double precAverageRoundOff = 0.0;
		double precRoundOff = 0.0;
		double tempRoundOff = 0.0;
		double [] finalTemperature = new double[12];
		if (selection.equalsIgnoreCase("F")) {
			//System.out.println("Month\t Temperature\t Precepitation");
			for (int i = 0; i<12; i++){
				//System.out.println(month[index]+"\t "+temp[index]+"\t\t ");
				tempParse = Double.parseDouble(temp[index]);
				tempAverage += tempParse;
				finalTemperature[index] = tempParse;
				index++;
			}
			tempAverage = tempAverage/12;
			tempAverageRoundOff = Math.round(tempAverage*100.0)/100.0;
			//System.out.println("******************************");
			//System.out.println("Average: " + tempAverageRoundOff +"¼F\t " + precAverageRoundOff+"in");
		} else if (selection.equalsIgnoreCase("C")) {
			//System.out.println("Month\t Tempature\t Precepitation");
			for (int i = 0; i<12; i++) {
				tempParse = Double.parseDouble(temp[index]);
				tempParse = ((tempParse - 32)*5/9);
				tempRoundOff = Math.round(tempParse*100.0)/100.0;
				//System.out.println(month[index] + "\t "+tempRoundOff+"\t\t ");
				finalTemperature[index] = tempRoundOff;
				tempAverage += tempParse;
				precAverage += precParse;
				index++;
			}
			tempAverage = tempAverage/12;
			precAverage = precAverage/12;
			tempAverageRoundOff = Math.round(tempAverage*100.0)/100.0;
			precAverageRoundOff = Math.round(precAverage*100.0)/100.0;
			//System.out.println("******************************");
			//System.out.println("Average: " + tempAverageRoundOff +"¼C\t " + precAverageRoundOff+"cm");
		}
		index = 0;
		double [] finalMeasurments = new double[12];
		if (measurement.equalsIgnoreCase("I")) {
			for (int i = 0; i<12; i++){
				//System.out.println(prec[index]);
				precParse = Double.parseDouble(prec[index]);
				precAverage += precParse;
				finalMeasurments[index] = precParse;
				index++;
			}
			precAverage = precAverage/12;
			precAverageRoundOff = Math.round(precAverage*100.0)/100.0;
		} else if (measurement.equalsIgnoreCase("C")) {
			for (int i = 0; i<12; i++) {
				precParse = Double.parseDouble(prec[index]);
				precParse = (precParse*2.54);
				precRoundOff = Math.round(precParse*100.0)/100.0;
				//System.out.println(precRoundOff);
				precAverage += precParse;
				finalMeasurments[index] = precRoundOff;
				index++;
			}
			precAverage = precAverage/12;
			precAverageRoundOff = Math.round(precAverage*100.0)/100.0;
			//System.out.println("******************************");
			//System.out.println("Average: " + tempAverageRoundOff +"¼C\t " + precAverageRoundOff+"cm");
		}
		index = 0;
		System.out.println("Month\t Temperature\t Precepitation");
		for (int i = 0; i<12; i++) {
			System.out.printf(month[index] + "\t%.2f\t\t%.2f\n", finalTemperature[index], finalMeasurments[index]);
			index++;
		}
		System.out.println("******************************");
		String tempSetting = "";
		String measurementSetting = "";
		if (selection.equalsIgnoreCase("F")) {
			tempSetting = "¼F";
		} else if (selection.equalsIgnoreCase("C")) {
			tempSetting = "¼C";
		}

		if (measurement.equalsIgnoreCase("I")) {
			measurementSetting = "in";
		} else if (measurement.equalsIgnoreCase("C")) {
			measurementSetting = "cm";
		}
		//System.out.printf("Average: %10d%7d%,15d\n" + tempAverageRoundOff + tempSetting)
		System.out.printf("Average: %.2f%s\t%.2f%s", tempAverageRoundOff, tempSetting, precAverageRoundOff, measurementSetting);
	}


}
