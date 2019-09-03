package magisterka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Point;
import java.lang.Math;
public class StumpfCalibration{

	//estimated depth calculation for sounding point
	double Zest; 
	
	int m0=1;
	int m1=0;
	
	public double[] CalibrateStumpf(Map<Point,Double> pairMap, double Ri, double Rj){
		
		Double[] calibratedParams;
		double[] computedInitialValues = new double[pairMap.size()];
		double[] observedValues = new double[pairMap.size()];
		
		Ri = 5.5;
		Rj = 4.5;
		int i = 0;
		for(Entry<Point,Double> entry: pairMap.entrySet()) {
			Zest = m1*(Math.log(Ri)/Math.log(Rj))+m0;
			computedInitialValues[i] = Zest;			
			observedValues[i] = entry.getValue();
			i++;
		}
		//Zest = m1*(Math.log(Ri)/Math.log(Rj))-m0;
		
		Map<Point,Double> soundingPointPairMap = new HashMap<Point,Double>();
		
		
		double[] x = { 10, 20, 40, 80, 160, 200 };
        double[] y = { 100, 350, 1500, 6700, 20160, 40000 };
        PolynomialRegression regression = new PolynomialRegression(x, y, 2);

        // Use System.out.println() so that it works with either stdlib.jar or algs4.jar version
        System.out.println(regression);
		
		return null;
	}


	
	
}
