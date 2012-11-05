package Diagnosticador.Android.Version1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import weka.core.Instances;
import weka.core.Utils;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.Evaluation;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class DiagnosticadorAndroidActivity extends Activity {
	
	
	
    

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	//TextView tv = new TextView(this);
    	setContentView(R.layout.main);      
    	Button Diagnosticador = (Button)findViewById(R.id.btnDiagnosticar);
    	final TextView Listo = (TextView)findViewById(R.id.Tlisto);
    	
    	Diagnosticador.setOnClickListener(new View.OnClickListener() {
    		
    		public void onClick(View v) {
//				// Action with the click
    			
    			
    			//Get the text file Weka
    		      File reader = new File (Environment.getExternalStorageDirectory().toString() + "/Tesis");
    		      //File reader = new File (Environment.getExternalStorageDirectory().toString() + "C:/Users/user/workspace");
    		      reader.mkdirs();
    		      File file = new File(reader, "Weka.arff");

    		      //Read text from file
    		      StringBuilder text = new StringBuilder();
    		      //FileOutputStream fOut;

    		          try {
    		        	  BufferedReader br = new BufferedReader(new FileReader(file));
    		        	  double percent = 10.0;
          		          Instances inst = null;
          		    	  inst = new Instances(br);//aqui sale el error al crear las instancias, antes no salian
          		    	  inst.setClassIndex(inst.numAttributes()-1);//supongo que es por como se esta leyendo
    	    		      String line;
    	    		      while ((line = br.readLine()) != null) {
						      text.append(line);
						      text.append('\n');
						  }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		        //Get the text file Text
        		      File Test = new File (Environment.getExternalStorageDirectory().toString() + "/Tesis");
        		      Instances instTest = null;
        		      //File reader = new File (Environment.getExternalStorageDirectory().toString() + "C:/Users/user/workspace");
        		      reader.mkdirs();
        		      File file1 = new File(reader, "Test.arff");

        		      //Read text from file
        		      StringBuilder text1 = new StringBuilder();
        		      //FileOutputStream fOut;

        		          try {
        		        	  BufferedReader br1 = new BufferedReader(new FileReader(file1));
        	    		      String line;
        	    		      instTest = new Instances(br1);
        	    		      while ((line = br1.readLine()) != null) {
    						      text1.append(line);
    						      text1.append('\n');
    						  }
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        		        
        		        //
        		        //
        		        //instTest.setClassIndex(instTest.numAttributes()-1);
        		        //MultilayerPerceptron mlp = new MultilayerPerceptron();
    		      
        		  
    		      //Find the view by its id
    		      //TextView tv = (TextView)findViewById(R.id.Tlisto);

    		      //Set the text
    		      Listo.setText(text);
    		      Listo.setText(text1);
    			
    		}
    	
    		
    	});
    	
      
        
        
        
//        TextView tv = new TextView(this);
//        setContentView(R.layout.main);
//        
//        Button Diagnosticador = (Button)findViewById(R.id.btnDiagnosticar);
//        final TextView Listo = (TextView)findViewById(R.id.Tlisto);
//        Diagnosticador.setOnClickListener(new View.OnClickListener() {
//        				
//			public void onClick(View v) {
//				// Action with the click
//        	FileReader reader = null;
//        	
//        	try {
//        		reader = new FileReader("C:/Users/user/workspace/weka.arff");
//        	} catch (FileNotFoundException e) {
//        		// TODO Auto-generated catch block
//        			e.printStackTrace();
//        	}
//        	FileReader Test = null;
//        	try {
//        		Test = new FileReader("C:/Users/user/workspace/Test.arff");
//        	} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//        		e.printStackTrace();
//        	}
//        	double percent = 10.0;
//
//        	Instances inst = null;
//        	try {
//        		inst = new Instances(reader);
//        	} catch (IOException e) {
//					// TODO Auto-generated catch block
//        		e.printStackTrace();
//        	}  // your full training set
//				
//        	Instances instTest = null;
//        	try {
//        		instTest = new Instances(Test);
//        	} catch (IOException e) {
//					// TODO Auto-generated catch block
//        		e.printStackTrace();
//        }  // your full training set
//				
//        inst.setClassIndex(inst.numAttributes()-1);
//        	instTest.setClassIndex(instTest.numAttributes()-1);
//        	MultilayerPerceptron mlp = new MultilayerPerceptron();
//        	try {
//					//
//					//Aqui es donde configuro la red, es decir le digo cuantas epocas, capas ocultas,etc
//					//
//        		mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 20"));
//        	} catch (Exception e) {
//        		// TODO Auto-generated catch block
//        		e.printStackTrace();
//        	}
//				//System.out.println("Performing " + percent + "% split evaluation.");
//			      
//        	Instances train = new Instances(inst);
//        	Instances test = new Instances(instTest);
//        	try {
//        		mlp.buildClassifier(train);
//        	} catch (Exception e) {
//					// TODO Auto-generated catch block
//        		e.printStackTrace();
//        	}
//				
//        	try{
//        	FileWriter Out = new FileWriter("C:/Users/user/workspace/weka.arff");
//        	BufferedWriter out = new BufferedWriter(Out);
//        	for (int i = 0; i < test.numInstances(); i++) {
//
//        	   double pred = 0;
//        		try {
//        			pred = mlp.classifyInstance(test.instance(i));
//        		} catch (Exception e) {
//						// TODO Auto-generated catch block
//        			e.printStackTrace();
//        		}
//					
//
//					
//					//out.write("ID: " + test.instance(i));
//					//out.write(", actual: " + test.classAttribute().value((int) test.instance(i).classValue()));
//					//out.write(", predicted: " + test.classAttribute().value((int) pred));
//					//out.write("\n");
//					
//					//System.out.print("ID: " + test.instance(i));  
//
//					//System.out.print(", actual: " + test.classAttribute().value((int) test.instance(i).classValue()));  
//
//					//System.out.println(", predicted: " + test.classAttribute().value((int) pred));  
//
//        		 }
//				
//        	try {
//        		Evaluation eval = new Evaluation(train);
//        		eval.evaluateModel(mlp, test);
//					//System.out.println(eval.toSummaryString("\nResults\n======\n", false));
//					//out.write(eval.toSummaryString("\nResults\n======\n", false));
//        		reader.close();
//        		out.close();
//					
//
//
//        	} catch (Exception e) {
//					// TODO Auto-generated catch block
//        e.printStackTrace();
//						}
//        	} catch (Exception e) {
//					// TODO Auto-generated catch block
//        		e.printStackTrace();
//        	}
//        	Listo.setText("Diagnostico Realizado!!");
//				
//				
//			}
//        });
         
    }
}