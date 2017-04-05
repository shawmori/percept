import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Setup {

	private List<Image> images;
	private List<Feature> features;
	private int size;
	private Perceptron perceptron;

	public Setup(String fname, int numFeatures){
		images = new ArrayList<Image>();
		load(fname);
		setFeatures(numFeatures);
		perceptron = new Perceptron(numFeatures, features);
	}

	private void setFeatures(int amount) {
		Random r = new Random(10);
		features = new ArrayList<Feature>();
		for(int i = 0; i < amount; i++){
			Feature f = new Feature(size, 4, r);
			features.add(f);
		}
		
	}

	public void load(String fname){
		Boolean[][] image;
		String category;
		int x, y;
		try{
			java.util.regex.Pattern bit = java.util.regex.Pattern.compile("[01]");
			File f = new File(fname);
			Scanner sc = new Scanner(f);
			while(sc.hasNext()){
				if(!(sc.next().equals("P1"))){
					sc.close();
					throw new IOException();
				}
				category = sc.next();
				x = sc.nextInt();
				y = sc.nextInt();
				size = x;
				image = new Boolean[x][y];
				for(int i = 0; i < y; i++){
					for(int j = 0; j < x; j++){
						image[i][j] = (sc.findWithinHorizon(bit,0).equals("1"));
					}
				}
				images.add(new Image(image, category));
			}
			sc.close();
		}catch(IOException e){
			System.out.println("File image not a P1 PBM image");
		}

	}

	public static void main(String[] args){
		new Setup(args[0], Integer.valueOf(args[1]));
	}
}
