package pa06;

import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample) and a list of Samples
 * (the one's closest to that sample point, ideally).
 *
 */
public class Cluster {
	private Sample clusterPt;
	private ArrayList<Sample> samples;

	public Cluster(ArrayList<Sample> samples) {
		this.samples = samples;
	}

	public Cluster(Sample clusterPt, ArrayList<Sample> samples) {
		this(samples);
		this.clusterPt = clusterPt;
	}

	// This method picks a random sample from the cluster
	public Sample randomSample() {
		Random rand = new Random();
		int randNum = rand.nextInt(this.samples.size());
		return this.samples.get(randNum);
	}

	// This method returns the average Sample in a cluster
	public Sample average() {
		ArrayList<Double> averageCoordinates = new ArrayList<Double>();
		int sampleNum = this.samples.size();
		int coordinateNum = this.samples.get(0).getSample().size();

		for (int i = 0; i < coordinateNum; i++) {
			double sumCoordinate = 0;
			for (int j = 0; j < sampleNum; j++) {
				sumCoordinate += this.samples.get(j).getSample().get(i);
			}
			averageCoordinates.add(sumCoordinate / sampleNum);
		}
		Sample average = new Sample(averageCoordinates);
		return average;
	}

	// This method prints a cluster
	public String printCluster() {
		String output = "";
		for (Sample samp : this.samples) {
			output += String.format("%s%n", samp.toString());
		}
		return output;
	}
	
	public Sample getClusterPt() {
		return this.clusterPt;
	}
	
	public void setClusterPt(Sample ClusterPt) {
		this.clusterPt=ClusterPt;
	}
	
	public ArrayList<Sample> getSamples(){
		return this.getSamples();
	}
	
	public void setSamples(ArrayList<Sample> samples) {
		this.samples=samples;
	}

	// this main method tests the Cluster class (can be deleted later)
	public static void main(String[] args) {
		System.out.println("testing for the Cluster class.");
		ArrayList<Double> p1 = new ArrayList<Double>();// double[] p1 = {1,2};
		p1.add(1.0);
		p1.add(2.0);
		ArrayList<Double> p2 = new ArrayList<Double>();//// double[] p2 = {1,5};
		p2.add(1.0);
		p2.add(5.0);
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		ArrayList<Sample> rows = new ArrayList<Sample>();
		rows.add(s1);rows.add(s2);
		Cluster c1 = new Cluster(rows);
		System.out.println("random pt=" + c1.randomSample());
		System.out.printf("%s%n%s", "cluster:", c1.printCluster());
		System.out.println("average=" + c1.average());
	}
}
