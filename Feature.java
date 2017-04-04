import java.util.*;

public class Feature {

	private int[] x, y;
	private Boolean[] vals;
	private int size;


	public Feature(int size, int pixels, Random rand){
		this.x = new int[pixels];
		this.y = new int[pixels];
		vals = new Boolean[pixels];
		this.size = size;
		setPixels(rand);
		setVals(rand);
	}

	public void setVals(Random rand){
		for(int i = 0; i < vals.length; i++){
			vals[i] = rand.nextBoolean();
		}
	}

	public void setPixels(Random rand){
		for(int i = 0; i < x.length; i++){
			int newX = rand.nextInt(size);
			int newY = rand.nextInt(size);
			while(duplicate(newX, newY)){
				newX = rand.nextInt(size);
				newY = rand.nextInt(size);
			}
			x[i] = newX;
			y[i] = newY;
		}
	}

	private boolean duplicate(int newX, int newY) {
		for(int i = 0; i < x.length; i++){
			if(x[i] == newX && y[i] == newY){
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		for(int i = 0; i < x.length; i++){
			System.out.println("[" + x[i] + ", " + y[i] + "]" + " == " + vals[i]);
		}
		System.out.println("");
	}
}
