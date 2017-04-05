import java.util.*;

public class Perceptron {
	
	private List<Double> weights;
	private List<Feature> features;
	
	public Perceptron(int size, List<Feature> features){
		this.features = features;
		setWeights(size);
		for(Double d  : weights)
			System.out.println(d);
	}

	private void setWeights(int size) {
		weights = new ArrayList<Double>();
		Random r = new Random(10);
		for(int i = 0; i < size + 1; i++){
			weights.add(r.nextDouble());
		}
		
	}
}
