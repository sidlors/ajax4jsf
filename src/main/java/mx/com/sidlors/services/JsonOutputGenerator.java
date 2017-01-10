package mx.com.sidlors.services;

import mx.com.sidlors.interfaces.services.IOutputGenerator;

public class JsonOutputGenerator implements IOutputGenerator {
    public void generateOutput() {
	System.out.println("Json Output Generator");
    }
}