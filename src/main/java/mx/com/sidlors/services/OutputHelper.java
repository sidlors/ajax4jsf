package mx.com.sidlors.services;

import mx.com.sidlors.interfaces.services.IOutputGenerator;

public class OutputHelper {
    IOutputGenerator outputGenerator;
    
    
    
    
    public OutputHelper() {

    }

    //Asignacion de Dependencia por Constructor
    public OutputHelper(IOutputGenerator outputGenerator) {
	this.outputGenerator = outputGenerator;
    }

    public void generateOutput() {
	outputGenerator.generateOutput();
    }

  //Asignacion de Dependencia por metodo Set
    public void setOutputGenerator(IOutputGenerator outputGenerator) {
	this.outputGenerator = outputGenerator;
    }


    

}