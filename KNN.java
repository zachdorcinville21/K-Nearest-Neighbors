package kNearestNeighbors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * @author zacharydorcinville
 *
 */
public class KNN {

	public static void main(String[] args) throws IOException {
		Training test = new Training(6.3, 3.3, 6.0, 2.5, "Iris-virginica");
		System.out.println(kNN(5, test));
	}

	/**
	 * This method implements the k-nearest neighbors algorithm to deduce the
	 * type of a given example point
	 * 
	 */
	public static String kNN(int k, Training testPt) throws IOException {
		// initializations
		String y = "";
		int count = 0;
		String currentLine[] = null;
		String types[] = new String[77];
		double distances[] = new double[77];

		HashMap<Double, String> distMap = new HashMap<>();
		ArrayList<Training> trainingData = new ArrayList<>();
		FileReader freader = new FileReader("trainingdata.txt");
		Scanner inputFile = new Scanner(freader);

		// loop through the txt file containing training data
		while (inputFile.hasNext()) {
			currentLine = inputFile.nextLine().split(",");
			Training entry = new Training(Double.parseDouble(currentLine[0]), Double.parseDouble(currentLine[1]),
					Double.parseDouble(currentLine[2]), Double.parseDouble(currentLine[3]), currentLine[4]);
			trainingData.add(entry);

			// store the distances and labels in an array
			distances[count] = distance(testPt, entry);
			types[count] = entry.type;
			// store the distances such that they refer to a label in a
			// key-value manner
			distMap.put(distance(testPt, entry), entry.type);

			count++;
		}

		// display distances before sorting
		System.out.println("Unsorted Distances and their labels: ");
		for (int i = 0; i < distances.length; i++) {
			System.out.println(distances[i] + " --> " + types[i]);
		}

		Arrays.sort(distances);

		// display distances after sorting
		System.out.println("\n\nSorted Distances and their labels: ");
		for (int i = 0; i < distances.length; i++) {
			System.out.println(distances[i] + " --> " + distMap.get(distances[i]));
		}

		// show the k smallest distances and their label
		System.out.println("\nThe " + k + " nearest neighbors are:");
		// array to store the nearest neighbors
		double neighbors[] = new double[k];
		for (int i = 0; i < k; i++) {
			neighbors[i] = distances[i];
			System.out.println(distances[i] + " --> " + distMap.get(distances[i]));
		}

		// store the label that appears the most
		y += distMap.get(mode(neighbors, neighbors.length));

		inputFile.close();

		// return the majority label
		return "\nThe type of your test point is " + y;

	}

	/**
	 * Function to calculate the distance between two vectors
	 * 
	 */
	public static double distance(Training sample1, Training sample2) {
		double[] x1 = new double[4];
		double[] x2 = new double[4];
		double distance;

		// initialize vectors
		x1[0] = sample1.sepLen;
		x1[1] = sample1.sepWidth;
		x1[2] = sample1.petalLen;
		x1[3] = sample1.petalWidth;

		x2[0] = sample2.sepLen;
		x2[1] = sample2.sepWidth;
		x2[2] = sample2.petalLen;
		x2[3] = sample2.petalWidth;

		// calculate the distance
		distance = Math.sqrt(Math.pow((x1[0] - x2[0]), 2) + Math.pow((x1[1] - x2[1]), 2) + Math.pow((x1[2] - x2[2]), 2)
				+ Math.pow((x1[3] - x2[3]), 2));

		return round(distance, 2);
	}

	/**
	 * Helper method for rounding
	 * 
	 */
	private static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Helper method for calculating the mode
	 * 
	 */
	public static double mode(double a[], int n) {
		double maxValue = 0.0;
		double maxCount = 0.0;
		int i, j;

		for (i = 0; i < n; ++i) {
			int count = 0;
			for (j = 0; j < n; ++j) {
				if (a[j] == a[i])
					++count;
			}

			if (count > maxCount) {
				maxCount = count;
				maxValue = a[i];
			}
		}
		return maxValue;
	}

} 
